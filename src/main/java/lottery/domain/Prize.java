package lottery.domain;

public enum Prize {
    FIRST(2000000000, 6),
    SECOND_WITH_BONUS(30000000, 5),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    NOTHING(0, 0);

    private final Integer prize;
    private final Integer matchCount;

    Prize(final Integer prize, final Integer matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public Integer getPrize() {
        return prize;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public static Prize compare(Integer integer) {
        if (Prize.FOURTH.getMatchCount() == integer) {
            return Prize.FOURTH;
        }
        if (Prize.THIRD.getMatchCount() == integer) {
            return Prize.THIRD;
        }
        if (Prize.SECOND.getMatchCount() == integer) {
            return Prize.SECOND;
        }
        if (Prize.FIRST.getMatchCount() == integer) {
            return Prize.FIRST;
        }

        return NOTHING;
    }
}
