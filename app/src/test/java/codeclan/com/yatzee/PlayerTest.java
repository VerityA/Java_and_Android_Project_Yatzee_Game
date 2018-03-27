package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import codeclan.com.yatzee.Players.Player;
import codeclan.com.yatzee.TheRoll.Roll;
import codeclan.com.yatzee.TheScoreButtons.ChanceScoreButton;
import codeclan.com.yatzee.TheScoreButtons.Strategy;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 23/03/2018.
 */

public class PlayerTest {

    Player player;
    Roll roll;

    @Before
    public void before() {
        player = new Player(true);
        roll = new Roll();
    }

    @Test
    public void canIncreasePlayerScore() {
        assertEquals(0, player.getScore().intValue());
        player.increasePlayerScore(25);
        assertEquals(25, player.getScore().intValue());
    }


    @Test
    public void canChangeActivePlayerStatus() {
        assertEquals(true, player.isActivePlayer());
        player.changeActivePlayerStatus();
        assertEquals(false, player.isActivePlayer());
    }

    @Test
    public void canIncreasePlayerTurns() {
        player.increaseTurnsTaken();
        assertEquals(1,player.getTurnsTaken().intValue());
    }

    @Test
    public void canInitializeScoreMap() {
        player.initializeScoreMap();
        HashMap<Strategy, Integer> strategyMap = player.getScoreMap();
        System.out.println(strategyMap.toString());
    }

    @Test
    public void canSetScoreMapValue() {
        roll.firstFullRollOfDice();
        System.out.println(roll.getDiceRollValues());
        ChanceScoreButton chanceScoreButton = new ChanceScoreButton(Strategy.CHANCE);
        player.initializeScoreMap();
        HashMap<Strategy, Integer> strategyMap = player.getScoreMap();
        System.out.println(strategyMap);
        assertEquals(null, strategyMap.get(chanceScoreButton.getStrategyType()));
        player.setScoreMapValue(chanceScoreButton.getStrategyType(), chanceScoreButton.calculateScore(roll));
        assertEquals(chanceScoreButton.calculateScore(roll).intValue(),strategyMap.get(chanceScoreButton.getStrategyType()).intValue());
        System.out.println(strategyMap);
    }


}
