package codeclan.com.yatzee.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import codeclan.com.yatzee.Dices.Dice;
import codeclan.com.yatzee.TheGame.Game;
import codeclan.com.yatzee.Players.Player;
import codeclan.com.yatzee.R;
import codeclan.com.yatzee.TheRoll.Roll;
import codeclan.com.yatzee.TheScoreButtons.AllScoreButtons;
import codeclan.com.yatzee.TheScoreButtons.ScoreButton;
import codeclan.com.yatzee.TheScoreButtons.ScoreButtonAdaptor;
import codeclan.com.yatzee.TheScoreButtons.Strategy;

import static java.lang.Integer.max;
import static java.lang.Math.min;

public class MainActivity extends AppCompatActivity {

    private ImageButton diceOne;
    private ImageButton diceTwo;
    private ImageButton diceThree;
    private ImageButton diceFour;
    private ImageButton diceFive;
    private ArrayList<ImageButton> diceButtons;
    private Button rollButton;


    private Game game;
    private Roll roll;
    private ArrayList<Dice> dice;

    private Player player1;
    private Player player2;
    private Player activePlayer;

    private TextView playerOneText;
    private TextView playerTwoText;
    private TextView playerOneScore;
    private TextView playerTwoScore;

    private Boolean hasDiceBeenRolled;
    private boolean hasPlayerSelectedScored;
    private Strategy previouslySelectedScore;

    private AllScoreButtons allScoreButtons;
    private ArrayList<ScoreButton> scoreButtonList;

    private ScoreButtonAdaptor buttonAdapter;
    private ListView buttonListView;
    private Integer currentPositionIndex;
    ScoreButtonAdaptor buttonAdaptor;

    private Button playButton;


    private TextView winningMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();
        this.hasPlayerSelectedScored = false;
        this.hasDiceBeenRolled = false;
        roll = game.getRoll();
        dice = new ArrayList<>();

        diceOne = findViewById(R.id.dice_button_one);
        diceTwo = findViewById(R.id.dice_button_two);
        diceThree = findViewById(R.id.dice_button_three);
        diceFour = findViewById(R.id.dice_button_four);
        diceFive = findViewById(R.id.dice_button_five);

        diceButtons = new ArrayList<>();
        diceButtons.add(diceOne);
        diceButtons.add(diceTwo);
        diceButtons.add(diceThree);
        diceButtons.add(diceFour);
        diceButtons.add(diceFive);

        playerOneScore = findViewById(R.id.player1_total_score);
        playerOneScore.setText(game.getPlayer1().getScore().toString());

        playerTwoScore = findViewById(R.id.player2_total_score);
        playerTwoScore.setText(game.getPlayer2().getScore().toString());

        playerOneText = findViewById(R.id.player1_text);
        playerTwoText = findViewById(R.id.player2_text);
        playerOneText.setBackgroundColor(Color.GRAY);

        player1 = game.getPlayer1();
        player2 = game.getPlayer2();
        activePlayer = game.getActivePlayer();

        allScoreButtons = game.getAllScoreButtons();
        scoreButtonList = allScoreButtons.getScoreButtons();
        buttonAdapter = new ScoreButtonAdaptor(this, scoreButtonList);
        buttonListView = findViewById(R.id.score_list);
        buttonListView.setAdapter(buttonAdapter);

        currentPositionIndex = buttonListView.getFirstVisiblePosition();
        ListView buttonListView = findViewById(R.id.score_list);

        buttonAdaptor = new ScoreButtonAdaptor(this, scoreButtonList);
        buttonListView.setAdapter(buttonAdaptor);

