package codeclan.com.yatzee.TheGame;

import java.util.ArrayList;

import codeclan.com.yatzee.Players.Player;
import codeclan.com.yatzee.R;
import codeclan.com.yatzee.TheRoll.Roll;
import codeclan.com.yatzee.TheScoreButtons.AllScoreButtons;
import codeclan.com.yatzee.TheScoreButtons.ScoreButton;
import codeclan.com.yatzee.TheScoreButtons.Strategy;

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
    private ScoreButton scoreButton;


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

    public Integer getPlayerStrategyValue(Player player, ScoreButton scoreButton){
        if (player == this.player1) {
            return scoreButton.getP1ScoreValue();
        }
        return scoreButton.getP2ScoreValue();
    }

    public void setPlayerStrategyValue(Player player, ScoreButton scoreButton, Integer scoreValue) {
        if (player == this.player1) {
            scoreButton.setP1ScoreValue(scoreValue);
        }
        else {
            scoreButton.setP2ScoreValue(scoreValue);
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

//    public Integer getAPlayerStrategyValueForButton(ScoreButton scoreButton) {
//        if (player1.isActivePlayer()) {
//            return scoreButton.getP1ScoreValue();
//        }
//
//        return scoreButton.getP2ScoreValue();
//    }
//
//    public void setAPlayerStrategyValueForButton(ScoreButton scoreButton, Integer strategyValue) {
//        if (player1.isActivePlayer()) {
//            scoreButton.setP1ScoreValue(strategyValue);
//        }
//        else {
//            scoreButton.setP2ScoreValue(strategyValue);
//        }
//    }

    public Integer getScoreOfButtonForPlayer(ScoreButton scoreButton, Player player) {
        if (player == player1) {
            return scoreButton.getP1ScoreValue();
        }
        return scoreButton.getP2ScoreValue();
    }

    public void setScoreOfButtonForPlayer(ScoreButton scoreButton, Player player, Integer score) {
        if (player == player1) {
            scoreButton.setP1ScoreValue(score);
        }
        else {
            scoreButton.setP2ScoreValue(score);
        }
    }

    public Boolean hasGameFinished() {
        if (player1.getTurnsTaken() == 13 && player2.getTurnsTaken() == 13) {
            return true;
        }
        return false;
    }

    public String getWinningMessage() {
        if (player1.getScore() == player2.getScore()) {
            return "draw";
        }
        else if(player1.getScore() > player2.getScore()) {
           return "player1_win";
        }
        else {
            return "player2_win";
        }
    }

    public void changeTurns() {
        player1.changeActivePlayerStatus();
        player2.changeActivePlayerStatus();
    }

//    public
}


