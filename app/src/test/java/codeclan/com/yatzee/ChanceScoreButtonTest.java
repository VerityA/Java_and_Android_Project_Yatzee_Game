package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

import codeclan.com.yatzee.TheRoll.Roll;
import codeclan.com.yatzee.TheScoreButtons.ChanceScoreButton;
import codeclan.com.yatzee.TheScoreButtons.Strategy;

/**
 * Created by user on 25/03/2018.
 */

public class ChanceScoreButtonTest {

    ChanceScoreButton chanceScoreButton;
    Roll roll;

    @Before
    public void before() {
        chanceScoreButton = new ChanceScoreButton(Strategy.CHANCE);
    }

    @Test
    public void canCalculateScoreForThreeOfAKind() {
        roll = new Roll();
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        System.out.println(chanceScoreButton.calculateScore(roll));
    }
}
