package codeclan.com.yatzee.Players;

import java.util.ArrayList;
import java.util.HashMap;

import codeclan.com.yatzee.TheScoreButtons.AllScoreButtons;
import codeclan.com.yatzee.TheScoreButtons.ScoreButton;
import codeclan.com.yatzee.TheScoreButtons.Strategy;

/**
 * Created by user on 23/03/2018.
 */

public class Player {

    private Integer totalScore;
    private Boolean activePlayer;
    private int turnsTaken;
    private HashMap<Strategy, Integer> scoreMap;


    public Player(Boolean activePlayer) {
        this.totalScore = 0;
        this.activePlayer = activePlayer;
        this.turnsTaken = 0;
        this.scoreMap = new HashMap<>();
    }

    public Integer getTurnsTaken() {
        return turnsTaken;
    }

    public Integer getScore() {
        return totalScore;
    }

    public Boolean isActivePlayer() {
        return activePlayer;
    }

    public void increasePlayerScore(int points) {
        this.totalScore += points;
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

    public void resetScore() {
        this.totalScore = 0;
    }

    public void setTotalScore(int score) {
        this.totalScore = score;
    }



    public void setTurnsTaken(int turnsTaken) {
        this.turnsTaken = turnsTaken;
    }

    public void initializeScoreMap() {
        Strategy[] strategies = Strategy.values();
        for (Strategy strategy : strategies) {
            this.scoreMap.put(strategy, null);
        }
    }

    public Boolean getActivePlayer() {
        return activePlayer;
    }

    public HashMap<Strategy, Integer> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMapValue(Strategy strategy, int scoreValue) {
        for (HashMap.Entry<Strategy, Integer> entry : this.getScoreMap().entrySet() ) {
            if ( entry.getKey() == strategy) {
                this.getScoreMap().put(strategy, scoreValue);
            }
        }

    }
}
