package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 23/03/2018.
 */

public class DiceTest {

    Dice dice;

    @Before
    public void before() {
        dice = new Dice(DiceType.FIVE);
    }

    @Test
    public void canGetValueOfDice() {
        assertEquals(5, dice.getValueOfDice());
    }

    @Test
    public void canChangeHeldStatusFromFalseToTrue() {
        dice.changeHeldStatus();
        assertEquals(true, dice.isHeld());
        dice.changeHeldStatus();
        assertEquals(false, dice.isHeld());
    }
}
