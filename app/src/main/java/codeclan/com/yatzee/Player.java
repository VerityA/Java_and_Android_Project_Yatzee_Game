package codeclan.com.yatzee;

/**
 * Created by user on 23/03/2018.
 */

public class Player {

    private int score;
    private boolean activePlayer;

    public Player(boolean activePlayer) {
        this.score = 0;
        this.activePlayer = activePlayer;
    }

    public int getScore() {
        return score;
    }

    public boolean isActivePlayer() {
        return activePlayer;
    }

    public void increasePlayerScore(int points) {
        this.score += points;
    }

    public void changeActivePlayerStatus() {
        if (this.isActivePlayer() == false) {
            this.activePlayer = true;
        }
        else {
            this.activePlayer = false;
        }
    }
}
