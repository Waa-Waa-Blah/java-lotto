package lottery.domain;

import java.util.Set;

public class WinningLotto {
    private final Lotto lotto;
    private final Ball bonusBall;

    public WinningLotto(final Lotto lotto, final Ball bonusBall) {
        if (lotto.contain(bonusBall)) {
            throw new IllegalArgumentException();
        }
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public Set<Ball> getWinningBall() {
        return lotto.getBalls();
    }

    public Ball getBonusBall() {
        return bonusBall;
    }

    public Integer match(final Lotto picked) {
        return lotto.countMatchBalls(picked);
    }
}
