package codeclan.com.yatzee.TheScoreButtons;

import codeclan.com.yatzee.TheRoll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class LargeStraightScoreButton extends ScoreButton {

    private int p1ScoreValue;
    private int p2ScoreValue;

    public LargeStraightScoreButton(Strategy strategyType) {
        super(strategyType);
        this.p1ScoreValue = 0;
        this.p2ScoreValue = 0;
    }

    @Override
    public Integer calculateScore(Roll roll) {
        if (roll.doesContainAFullStraight()) {
            return 40;
        }
        return 0;
    }
}
