package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

import codeclan.com.yatzee.Dice.Dice;
import codeclan.com.yatzee.Roll.Roll;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 23/03/2018.
 */

public class RollTest {

    Roll roll;

    @Before
    public void before() {
        roll = new Roll();
    }

    @Test
    public void canIncreaseRollCount() {
        assertEquals(0, roll.getRollCount());
        roll.increaseRollCount();
        assertEquals(1, roll.getRollCount());
    }

    @Test
    public void canGetRandomDice() {
        Dice randomDice = roll.getRandomDice();
        System.out.println(randomDice.getValueOfDice());
    }

    @Test
    public void canAddDieToDice() {
        roll.addDieToDice();
        assertEquals(1, roll.getDice().size());
    }

    @Test
    public void canClearDice() {
        roll.addDieToDice();
        roll.addDieToDice();
        roll.clearDice();
        assertEquals(0, roll.getDice().size());
    }

    @Test
    public void canSetRollDiceToZero() {
        roll.increaseRollCount();
        roll.resetRollCount();
        assertEquals(0, roll.getRollCount());
    }

    @Test
    public void canDoFirstFullRollOfDice() {
        roll.firstFullRollOfDice();
        assertEquals(5,roll.getDice().size());
        assertEquals(1, roll.getRollCount());
    }

    @Test
    public void canGetArrayOfRollDiceValues() {
        roll.firstFullRollOfDice();
        assertEquals(5, roll.getDiceRollValues().size());
    }

    @Test
    public void canSeeIfDiceRollContainsAValue() {
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        System.out.println(roll.doesDiceContainDieValue(1));
        System.out.println(roll.doesDiceContainDieValue(2));
        System.out.println(roll.doesDiceContainDieValue(3));
        System.out.println(roll.doesDiceContainDieValue(4));
        System.out.println(roll.doesDiceContainDieValue(5));
        System.out.println(roll.doesDiceContainDieValue(6));
    }

    @Test
    public void canCalculateOccurrencesOfDieValue() {
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        System.out.println(roll.frequencyOfDieValue(1));
        System.out.println(roll.frequencyOfDieValue(2));
        System.out.println(roll.frequencyOfDieValue(3));
        System.out.println(roll.frequencyOfDieValue(4));
        System.out.println(roll.frequencyOfDieValue(5));
        System.out.println(roll.frequencyOfDieValue(6));

    }

    @Test
    public void canSeeIfManyOfAKindPresent() {
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        System.out.println(roll.doesContainMultipleOfAnyDieValue(3));
    }

    @Test
    public void canReRollDiceNoDiceHeld() {
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        roll.reRollDice();
        System.out.println(roll.getDiceRollValues());
    }

    @Test
    public void cannotReRollDiceWhenAllDiceHeld() {
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        for (int i=0; i < 5; i++) {
            roll.getDice().get(i).changeHeldStatus();
        }
        roll.reRollDice();
        System.out.println(roll.getDiceRollValues());
    }

    @Test
    public void cannotReRollDiceAfterThreeRolls() {
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        roll.reRollDice();
        System.out.println(roll.getDiceRollValues());
        roll.reRollDice();
        System.out.println(roll.getDiceRollValues());
        roll.reRollDice();
        System.out.println(roll.getDiceRollValues());
    }

}
