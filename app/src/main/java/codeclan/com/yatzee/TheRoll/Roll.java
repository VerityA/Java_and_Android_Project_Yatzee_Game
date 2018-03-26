package codeclan.com.yatzee.TheRoll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import codeclan.com.yatzee.Dices.Dice;
import codeclan.com.yatzee.Dices.DiceType;

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

        if(dice.size() == 0) {
            return arrayOfDiceValues;
        }

        for (int i = 0; i < 5; i++) {
            arrayOfDiceValues.add(dice.get(i).getValueOfDice());
        }
        return arrayOfDiceValues;
    }

    public int sumOfAllDiceValues() {
        int totalScore = 0;
        for (int value : this.getDiceRollValues()) {
            totalScore += value;
        }
        return totalScore;
    }

    public boolean doesDiceContainDieValue(int value) {
        ArrayList<Integer> diceValues = this.getDiceRollValues();
        if (diceValues.contains(value)) {
            return true;
        }
            return false;
    }

    public int frequencyOfDieValue(int value) {
        ArrayList<Integer> diceValues = this.getDiceRollValues();
        int frequency = Collections.frequency(diceValues, value);
        return frequency;
    }

    public boolean doesContainMultipleOfAnyDieValue(int multiple) {
        ArrayList<Integer> frequenciesArray = new ArrayList<>();
            for (int i = 1; i <7; i++) {
                int frequency = 0;
                frequency += frequencyOfDieValue(i);
                frequenciesArray.add(frequency);
            }

            int meetsMultiple = 0;
            for (int i = 0; i < 6; i++) {
                if (frequenciesArray.get(i) >= multiple) {
                    meetsMultiple +=1;
                }
            }
            if (meetsMultiple > 0) {
                return true;
            }
            return false;
    }

    public boolean doesContainAFullStraight() {
        ArrayList<Integer> fullStraight1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> fullStraight2 = new ArrayList<>(Arrays.asList(2,3,4,5,6));

        int fstotal1 = 0;
        int fstotal2 = 0;

        for (int i = 0; i < 5; i++) {
            if (this.getDiceRollValues().contains(fullStraight1.get(i))) {
                fstotal1 += 1;
            }
            if (this.getDiceRollValues().contains(fullStraight2.get(i))) {
                fstotal2 += 1;
            }
        }

        if (fstotal1 == 5 || fstotal2 == 5) {
            return true;
        }
            return false;
    }

    public boolean doesContainASmallStraight() {
        ArrayList<Integer> smallStraight1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> smallStraight2 = new ArrayList<>(Arrays.asList(2,3,4,5));
        ArrayList<Integer> smallStraight3 = new ArrayList<>(Arrays.asList(3,4,5,6));

        int sstotal1 = 0;
        int sstotal2 = 0;
        int sstotal3 = 0;

        for (int i = 0; i < 5; i++) {
            if (this.getDiceRollValues().contains(smallStraight1.get(i))) {
                sstotal1 += 1;
            }
            if (this.getDiceRollValues().contains(smallStraight2.get(i))) {
                sstotal2 += 1;
            }
            if (this.getDiceRollValues().contains(smallStraight3.get(i))) {
                sstotal3 += 1;
            }
        }

        if (sstotal1 == 4 || sstotal2 == 4 || sstotal3 == 4) {
            return true;
        }
        return false;
    }


    public void clearDice() {
        this.resetRollCount();
        this.dice.clear();
    }

    public ArrayList<Dice> firstFullRollOfDice() {
        this.increaseRollCount();
        for (int i = 0; i < 5; i++) {
            addDieToDice();
        }
        return dice;
    }


    public ArrayList<Dice> reRollDice() {
        if (this.rollCount == 3) {
            return dice;
        }
        this.increaseRollCount();
        for (int i = 0; i < 5; i++) {
            if (dice.get(i).isHeld() == false) {
                dice.set(i, getRandomDice());
            }
        }
        return dice;
    }


}
