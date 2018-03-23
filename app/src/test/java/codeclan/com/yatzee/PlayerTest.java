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
        player.increasePlayerScore(25);
        assertEquals(25, player.getScore());
    }

    @Test
    public void canChangeActivePlayerStatus() {
        assertEquals(true, player.isActivePlayer());
        player.changeActivePlayerStatus();
        assertEquals(false, player.isActivePlayer());
    }
}
