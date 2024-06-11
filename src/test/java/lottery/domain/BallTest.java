package lottery.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {
    @Test
    void tset() {
        Integer a = 1;
        Integer b = 1;

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
    }

    @Test
    void 숫자_하나를_가진다() {
        Ball ball = new Ball(1);

        Assertions.assertThat(ball.getNumber()).isEqualTo(1);
    }

    @ValueSource(ints = {1, 2, 3, 43, 44, 45})
    @ParameterizedTest
    void 숫자는_1부터_45_사이여야_한다(final int number) {
        assertDoesNotThrow(() -> new Ball(number));
    }

    @ValueSource(ints = {-1, 0, 46, 47})
    @ParameterizedTest
    void 숫자는_1부터_45_사이가_아니면_예외_처리한다(final int number) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ball(number));
    }
}
