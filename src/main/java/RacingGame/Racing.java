package RacingGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private int time;
    private List<Car> cars;
    private OutputView outputView;

    public Racing(int time, List<String> inputCarNames) {
        this.time = time;
        this.cars = this.arrayWithCar(inputCarNames);
        this.outputView = new OutputView();
    }

    public int getTime() {
        return time;
    }

    private List<Car> arrayWithCar(List<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
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
            OutputView.printRace(this.cars);
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
}
