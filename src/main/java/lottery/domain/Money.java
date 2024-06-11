package lottery.domain;

public class Money {
    private static final int MONEY_UNIT = 1000;

    private final Integer value;

    public Money(Integer value) {
        validate(value);
        this.value = value;
    }

    private static void validate(final Integer value) {
        validatePositiveNumber(value);
        validateUnit(value);
    }

    private static void validateUnit(final Integer value) {
        if (value % MONEY_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePositiveNumber(final Integer value) {
        if (0 >= value) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getValue() {
        return this.value;
    }

    public Integer count() {
        return this.value / MONEY_UNIT;
    }
}
