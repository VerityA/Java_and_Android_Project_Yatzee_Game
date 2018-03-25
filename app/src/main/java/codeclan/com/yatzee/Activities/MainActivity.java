package codeclan.com.yatzee.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import codeclan.com.yatzee.Dices.Dice;
import codeclan.com.yatzee.TheGame.Game;
import codeclan.com.yatzee.Players.Player;
import codeclan.com.yatzee.R;
import codeclan.com.yatzee.TheRoll.Roll;

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

    private TextView playerOneText;
    private TextView playerTwoText;
    private TextView playerOneScore;
    private TextView playerTwoScore;

    private TextView winningMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();
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

        playerOneScore = findViewById(R.id.player2_score);
        playerOneScore.setText(game.getPlayer1().getScore().toString());

        playerTwoScore = findViewById(R.id.player2_score);
        playerTwoScore.setText(game.getPlayer2().getScore().toString());

        playerOneText = findViewById(R.id.player1_text);
        playerTwoText = findViewById(R.id.player2_text);
        playerOneText.setBackgroundColor(Color.GRAY);

        player1 = game.getPlayer1();
        player2 = game.getPlayer2();

    }


    public void onDiceButtonClick(View diceClickView) {
        ImageButton diceButton = findViewById(diceClickView.getId());
        diceButton.clearColorFilter();

        Dice die = (Dice) diceClickView.getTag();
        die.changeHeldStatus();

        ImageButton clickedDiceButton = findViewById(diceClickView.getId());

        if( die.isHeld() == true) {
            clickedDiceButton.setColorFilter(R.color.grey_out);
        }
    }




    public void onRollButtonClick(View rollClickView) {
        if (game.getActivePlayer().getTurnsTaken() == 1) {
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

        rollButton = findViewById(R.id.roll_button);
        rollButton.setText(R.string.other_roll);

    }


    public void onPlayButtonClick(View playClickLView) {

        Button playButton = findViewById(R.id.play_button);
        if (playButton.getText() == getString(R.string.play_again)) {
            player1.setScore(0);
            player2.setScore(0);
            playerOneScore.setText(player1.getScore().toString());
            playerTwoScore.setText(player2.getScore().toString());
            player1.setTurnsTaken(0);
            player2.setTurnsTaken(0);
            roll.resetRollCount();
            rollButton.setText(R.string.first_roll);
            playButton.setText(R.string.play);
            playerOneText.setBackgroundColor(Color.GRAY);
            playerTwoText.setBackgroundColor(0);
            winningMessage.setText(null);
            return;
        }

       game.getActivePlayer().increaseTurnsTaken();

        if (roll.getRollCount() == 0) {
            return;
        }

        game.setActivePlayerScore();

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

        if (player1.getTurnsTaken() + player2.getTurnsTaken() == 2) {

                playButton.setText(R.string.play_again);
                playerOneText.setBackgroundColor(0);
                playerTwoText.setBackgroundColor(0);
                winningMessage = findViewById(R.id.winner_msg);
                if (player1.getScore() == player2.getScore()) {
                    winningMessage.setText(R.string.draw);
                }
                else if(player1.getScore() > player2.getScore()) {
                    winningMessage.setText(R.string.player1_win);
                }
                else {
                    winningMessage.setText(R.string.player2_win);
                }


            }



        }

}
