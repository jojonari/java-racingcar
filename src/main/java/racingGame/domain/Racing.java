package racingGame.domain;

import racingGame.Util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private int time;
    private List<Car> cars;

    private final int MIN_TIME = 1;
    private final int MAX_TIME = 999;

    public Racing(int time, List<String> inputCarNames) {
        this.validConstructTime(time);
        this.constructRacingValidNames(inputCarNames);
        this.time = time;
        this.cars = this.arrayWithCar(inputCarNames);
    }

    public int getTime() {
        return time;
    }

    private List<Car> arrayWithCar(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void raceCarMoveLoop() {
        for (Car car : this.cars) {
            car.nextRace(new RandomNumber());
        }
    }

    public void raceStart() {
        for (int i = 0; i < this.time; i++) {
            this.raceCarMoveLoop();
        }
    }

    public int maxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get().getPosition();
    }

    public List<String> getWinnerNames() {
        int maxPosition = maxPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void validConstructTime(int time) {
        if (time > MAX_TIME || time < MIN_TIME) {
            throw new IllegalArgumentException();
        }
    }

    public void constructRacingValidNames(List<String> inputNames) {
        for (String inputName : inputNames) {
            Util.stringName(inputName);
        }

    }
}
