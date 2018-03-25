package codeclan.com.yatzee.TheScoreButtons;

/**
 * Created by user on 25/03/2018.
 */

public enum Strategy {
    ONES(1, "ones", "dice_one_icon"),
    TWOS(2, "twos", "dice_two_icon"),
    THREES(3, "threes", "dice_three_icon"),
    FOURS(4, "fours", "dice_four_icon"),
    FIVES(5, "fives", "dice_five_icon"),
    SIXES(6, "sixes", "dice_six_icon"),
    THREEOFAKIND(3, "threeofakind", "three_of_a_kind"),
    FOUROFAKIND(4, "fourofakind", "four_of_a_kind"),
    FULLHOUSE(0, "fullhouse", "full_house"),
    SMALLSTRAIGHT(0, "smallstraight", "small_straight"),
    LARGESTRAIGHT(0, "largestraight", "large_straight"),
    YATZEE(5, "yatzee", "yatzee"),
    CHANCE(0, "chance", "chance");

    private int value;
    private String name;
    private String image;

    Strategy(int value, String name, String image) {
        this.value = value;
        this.name = name;
        this.image = image;
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
}
