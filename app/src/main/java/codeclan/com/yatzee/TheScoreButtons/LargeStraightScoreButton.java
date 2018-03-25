package codeclan.com.yatzee.TheScoreButtons;

import codeclan.com.yatzee.TheRoll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class LargeStraightScoreButton extends ScoreButton {

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
