package codeclan.com.yatzee.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

import static java.lang.Integer.TYPE;
import static java.lang.Integer.max;
import static java.lang.Math.min;

public class MainActivity extends MenuActivity {

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
    private Integer player1Score;
    private Integer player2Score;
    private Player activePlayer;

    private TextView playerOneText;
    private TextView playerTwoText;

    private String playerOneScore;
    private String playerTwoScore;

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

    private View player1Display;
    private View player2Display;


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


        player1Score = game.getPlayer1().getScore();
        player2Score = game.getPlayer2().getScore();

        playerOneScore = getString(R.string.player1_score, player1Score);
        playerTwoScore = getString(R.string.player2_score, player2Score);

        playerOneText = findViewById(R.id.player1_text);
        playerTwoText = findViewById(R.id.player2_text);

        playerOneText.setText(playerOneScore);
        playerTwoText.setText(playerTwoScore);

        playerOneText.setTextSize(26);
        playerOneText.setTypeface(null, Typeface.BOLD);

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

    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void refreshList() {
        buttonAdaptor.notifyDataSetChanged();
    }


    public void onDiceButtonClick(View diceClickView) {
        ImageButton diceButton = (ImageButton) diceClickView;
        diceButton.clearColorFilter();

        Dice die = (Dice) diceClickView.getTag();
        die.changeHeldStatus();

        if (die.isHeld() == true) {
            diceButton.setColorFilter(R.color.grey_out);
        }
    }

