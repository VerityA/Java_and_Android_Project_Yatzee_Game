package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 23/03/2018.
 */

public class GameTest {

    Game game;


    @Before
    public void before() {
        game = new Game();
    }

    @Test
    public void canSetActivePlayersScoreAfterOneRoll() {
        game.getRoll().firstFullRollOfDice();
        System.out.println(game.getRoll().getDiceRollValues());
        game.setActivePlayerScore();
        System.out.println(game.getPlayer1().getScore());
        System.out.println(game.getPlayer2().getScore());
    }

    @Test
    public void canSetActivePlayersScoreAfterTwoRolls() {
        game.getRoll().firstFullRollOfDice();
        System.out.println(game.getRoll().getDiceRollValues());
        game.getRoll().reRollDice();
        System.out.println(game.getRoll().getDiceRollValues());
        game.setActivePlayerScore();
        System.out.println(game.getPlayer1().getScore());
        System.out.println(game.getPlayer2().getScore());
    }

    @Test
    public void canSetActivePlayersScoreAfterTwoRollsPlayer2() {
        game.getPlayer1().changeActivePlayerStatus();
        game.getPlayer2().changeActivePlayerStatus();
        game.getRoll().firstFullRollOfDice();
        System.out.println(game.getRoll().getDiceRollValues());
        game.getRoll().reRollDice();
        System.out.println(game.getRoll().getDiceRollValues());
        game.setActivePlayerScore();
        System.out.println(game.getPlayer1().getScore());
        System.out.println(game.getPlayer2().getScore());
    }
}

