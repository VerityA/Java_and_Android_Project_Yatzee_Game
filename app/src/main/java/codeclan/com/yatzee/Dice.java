package codeclan.com.yatzee;

/**
 * Created by user on 23/03/2018.
 */

public class Dice {

    private DiceType diceType;
    private Boolean isHeld;

    public Dice(DiceType diceType) {
        this.diceType = diceType;
        this.isHeld = false;
    }

    public DiceType getDiceType() {
        return diceType;
    }

    public Boolean isHeld() {
        return isHeld;
    }

    public int getValueOfDice() {
        return this.diceType.getValue();
    }

    public void changeHeldStatus() {
        if (this.isHeld == false) {
            this.isHeld = true;
        }
        else {
            this.isHeld = false;
        }
    }
}
