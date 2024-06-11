package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 테스트")
class LottoTest {
    @Test
    void 로또는_번호는_생성자로_6개를_전달받는다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getBalls().size()).isEqualTo(6);
    }

    @Test
    void 로또_번호가_중복되면_예외_처리한다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(1, 2, 2, 3, 4, 5));
    }

    @Test
    void 랜덤_로또를_생성한다() {
        Lotto lotto = new Lotto(() -> List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }
}
