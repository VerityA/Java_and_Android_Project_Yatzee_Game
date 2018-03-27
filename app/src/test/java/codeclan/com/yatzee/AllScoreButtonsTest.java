package codeclan.com.yatzee;

import org.junit.Before;
import org.junit.Test;

import codeclan.com.yatzee.Players.Player;
import codeclan.com.yatzee.TheScoreButtons.AllScoreButtons;

/**
 * Created by user on 27/03/2018.
 */

public class AllScoreButtonsTest {

    AllScoreButtons allScoreButtons;
    Player player1;
    Player player2;

    @Before
    public void before() {
        allScoreButtons = new AllScoreButtons();
        player1 = new Player(true);
        player2 = new Player(false);
    }

    @Test
    public void canGetActivePlayersScores() {

    }
}
