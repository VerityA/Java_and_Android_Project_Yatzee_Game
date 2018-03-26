package codeclan.com.yatzee.TheScoreButtons;

import java.util.ArrayList;

/**
 * Created by user on 26/03/2018.
 */

public class AllScoreButtons {

    private ArrayList<ScoreButton> scoreButtons;

    public AllScoreButtons() {
        scoreButtons = new ArrayList<>();

        scoreButtons.add(new LowerScoreButton(Strategy.ONES));
        scoreButtons.add(new LowerScoreButton(Strategy.TWOS));
        scoreButtons.add(new LowerScoreButton(Strategy.THREES));
        scoreButtons.add(new LowerScoreButton(Strategy.FOURS));
        scoreButtons.add(new LowerScoreButton(Strategy.FIVES));
        scoreButtons.add(new LowerScoreButton(Strategy.SIXES));

        scoreButtons.add(new OfAKindScoreButton(Strategy.THREEOFAKIND));
        scoreButtons.add(new OfAKindScoreButton(Strategy.FOUROFAKIND));

        scoreButtons.add(new FullHouseScoreButton(Strategy.FULLHOUSE));

        scoreButtons.add(new SmallStraightScoreButton(Strategy.SMALLSTRAIGHT));
        scoreButtons.add(new LargeStraightScoreButton(Strategy.LARGESTRAIGHT));

        scoreButtons.add(new OfAKindScoreButton(Strategy.YATZEE));

        scoreButtons.add(new ChanceScoreButton(Strategy.CHANCE));
    }

    public ArrayList<ScoreButton> getScoreButtons() {
        return scoreButtons;
    }
}
