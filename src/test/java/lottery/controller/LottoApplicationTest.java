package lottery.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lottery.domain.Ball;
import lottery.domain.Lotto;
import lottery.domain.Prize;
import lottery.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoApplicationTest {

    @Test
    void 당첨로또를_비교한다() {
        // given
        // 로또 리스트, 당첨번호, 보너스볼
        List<Lotto> lottoList = List.of(
                new Lotto(1,2,3,4,5,6),
                new Lotto(16,5,4,3,2,1)
        );
        Lotto winningLotto = new Lotto(1,2,3,4,5,6);
        Ball bonusBall = new Ball(7);

        LottoApplication lottoApplication = new LottoApplication();
        // when
        List<Prize> winner = lottoApplication.winner(lottoList, new WinningLotto(winningLotto, bonusBall));

        // then
        Assertions.assertThat(winner).contains(Prize.FIRST, Prize.SECOND);

    }
}
