package codeclan.com.yatzee.TheScoreButtons;

import codeclan.com.yatzee.TheRoll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class ChanceScoreButton extends ScoreButtons {

    private Integer scoreValue;

    public ChanceScoreButton(Strategy strategyType) {
        super(strategyType);
        this.scoreValue = 0;
    }

    @Override
    public int calculateScore(Roll roll) {
        return roll.sumOfAllDiceValues();
    }
}