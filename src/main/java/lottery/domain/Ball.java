package lottery.domain;

import java.util.Objects;

public class Ball {
    private static final int MAX = 45;
    private static final int MIN = 1;

    private final int number;

    public Ball(final int number) {
        if (validateBallNumberRange(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    private static boolean validateBallNumberRange(final int number) {
        return !(number >= MIN && number <= MAX);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
