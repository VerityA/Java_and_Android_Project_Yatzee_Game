package codeclan.com.yatzee.TheScoreButtons;

import java.net.Inet4Address;
import java.util.ArrayList;

import codeclan.com.yatzee.Players.Player;
import codeclan.com.yatzee.TheGame.Game;

/**
 * Created by user on 26/03/2018.
 */

public class AllScoreButtons {

    private ArrayList<ScoreButton> scoreButtons;
    private Player player1;
    private Player player2;

    public AllScoreButtons() {
        player1 = new Player(true);
        player2 = new Player(false);
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


    public ArrayList<Integer> getP1Scores() {
        ArrayList<Integer> p1Scores = new ArrayList<>();

        for (ScoreButton scoreButton : scoreButtons) {
            Integer p1Score = scoreButton.getP1ScoreValue();
            p1Scores.add(p1Score);
        }
        return p1Scores;
    }

    public ArrayList<Integer> getP2Scores() {
        ArrayList<Integer> p2Scores = new ArrayList<>();

        for (ScoreButton scoreButton : scoreButtons) {
            Integer p2Score = scoreButton.getP2ScoreValue();
            p2Scores.add(p2Score);
        }
        return p2Scores;
    }

//    public ArrayList<Integer> getPlayerScores(Player player) {
//        ArrayList<Integer> scores = new ArrayList<>();
//
//        for (ScoreButton scoreButton: scoreButtons) {
//            Integer score = scoreButton.getActivePlayerStrategyValue();
//            scores.add(score);
//        }
//        return scores;
//    }
}
