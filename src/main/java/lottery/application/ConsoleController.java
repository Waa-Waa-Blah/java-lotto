package lottery.application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleController {
    private static final Scanner sc = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (InputMismatchException exception) {
            System.out.println("구입 금액은 숫자여야 합니다.");
            return inputMoney();
        }
    }

    public List<Integer> inputWinningBalls() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            return parseNumbers(sc.nextLine());
        } catch (NoSuchElementException e) {
            System.out.println("입력을 해주세요");
            return inputWinningBalls();
        } catch (NumberFormatException e) {
            System.out.println("숫자와 쉼표만 입력해야 합니다.");
            return inputWinningBalls();
        }
    }

    public Integer inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (InputMismatchException exception) {
            System.out.println("숫자만 입력해 주세요.");
            return inputBonusBall();
        }
    }

    private List<Integer> parseNumbers(String numberString) {
        return Arrays.stream(numberString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