    public void onRollButtonClick(View rollClickView) {
        int rollNumber = min(roll.getRollCount() + 2, 3);
        String rollNumberMsg = getString(R.string.first_roll, rollNumber);
        String rollFinished = getString(R.string.finished_roll);


        rollButton.setText(rollNumberMsg);

        if (roll.getRollCount() >= 2) {
            rollButton.setText(rollFinished);
            rollButton.setEnabled(false);
        }
        hasDiceBeenRolled = true;


        if (game.getActivePlayer().getTurnsTaken() == 13) {
            return;
        } else if (roll.getRollCount() == 0) {
            dice = roll.firstFullRollOfDice();
        } else {
            dice = roll.reRollDice();
        }


        for (int i = 0; i < 5; i++) {
            String imageName = dice.get(i).getDiceType().getImage();
            Integer resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            diceButtons.get(i).setImageResource(resID);
            diceButtons.get(i).setTag(dice.get(i));
        }

        if (roll.doesContainMultipleOfAnyDieValue(5)) {
            Toast toast = Toast.makeText(this, R.string.yatzee, Toast.LENGTH_LONG);

            ViewGroup group = (ViewGroup) toast.getView();
            TextView messageTextView = (TextView) group.getChildAt(0);
            messageTextView.setTextSize(40);
            messageTextView.setBackgroundColor(getResources().getColor(R.color.yellow));
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

    }

    public void onP1ScoreButtonClick(View buttonListView) {
        ScoreButton selectedScore = (ScoreButton) buttonListView.getTag();
        actionScoreButtonForActivePlayer(player1, selectedScore);
    }


    public void onP2ScoreButtonClick(View buttonListView) {
        ScoreButton selectedScore = (ScoreButton) buttonListView.getTag();
        actionScoreButtonForActivePlayer(player2, selectedScore);
    }


    public void actionScoreButtonForActivePlayer(Player player, ScoreButton selectedScore) {

        if (!hasDiceBeenRolled || !player.isActivePlayer()) {return;}

        if (hasPlayerSelectedScored){

            if (selectedScore.getStrategyType() == previouslySelectedScore) {
                game.setScoreOfButtonForPlayer(selectedScore, player, null);
                refreshList();
                hasPlayerSelectedScored = false;
                playButton.setEnabled(false);
                return;
            }
        }

        if (game.getScoreOfButtonForPlayer(selectedScore, player) != null) {
            return;}

        if (player.isActivePlayer() && hasDiceBeenRolled) {playButton.setEnabled(true);}

        if (!hasPlayerSelectedScored) {
            setSelectedButtonScore(selectedScore,player);
            hasPlayerSelectedScored = true;
        } else {
            ScoreButton selectedButton = findSelectedButtonByStrategy(previouslySelectedScore);
            game.setScoreOfButtonForPlayer(selectedButton, player, null);
            setSelectedButtonScore(selectedScore,player);
        }

        refreshList();
    }


    public void onPlayButtonClick(View playClickLView) {
     hasPlayerSelectedScored = false;


        if (playButton.getText() == getString(R.string.play_again)) {
            player1.resetScore();
            player2.resetScore();
            player1Score = game.getPlayer1().getScore(); /** TODO: ***/
            player2Score = game.getPlayer2().getScore();
            playerOneScore = getString(R.string.player1_score, player1Score);
            playerTwoScore = getString(R.string.player2_score, player2Score);
            playerOneText.setText(playerOneScore);
            playerTwoText.setText(playerTwoScore);
            player1.setTurnsTaken(0);
            player2.setTurnsTaken(0);
            setActivePlayerBanner(player2Display, player1Display, playerTwoText, playerOneText);
            roll.resetRollCount();
            int rollNumber = min(roll.getRollCount() + 1, 3);
            rollButton.setText(getString(R.string.first_roll, rollNumber));
            rollButton.setEnabled(true);
            playButton.setText(R.string.play);
            playButton.setEnabled(false);
            winningMessage.setText("");
            allScoreButtons.setAllScoresToNull();
            refreshList();
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

            diceButtons.get(i).setImageResource(0);
            diceButtons.get(i).clearColorFilter();

        }

        rollButton.setText(R.string.first_roll);

        player1Score = game.getPlayer1().getScore();  /** TODO: ***/
        player2Score = game.getPlayer2().getScore();
        playerOneScore = getString(R.string.player1_score, player1Score);
        playerTwoScore = getString(R.string.player2_score, player2Score);
        playerOneText.setText(playerOneScore);
        playerTwoText.setText(playerTwoScore);

        game.changeTurns();

        activePlayer = game.getActivePlayer();

        player1Display = findViewById(R.id.rectangle_player1);
        player2Display = findViewById(R.id.rectangle_player2);

        if (player1 == game.getActivePlayer() ) {
            setActivePlayerBanner(player1Display, player2Display, playerOneText, playerTwoText);
        }
        else {
            setActivePlayerBanner(player2Display, player1Display, playerTwoText, playerOneText);
        }

        rollButton.setEnabled(true);
        playButton.setEnabled(false);

        if (game.hasGameFinished()) {

            resetTitleDisplay(player1Display, playerOneText);
            resetTitleDisplay(player2Display, playerTwoText);

                playButton.setText(R.string.play_again);

                rollButton.setEnabled(false);
                playButton.setEnabled(true);

            winningMessage = findViewById(R.id.winner_msg);
            String message = game.getWinningMessage();
            Integer resIDMessage = getResources().getIdentifier(message, "string", getPackageName());
            winningMessage.setText(resIDMessage);
            }

        hasDiceBeenRolled = false;

        int rollNumber = min(roll.getRollCount() + 1, 3);
        rollButton.setText(getString(R.string.first_roll, rollNumber));
        }

    public void setSelectedButtonScore(ScoreButton scoreButton, Player player){
        ScoreButton selectedButton = findSelectedButtonByStrategy(scoreButton.getStrategyType());
        Integer score = selectedButton.calculateScore(roll);
        game.setScoreOfButtonForPlayer(selectedButton, player, score);
    }

    public ScoreButton findSelectedButtonByStrategy(Strategy strategy) {
        ScoreButton scoreButton = null;
        for (ScoreButton button : scoreButtonList) {
            if (strategy == button.getStrategyType()) {
                scoreButton = button;
            }
        }
        previouslySelectedScore = strategy;
        return scoreButton;
    }

    public void resetTitleDisplay(View display, TextView textView) {
        display.setBackgroundColor(0);
        textView.setText("");
    }

    public void setActivePlayerBanner(View activePDisplay, View inactivePDisplay, TextView activePTextView, TextView inactivePTextView) {
        activePDisplay.setBackgroundColor(Color.WHITE);
        inactivePDisplay.setBackgroundColor(getResources().getColor(R.color.yellow));
        activePTextView.setTextColor(getResources().getColor(R.color.colorPrimary));
        activePTextView.setTypeface(null, Typeface.BOLD);
        inactivePTextView.setTextColor(Color.WHITE);
        inactivePTextView.setTypeface(null, Typeface.NORMAL);
    }

}
