package codeclan.com.yatzee.TheScoreButtons;

/**
 * Created by user on 25/03/2018.
 */

public enum Strategy {
    ONES(1, "ones", "dice_one_icon", "pale_green"),
    TWOS(2, "twos", "dice_two_icon", "pale_green"),
    THREES(3, "threes", "dice_three_icon", "pale_green"),
    FOURS(4, "fours", "dice_four_icon", "pale_green"),
    FIVES(5, "fives", "dice_five_icon", "pale_green"),
    SIXES(6, "sixes", "dice_six_icon", "pale_green"),
    THREEOFAKIND(3, "threeofakind", "three_of_a_kind", "darker_green"),
    FOUROFAKIND(4, "fourofakind", "four_of_a_kind", "darker_green"),
    FULLHOUSE(0, "fullhouse", "full_house", "darker_green"),
    SMALLSTRAIGHT(0, "smallstraight", "small_straight", "darker_green"),
    LARGESTRAIGHT(0, "largestraight", "large_straight", "darker_green"),
    YATZEE(5, "yatzee", "yatzee", "darker_green"),
    CHANCE(0, "chance", "chance", "darker_green");

    private int value;
    private String name;
    private String image;
    private String colour;

    Strategy(int value, String name, String image, String colour) {
        this.value = value;
        this.name = name;
        this.image = image;
        this.colour = colour;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getColour() {
        return colour;
    }
}
