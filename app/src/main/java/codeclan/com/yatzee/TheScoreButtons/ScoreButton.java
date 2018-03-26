package codeclan.com.yatzee.TheScoreButtons;

/**
 * Created by user on 25/03/2018.
 */

public abstract class ScoreButton implements IScorePoints {
    private Strategy strategyType;
    private Integer p1ScoreValue;
    private Integer p2ScoreValue;

    public ScoreButton(Strategy strategyType) {
        this.strategyType = strategyType;
        this.p1ScoreValue = null;
        this.p2ScoreValue = null;
    }

    public Strategy getStrategyType() {
        return strategyType;
    }

    public Integer getP1ScoreValue() {
        return p1ScoreValue;
    }

    public Integer getP2ScoreValue() {
        return p2ScoreValue;
    }

    public void setP1ScoreValue(Integer scoreValue) {
        this.p1ScoreValue = scoreValue;
    }

    public void setP2ScoreValue(Integer scoreValue) {
        this.p2ScoreValue = scoreValue;
    }

}
