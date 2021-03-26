package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.List;

public class Winner {
    private static final String DELIMITER = ", ";
    private final List<Car> winnerNames;

    public Winner(List<Car> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public String getWinnerGroups() {
        StringBuilder winnerGroups = new StringBuilder();
        winnerGroups.append(winnerNames.get(0).getName());

        for (int i = 1; i < winnerNames.size(); i++) {
            Car winner = winnerNames.get(i);
            winnerGroups.append(DELIMITER);
            winnerGroups.append(winner.getName());
        }
        return winnerGroups.toString();
    }
}
