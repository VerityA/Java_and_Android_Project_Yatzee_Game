package codeclan.com.yatzee.TheScoreButtons;

import codeclan.com.yatzee.TheRoll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class SmallStraightScoreButton extends ScoreButton {

    private int scoreValue;

    public SmallStraightScoreButton(Strategy strategyType) {
        super(strategyType);
        this.scoreValue = 0;
    }

    @Override
    public int calculateScore(Roll roll) {
        if (roll.doesContainASmallStraight()) {
            return 30;
        }
        return 0;
    }
}
