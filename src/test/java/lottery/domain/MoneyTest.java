package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @Test
    void 금액을_갖고있다() {
        Money money = new Money(14000);
        assertThat(money.getValue()).isEqualTo(14000);
    }

    @Test
    void 금액은_천원단위다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(1400));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    void 금액은_양수어야한다(int value) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(value));
    }
}
