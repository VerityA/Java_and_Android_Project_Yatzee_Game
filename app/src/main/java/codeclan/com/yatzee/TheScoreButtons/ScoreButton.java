package codeclan.com.yatzee.TheScoreButtons;

/**
 * Created by user on 25/03/2018.
 */

public abstract class ScoreButton implements IScorePoints {
    private Strategy strategyType;
    private Integer scoreValue;
//    private Integer p2ScoreValue;

    public ScoreButton(Strategy strategyType) {
        this.strategyType = strategyType;
        this.scoreValue = null;
//        this.p2ScoreValue = null;
    }

    public Strategy getStrategyType() {
        return strategyType;
    }

    public Integer getScoreValue() {
        return scoreValue;
    }

//    public Integer getP2ScoreValue() {
//        return p2ScoreValue;
//    }

    public void setScoreValue(Integer scoreValue) {
        this.scoreValue = scoreValue;
    }

//    public void setP2ScoreValue(Integer scoreValue) {
//
//    }

}
