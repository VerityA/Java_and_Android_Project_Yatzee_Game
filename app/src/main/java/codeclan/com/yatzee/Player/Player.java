package codeclan.com.yatzee.Player;

/**
 * Created by user on 23/03/2018.
 */

public class Player {

    private Integer score;
    private Boolean activePlayer;
    private int turnsTaken;

    public Player(Boolean activePlayer) {
        this.score = 0;
        this.activePlayer = activePlayer;
        this.turnsTaken = 0;
    }

    public Integer getTurnsTaken() {
        return turnsTaken;
    }

    public Integer getScore() {
        return score;
    }

    public Boolean isActivePlayer() {
        return activePlayer;
    }

    public void increasePlayerScore(int points) {
        this.score += points;
    }

    public void increaseTurnsTaken() {
        this.turnsTaken += 1;
    }

    public void changeActivePlayerStatus() {
        if (this.isActivePlayer() == false) {
            this.activePlayer = true;
        }
        else {
            this.activePlayer = false;
        }
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTurnsTaken(int turnsTaken) {
        this.turnsTaken = turnsTaken;
    }
}
