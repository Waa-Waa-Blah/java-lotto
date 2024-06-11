package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum LottoNumberRules implements LottoNumberRule {

    RANDOM {
        @Override
        public List<Integer> pick() {
            List<Integer> integers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

            Collections.shuffle(integers);
            return integers.stream().limit(6)
                    .sorted()
                    .collect(Collectors.toUnmodifiableList());
        }
    }
}
