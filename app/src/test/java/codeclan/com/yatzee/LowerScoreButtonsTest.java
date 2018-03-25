package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

import codeclan.com.yatzee.TheRoll.Roll;
import codeclan.com.yatzee.TheScoreButtons.LowerScoreButton;
import codeclan.com.yatzee.TheScoreButtons.Strategy;

/**
 * Created by user on 25/03/2018.
 */

public class LowerScoreButtonsTest {

    LowerScoreButton lowerScoreButton;
    Roll roll;

    @Before
    public void before() {
        lowerScoreButton = new LowerScoreButton(Strategy.FIVES);
    }

    @Test
    public void canCalculateScoreForFives() {
        roll = new Roll();
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        System.out.println(lowerScoreButton.calculateScore(roll));
    }
}
