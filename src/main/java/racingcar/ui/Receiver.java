package racingcar.ui;

import java.util.Scanner;

public class Receiver {
    private static final Scanner scanner = new Scanner(System.in);

    public String receiveCarNames() {
        return scanner.nextLine();
    }

    public int receiveNumberOfRounds() {
        return scanner.nextInt();
    }

    public void clearBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
