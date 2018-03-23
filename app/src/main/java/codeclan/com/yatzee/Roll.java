package codeclan.com.yatzee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 23/03/2018.
 */

public class Roll {

    private int rollCount;
    private ArrayList<Dice> dice;

    public Roll() {
        this.rollCount = 0;
        this.dice = new ArrayList<>();
    }

    public int getRollCount() {
        return rollCount;
    }

    public ArrayList<Dice> getDice() {
        return dice;
    }

    public void resetRollCount() {
        this.rollCount = 0;
    }

    public void increaseRollCount() {
        this.rollCount += 1;
    }

    public Dice getRandomDice() {
        Random random = new Random();
        int index = random.nextInt(DiceType.values().length);
        DiceType randomDiceType = DiceType.values()[index];
        Dice dice = new Dice(randomDiceType);
        return dice;
    }

    public void addDieToDice() {
        Dice die = this.getRandomDice();
        dice.add(die);
    }

    public ArrayList<Integer> getDiceRollValues() {
        ArrayList<Integer> arrayOfDiceValues = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayOfDiceValues.add(dice.get(i).getValueOfDice());
        }
        return arrayOfDiceValues;
    }

    public void clearDice() {
        this.resetRollCount();
        this.dice.clear();
    }

    public void firstFullRollOfDice() {
        this.increaseRollCount();
        for (int i = 0; i < 5; i++) {
            addDieToDice();
        }
    }


    public void reRollDice() {
        if (this.rollCount == 3) {
            return;
        }
        this.increaseRollCount();
        for (int i = 0; i < 5; i++) {
            if (dice.get(i).isHeld() == false) {
                dice.set(i, getRandomDice());
            }
        }
    }


}
