package racingGame.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private int time;
    private List<Car> cars;

    private int MAX_TIME = 999;
    private int MIN_TIME = 1;

    public Racing(int time, List<String> inputCarNames) {
        this.validConstructTime(time);
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
            car.nextRace();
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
}
