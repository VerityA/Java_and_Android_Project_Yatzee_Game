package codeclan.com.yatzee.Game;

import codeclan.com.yatzee.Player.Player;
import codeclan.com.yatzee.Roll.Roll;

/**
 * Created by user on 23/03/2018.
 */

public class Game {

    private Player player1;
    private Player player2;
    private Roll roll;

    public Game() {
        this.player1 = new Player(true);
        this.player2 =  new Player(false);
        this.roll = new Roll();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getActivePlayer() {
        if (player1.isActivePlayer() == true) {
            return player1;
        }
        else  {
            return player2;
        }
    }

    public Roll getRoll() {
        return roll;
    }

    public void setActivePlayerScore() {
        int totalScore = 0;
        for (int value : roll.getDiceRollValues()) {
            totalScore += value;
        }
        if (player1.isActivePlayer() == true) {
            player1.increasePlayerScore(totalScore);
        }
        else {
            player2.increasePlayerScore(totalScore);
        }
    }
}
