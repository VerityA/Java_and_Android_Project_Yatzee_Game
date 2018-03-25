package codeclan.com.yatzee.ScoreButtons;

/**
 * Created by user on 25/03/2018.
 */

public abstract class ScoreButtons implements IScorePoints {
    private Strategy strategyType;
    private int scoreValue;

    public ScoreButtons(Strategy strategyType) {
        this.strategyType = strategyType;
        this.scoreValue = 0;
    }

    public Strategy getStrategyType() {
        return strategyType;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }
}
