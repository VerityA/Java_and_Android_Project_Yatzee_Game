package codeclan.com.yatzee.TheGame;

import java.util.ArrayList;

import codeclan.com.yatzee.Players.Player;
import codeclan.com.yatzee.TheRoll.Roll;
import codeclan.com.yatzee.TheScoreButtons.AllScoreButtons;
import codeclan.com.yatzee.TheScoreButtons.ScoreButton;

/**
 * Created by user on 23/03/2018.
 */

public class Game {

    private Player player1;
    private Player player2;
    private Player activePlayer;
    private Roll roll;
    private AllScoreButtons allScoreButtons;
    private ArrayList<ScoreButton> scoreButtons;


    public Game() {
        this.player1 = new Player(true);
        this.player2 =  new Player(false);
        this.activePlayer = this.getActivePlayer();
        this.roll = new Roll();
        allScoreButtons = new AllScoreButtons();
        scoreButtons = allScoreButtons.getScoreButtons();
    }

    public AllScoreButtons getAllScoreButtons() {
        return allScoreButtons;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getActivePlayer() {
        if (player1.isActivePlayer()) {
            return player1;
        }
        else  {
            return player2;
        }
    }

    public Roll getRoll() {
        return roll;
    }

    public void setActivePlayerScorex() {
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

    public ArrayList<Integer> getActivePlayerScores() {
        if (!player1.isActivePlayer()) {
            return allScoreButtons.getP2Scores();
        }
        return allScoreButtons.getP1Scores();
    }

    public void setActivePlayerScore(ArrayList<Integer> scoreValues) {

        int totalScore = 0;
        if (player1.isActivePlayer()) {
            for (Integer score : scoreValues) {
                if (score != null) {
                    totalScore += score;
                }
            }
            player1.setTotalScore(totalScore);
        }

            else {
            for (Integer score : scoreValues) {
                if (score != null) {
                    totalScore += score;
                }
            }
            player2.setTotalScore(totalScore);
         }
    }
}


