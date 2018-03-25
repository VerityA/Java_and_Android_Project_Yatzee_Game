package codeclan.com.yatzee.ScoreButtons;

import codeclan.com.yatzee.Roll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class ChanceScoreButton extends ScoreButtons {

    private int scoreValue;

    public ChanceScoreButton(Strategy strategyType) {
        super(strategyType);
        this.scoreValue = 0;
    }

    @Override
    public int calculateScore(Roll roll) {
        return roll.sumOfAllDiceValues();
    }
}
