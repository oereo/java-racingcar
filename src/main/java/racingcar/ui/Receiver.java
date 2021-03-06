package racingcar.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Receiver {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public List<String>  receiveCarNames() {
        String carNames = scanner.nextLine();
        return splitInputLine(carNames);
    }

    public int receiveNumberOfRounds() {
        int numberOfRounds = scanner.nextInt();
        return numberOfRounds;
    }

    public void clearBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    private List<String> splitInputLine(String line) {
        return Arrays.asList(line.split(DELIMITER));
    }

}
