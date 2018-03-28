package codeclan.com.yatzee.TheScoreButtons;

import codeclan.com.yatzee.Players.Player;
import codeclan.com.yatzee.TheGame.Game;

/**
 * Created by user on 25/03/2018.
 */

public abstract class ScoreButton implements IScorePoints {
    private Strategy strategyType;
    private Integer p1StrategyValue;
    private Integer p2StrategyValue;

    public ScoreButton(Strategy strategyType) {
        this.strategyType = strategyType;
        this.p1StrategyValue = null;
        this.p2StrategyValue = null;

    }

    public Strategy getStrategyType() {
        return strategyType;
    }

    public Integer getP1ScoreValue() {
        return p1StrategyValue;
    }

    public Integer getP2ScoreValue() {
        return p2StrategyValue;
    }

//    public Integer getActivePlayerStrategyValue(){
//        if (player.isActivePlayer()) {
//            return p1StrategyValue;
//        }
//        return p2StrategyValue;
//    }



    public void setP1ScoreValue(Integer scoreValue) {
        this.p1StrategyValue = scoreValue;
    }

    public void setP2ScoreValue(Integer scoreValue) {
        this.p2StrategyValue = scoreValue;
    }

//    public void setPlayerStrategyValue(Integer strategyValue, Player player) {
//        if (player == player1) {
//            this.p1StrategyValue = strategyValue;
//        }
//        else {
//            this.p2StrategyValue = strategyValue;
//        }
//    }

}
