package domain.company;

import domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();
    private List<CarReport> reports = new ArrayList<>();

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<CarReport> generateReport() {
        this.cars.forEach(car -> {
            reports.add(new CarReport(car));
        });
        return reports;
    }
}
