package codeclan.com.yatzee.ScoreButtons;

import codeclan.com.yatzee.Roll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class LargeStraightScoreButton extends ScoreButtons {

    private int scoreValue;

    public LargeStraightScoreButton(Strategy strategyType) {
        super(strategyType);
        this.scoreValue = 0;
    }

    @Override
    public int calculateScore(Roll roll) {
        if (roll.doesContainAFullStraight()) {
            return 40;
        }
        return 0;
    }
}
