package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 23/03/2018.
 */

public class PlayerTest {

    Player player;

    @Before
    public void before() {
        player = new Player(true);
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


}
