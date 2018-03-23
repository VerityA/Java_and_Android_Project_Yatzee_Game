package codeclan.com.yatzee;

/**
 * Created by user on 23/03/2018.
 */

public enum DiceType {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int value;

     DiceType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