        rollButton = findViewById(R.id.roll_button);
        int rollNumber = 1;
        rollButton.setText(getString(R.string.first_roll, rollNumber));
        playButton = findViewById(R.id.play_button);
        playButton.setEnabled(false);

//        refreshList();

    }

    public void refreshList() {

        buttonAdaptor.notifyDataSetChanged();
//        Integer currentIndex = buttonListView.getFirstVisiblePosition();
//        Log.d("index position: ", currentIndex.toString());
//        buttonListView.setSelection(currentIndex);

    }


    public void onDiceButtonClick(View diceClickView) {

        ImageButton diceButton = (ImageButton) diceClickView;
        diceButton.clearColorFilter();

        Dice die = (Dice) diceClickView.getTag();
        die.changeHeldStatus();

        if( die.isHeld() == true) {
            diceButton.setColorFilter(R.color.grey_out);
        }
    }

    public void onRollButtonClick(View rollClickView) {
        playButton.setEnabled(true);

        int rollNumber = min(roll.getRollCount() + 2, 3);
        String rollNumberMsg = getString(R.string.first_roll, rollNumber);
        String rollFinished = getString(R.string.finished_roll);
        Log.d("finished? :", rollFinished);

        rollButton.setText(rollNumberMsg);

        if (roll.getRollCount() >= 2) {
            rollButton.setText(rollFinished);
            rollButton.setEnabled(false);
        }
        hasDiceBeenRolled = true;

        Log.e("test: ", "working?");

        if (game.getActivePlayer().getTurnsTaken() == 13) {
            return;
        }


        else if (roll.getRollCount() == 0) {
                dice = roll.firstFullRollOfDice();
        }
        else {
                dice = roll.reRollDice();
        }


        for (int i=0; i < 5; i++) {
            String imageName = dice.get(i).getDiceType().getImage();
            Integer resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            diceButtons.get(i).setImageResource(resID);
            diceButtons.get(i).setTag(dice.get(i));
        }


//        rollButton.setText(R.string.other_roll);

    }

    public void onP1ScoreButtonClick(View buttonListView) {
        Log.d("has been rolled test", hasDiceBeenRolled.toString());
        if (!hasDiceBeenRolled || !player1.isActivePlayer()) { return;}

        ScoreButton selectedP1Score = (ScoreButton) buttonListView.getTag();
        if (selectedP1Score.getP1ScoreValue() != null) {return;}

        if(!hasPlayerSelectedScored) {

            ScoreButton scoreButton = null;

            for(ScoreButton button : scoreButtonList) {
                if(button.getStrategyType() == selectedP1Score.getStrategyType()) {
                    scoreButton = button;
                }
            }

            Integer p1Score = scoreButton.calculateScore(roll);
            scoreButton.setP1ScoreValue(p1Score);
            hasPlayerSelectedScored = true;
            previouslySelectedScore = selectedP1Score.getStrategyType();


        } else {
            ScoreButton scoreButton = null;

            for(ScoreButton button : scoreButtonList) {
                if(button.getStrategyType() == previouslySelectedScore) {
                    scoreButton = button;
                }
            }

            scoreButton.setP1ScoreValue(null);


            Integer p1Score = selectedP1Score.calculateScore(roll);

            for(ScoreButton button : scoreButtonList) {
                if(button.getStrategyType() == selectedP1Score.getStrategyType()) {
                    scoreButton = button;
                }
            }

            scoreButton.setP1ScoreValue(p1Score);

            previouslySelectedScore = selectedP1Score.getStrategyType();

        }

        Log.d("test array of buttons.", scoreButtonList.toString());

        ArrayList<ScoreButton> myNewData = scoreButtonList;

//        buttonAdapter.updateData(myNewData);  //update adapter's data
//        myAdapter.notifyDataSetChanged();

        refreshList();
    }

    public void onP2ScoreButtonClick(View buttonListView) {
        Log.d("has been rolled test", hasDiceBeenRolled.toString());
        if (!hasDiceBeenRolled || !player2.isActivePlayer()) { return;}

        ScoreButton selectedP2Score = (ScoreButton) buttonListView.getTag();
        if (selectedP2Score.getP2ScoreValue() != null) {return;}

        if(!hasPlayerSelectedScored) {

            ScoreButton scoreButton = null;

            for(ScoreButton button : scoreButtonList) {
                if(button.getStrategyType() == selectedP2Score.getStrategyType()) {
                    scoreButton = button;
                }
            }

            Integer p2Score = scoreButton.calculateScore(roll);
            scoreButton.setP2ScoreValue(p2Score);
            hasPlayerSelectedScored = true;
            previouslySelectedScore = selectedP2Score.getStrategyType();


        } else {
            ScoreButton scoreButton = null;

            for(ScoreButton button : scoreButtonList) {
                if(button.getStrategyType() == previouslySelectedScore) {
                    scoreButton = button;
                }
            }

            scoreButton.setP2ScoreValue(null);


            Integer p2Score = selectedP2Score.calculateScore(roll);

            for(ScoreButton button : scoreButtonList) {
                if(button.getStrategyType() == selectedP2Score.getStrategyType()) {
                    scoreButton = button;
                }
            }

            scoreButton.setP2ScoreValue(p2Score);

            previouslySelectedScore = selectedP2Score.getStrategyType();

        }

        refreshList();

    }



    public void onPlayButtonClick(View playClickLView) {
//        refreshList();
        Log.d("active player? : ", game.getActivePlayer().toString());
        Log.d("player1 active? : ", game.getPlayer1().isActivePlayer().toString());
        Log.d("player2 active? : ", game.getPlayer2().isActivePlayer().toString());
        Log.d("has been rolled test", hasDiceBeenRolled.toString());
        Log.d("test array of values: ", game.getActivePlayerScores().toString());

        Log.d("p1 score test: ", allScoreButtons.getP1Scores().toString());
        Log.d("p2 score test: ", allScoreButtons.getP2Scores().toString());

        hasPlayerSelectedScored = false;


        if (playButton.getText() == getString(R.string.play_again)) {
            player1.resetScore();
            player2.resetScore();
            playerOneScore.setText(player1.getScore().toString());
            playerTwoScore.setText(player2.getScore().toString());
            player1.setTurnsTaken(0);
            player2.setTurnsTaken(0);
            roll.resetRollCount();
            rollButton.setText(R.string.first_roll);
            playButton.setText(R.string.play);
            playerOneText.setBackgroundColor(Color.GRAY);
            playerTwoText.setBackgroundColor(0);
//            winningMessage.setText(null);
            return;
        }

       game.getActivePlayer().increaseTurnsTaken();

        if (roll.getRollCount() == 0) {
            return;
        }

        game.setActivePlayerScore(game.getActivePlayerScores());

        Log.d("score test: ", game.getActivePlayer().getScore().toString());



        roll.clearDice();

        for (int i=0; i < 5; i++) {
            diceButtons.get(i).setImageResource(android.R.drawable.checkbox_off_background);
            diceButtons.get(i).clearColorFilter();

        }

        rollButton.setText(R.string.first_roll);

        playerOneScore.setText(player1.getScore().toString());
        playerTwoScore.setText(player2.getScore().toString());

        player1.changeActivePlayerStatus();
        player2.changeActivePlayerStatus();

        if (player1 == game.getActivePlayer() ) {
            playerTwoText.setBackgroundColor(0);
            playerOneText.setBackgroundColor(Color.GRAY);
        }
        else {
            playerOneText.setBackgroundColor(0);
            playerTwoText.setBackgroundColor(Color.GRAY);
        }

        if (player1.getTurnsTaken() + player2.getTurnsTaken() == 26) {

                playButton.setText(R.string.play_again);
                playerOneText.setBackgroundColor(0);
                playerTwoText.setBackgroundColor(0);


//                winningMessage = findViewById(R.id.winner_msg);
//                if (player1.getScore() == player2.getScore()) {
//                    winningMessage.setText(R.string.draw);
//                }
//                else if(player1.getScore() > player2.getScore()) {
//                    winningMessage.setText(R.string.player1_win);
//                }
//                else {
//                    winningMessage.setText(R.string.player2_win);
//                }


            }
        hasDiceBeenRolled = false;

        int rollNumber = min(roll.getRollCount() + 1, 3);
        rollButton.setText(getString(R.string.first_roll, rollNumber));

        rollButton.setEnabled(true);
        playButton.setEnabled(false);

        }

}
