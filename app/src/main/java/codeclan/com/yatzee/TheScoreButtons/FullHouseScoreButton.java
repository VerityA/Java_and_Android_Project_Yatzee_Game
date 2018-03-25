package codeclan.com.yatzee.TheScoreButtons;

import codeclan.com.yatzee.TheRoll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class FullHouseScoreButton extends ScoreButtons {

    private int scoreValue;

    public FullHouseScoreButton(Strategy strategyType) {
        super(strategyType);
        this.scoreValue = 0;
    }

    @Override
    public int calculateScore(Roll roll) {
        if (roll.doesContainMultipleOfAnyDieValue(3)) {
            if (roll.doesContainMultipleOfAnyDieValue(2)) {
                return 25;
            }
        }
        return 0;
    }
}
