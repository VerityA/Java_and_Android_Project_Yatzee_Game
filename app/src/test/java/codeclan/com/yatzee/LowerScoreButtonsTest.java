package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

import codeclan.com.yatzee.Roll.Roll;
import codeclan.com.yatzee.ScoreButtons.ScoreButtons;
import codeclan.com.yatzee.ScoreButtons.Strategy;

/**
 * Created by user on 25/03/2018.
 */

public class LowerScoreButtonsTest {

    ScoreButtons.LowerScoreButton lowerScoreButton;
    Roll roll;

    @Before
    public void before() {
        lowerScoreButton = new ScoreButtons.LowerScoreButton(Strategy.FIVES);
    }

    @Test
    public void canCalculateScoreForFives() {
        roll = new Roll();
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        System.out.println(lowerScoreButton.calculateScore(roll));
    }
}
