package lottery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lottery.domain.Lotto;
import lottery.domain.LottoNumberRules;
import lottery.domain.Money;
import lottery.domain.Prize;
import lottery.domain.WinningLotto;

public class LottoApplication {
    public List<Lotto> purchase(final int number) {
        Money money = new Money(number);

        return IntStream.range(0, money.count())
                .mapToObj(i -> new Lotto(LottoNumberRules.RANDOM))
                .collect(Collectors.toList());
    }


    public List<Prize> winner(final List<Lotto> lottos, final WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> winningLotto.match(lotto))
                .map(Prize::compare)
                .collect(Collectors.toUnmodifiableList());
    }
}
