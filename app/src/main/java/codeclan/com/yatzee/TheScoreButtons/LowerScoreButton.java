package codeclan.com.yatzee.TheScoreButtons;

import codeclan.com.yatzee.TheRoll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class LowerScoreButton extends ScoreButton {

    private int scoreValue;

    public LowerScoreButton(Strategy strategyType) {
        super(strategyType);
        this.scoreValue = 0;
    }

    @Override
    public int calculateScore(Roll roll) {
        int strategyValue = getStrategyType().getValue();
        return roll.frequencyOfDieValue(strategyValue) * strategyValue;
    }


}
