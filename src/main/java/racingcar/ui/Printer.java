package racingcar.ui;

import racingcar.domain.Car;

public class Printer {
    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String INPUT_MISMATCH_EXCEPTION_MESSAGE = "라운드 횟수로 숫자만 입력하실 수 있습니다.";

    public void requestCarName() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    public void requestNumberOfRounds() {
        System.out.println(ROUND_REQUEST_MESSAGE);
    }

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void printWinner(String winnerNames) {
        System.out.println(winnerNames + WINNER_MESSAGE);
    }

    public void printCarState(Car car) {
        System.out.println(car);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printInputMismatchExceptionMessage(Receiver receiver) {
        receiver.clearBuffer();
        System.out.println(INPUT_MISMATCH_EXCEPTION_MESSAGE);
    }
}