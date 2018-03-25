package codeclan.com.yatzee.ScoreButtons;

/**
 * Created by user on 25/03/2018.
 */

public enum Strategy {
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    THREEOFAKIND(3),
    FOUROFAKIND(4),
    FULLHOUSE(0),
    SMALLSTRAIGHT(0),
    LARGESTRAIGHT(0),
    YATZEE(5),
    CHANCE(0);

    private int value;

    Strategy(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
