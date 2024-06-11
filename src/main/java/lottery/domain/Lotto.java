package lottery.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final Set<Ball> balls;

    public Lotto(final LottoNumberRule random) {
        this(random.pick().stream().mapToInt(i -> i).toArray());
    }

    public Lotto(final int... numbers) {
        if (numbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        this.balls = Arrays.stream(numbers).mapToObj(Ball::new).collect(Collectors.toSet());
        if (balls.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto(final List<Integer> balls) {
        this(balls.stream().mapToInt(i -> i).toArray());
    }

    public Set<Ball> getBalls() {
        return this.balls;
    }

    public boolean contain(final Ball bonusBall) {
        return balls.contains(bonusBall);
    }

    public Integer countMatchBalls(Lotto otherLotto) {
        return otherLotto.balls.stream()
                .filter(this::contain)
                .collect(Collectors.toUnmodifiableList())
                .size();
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Lotto lotto = (Lotto) o;
        return Objects.equals(balls, lotto.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
