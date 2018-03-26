package codeclan.com.yatzee.TheScoreButtons;

import codeclan.com.yatzee.TheRoll.Roll;

/**
 * Created by user on 25/03/2018.
 */

public class FullHouseScoreButton extends ScoreButton {

    private int p1ScoreValue;
    private int p2ScoreValue;

    public FullHouseScoreButton(Strategy strategyType) {
        super(strategyType);
        this.p1ScoreValue = 0;
        this.p2ScoreValue = 0;
    }

    @Override
    public Integer calculateScore(Roll roll) {
        if (roll.doesContainMultipleOfAnyDieValue(3)) {
            if (roll.doesContainMultipleOfAnyDieValue(2)) {
                return 25;
            }
        }
        return 0;
    }
}
