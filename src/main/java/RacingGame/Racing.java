package RacingGame;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Car> arrayWithCar(int carCount) {
        ArrayList<Car> cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
