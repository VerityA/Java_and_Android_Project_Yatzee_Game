package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import codeclan.com.yatzee.Players.Player;
import codeclan.com.yatzee.TheGame.Game;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 23/03/2018.
 */

public class GameTest {

    Game game;
    Player player1;
    Player player2;
    ArrayList<Integer> scores;


    @Before
    public void before() {
        game = new Game();
        player1 = game.getPlayer1();
        player2 = game.getPlayer2();
        scores = new ArrayList<>();
        scores.add(null);
        scores.add(null);
        scores.add(40);
    }

    @Test
    public void canGetActivePlayer() {
        assertEquals(player1, game.getActivePlayer());
        player1.changeActivePlayerStatus();
        player2.changeActivePlayerStatus();
        assertEquals(player2, game.getActivePlayer());
    }

    @Test
    public void canSetActivePlayersScoreAfterOneRoll() {
        game.setActivePlayerScore(scores);
        assertEquals(40, player1.getScore().intValue());
        assertEquals(0,player2.getScore().intValue());
        System.out.println(game.getPlayer1().getScore());
        System.out.println(game.getPlayer2().getScore());
        player1.changeActivePlayerStatus();
        player2.changeActivePlayerStatus();
        game.setActivePlayerScore(scores);
        assertEquals(40, player1.getScore().intValue());
        assertEquals(40, player2.getScore().intValue());
        System.out.println(game.getPlayer1().getScore());
        System.out.println(game.getPlayer2().getScore());
    }

    @Test
    public void canGetActivePlayersScore() {

    }

//    @Test
//    public void canSetActivePlayersScoreAfterTwoRolls() {
//        game.getRoll().firstFullRollOfDice();
//        System.out.println(game.getRoll().getDiceRollValues());
//        game.getRoll().reRollDice();
//        System.out.println(game.getRoll().getDiceRollValues());
//        game.setActivePlayerScore();
//        System.out.println(game.getPlayer1().getScore());
//        System.out.println(game.getPlayer2().getScore());
//    }
//
//    @Test
//    public void canSetActivePlayersScoreAfterTwoRollsPlayer2() {
//        game.getPlayer1().changeActivePlayerStatus();
//        game.getPlayer2().changeActivePlayerStatus();
//        game.getRoll().firstFullRollOfDice();
//        System.out.println(game.getRoll().getDiceRollValues());
//        game.getRoll().reRollDice();
//        System.out.println(game.getRoll().getDiceRollValues());
//        game.setActivePlayerScore();
//        System.out.println(game.getPlayer1().getScore());
//        System.out.println(game.getPlayer2().getScore());
//    }
}

