package lottery.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @Test
    void 당첨로또_생성() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Ball bonusBall = new Ball(45);

        WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);

        Assertions.assertThat(winningLotto.getWinningBall()).containsExactly(
                new Ball(1),
                new Ball(2),
                new Ball(3),
                new Ball(4),
                new Ball(5),
                new Ball(6)
        );
        Assertions.assertThat(winningLotto.getBonusBall()).isEqualTo(new Ball(45));
    }

    @Test
    void 보너스볼은_당첨번호에_있는_번호면_예외처리한다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Ball bonusBall = new Ball(1);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(lotto, bonusBall));
    }

    @Test
    void 일치하는_번호의_개수를_반환한다() {
        Lotto picked = new Lotto(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(4,5,6,7,8,9), new Ball(1));

        Assertions.assertThat(winningLotto.match(picked)).isEqualTo(3);
    }
}
