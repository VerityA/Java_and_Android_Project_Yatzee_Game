package codeclan.com.yatzee.Dice;

/**
 * Created by user on 23/03/2018.
 */

public enum DiceType {
    ONE(1, "dice_one"),
    TWO(2, "dice_two"),
    THREE(3, "dice_three"),
    FOUR(4, "dice_four"),
    FIVE(5, "dice_five"),
    SIX(6, "dice_six");

    private int value;
    private String image;

     DiceType(int value, String image){
        this.value = value;
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public String getImage() {
         return image;
    }
}
