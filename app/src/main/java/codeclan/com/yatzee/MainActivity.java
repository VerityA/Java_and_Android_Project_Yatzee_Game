package codeclan.com.yatzee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton diceOne;
    private ImageButton diceTwo;
    private ImageButton diceThree;
    private ImageButton diceFour;
    private ImageButton diceFive;
    private ArrayList<ImageButton> diceButtons;

    private Game game;
    private ArrayList<Dice> dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();
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


    }


    public void onDiceButtonClick(View diceClickView) {


    }

    public void onRollButtonClick(View rollClickView) {
        Button button = findViewById(R.id.roll_button);
        button.setText(R.string.other_roll);

        if (game.getRoll().getRollCount() == 0) {
            dice = game.getRoll().firstFullRollOfDice();
        }
        else {
            dice = game.getRoll().reRollDice();
        }

        for (int i=0; i < 5; i++) {
            String imageName = dice.get(i).getDiceType().getImage();
            Integer resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            diceButtons.get(i).setImageResource(resID);
        }
    }
}
