package lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lottery.application.ConsoleController;
import lottery.controller.LottoApplication;
import lottery.domain.Ball;
import lottery.domain.Lotto;
import lottery.domain.Prize;
import lottery.domain.WinningLotto;

public class Main {
    public static void main(String[] args) {
        ConsoleController consoleController = new ConsoleController();
        LottoApplication lottoApplication = new LottoApplication();
        int money = consoleController.inputMoney();
        List<Lotto> lottos = lottoApplication.purchase(money);
        for (Lotto lotto : lottos) {
            lotto.getBalls().stream().mapToInt(Ball::getNumber).sorted().forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
        List<Integer> balls = consoleController.inputWinningBalls();
        Integer bonus = consoleController.inputBonusBall();
        WinningLotto winningLotto = new WinningLotto(new Lotto(balls), new Ball(bonus));

        List<Prize> result = lottoApplication.winner(lottos, winningLotto);

        Map<Prize, Integer> prizeIntegerMap = new HashMap();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Prize prize : result) {
            prizeIntegerMap.put(prize, prizeIntegerMap.getOrDefault(prize, 0) + 1);
        }
        System.out.printf("3개 일치 (5000원)- %s개%n", prizeIntegerMap.getOrDefault(Prize.FOURTH, 0));
        System.out.printf("4개 일치 (50000원)- %s개%n", prizeIntegerMap.getOrDefault(Prize.THIRD, 0));
        System.out.printf("5개 일치 (1500000원)- %s개%n", prizeIntegerMap.getOrDefault(Prize.SECOND, 0));
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원) - %s개%n",
                prizeIntegerMap.getOrDefault(Prize.SECOND_WITH_BONUS, 0));
        System.out.printf("6개 일치 (2000000000원)- %s개%n", prizeIntegerMap.getOrDefault(Prize.FIRST, 0));

        Integer totalPrize = result.stream().mapToInt(Prize::getPrize).sum();
        Double profit = Double.valueOf(totalPrize / money);
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n", profit);

        System.out.println("끝");
    }
}
