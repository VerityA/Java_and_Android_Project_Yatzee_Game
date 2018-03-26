package codeclan.com.yatzee.TheScoreButtons;

import codeclan.com.yatzee.TheRoll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class OfAKindScoreButton extends ScoreButton {

    private int p1ScoreValue;
    private int p2ScoreValue;

    public OfAKindScoreButton(Strategy strategyType) {
        super(strategyType);
        this.p1ScoreValue = 0;
        this.p2ScoreValue = 0;
    }

    @Override
    public Integer calculateScore(Roll roll) {
        if (roll.doesContainMultipleOfAnyDieValue(getStrategyType().getValue())) {
            if (getStrategyType().getValue() == 5) {
                return 50;
            }
            return roll.sumOfAllDiceValues();
        }
        return 0;
    }
}
