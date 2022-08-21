package domain.company;

import domain.car.Car;

import java.util.List;
import java.util.StringJoiner;

public class RentCompany {

    private final static String DELIMITER = System.getProperty("line.separator");;
    private Cars cars = new Cars();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        this.cars.addCar(car);
    }

    public String generateReport() {
        List<CarReport> carReports = cars.generateReport();
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        carReports.forEach(report -> {
            stringJoiner.add(report.report());
        });
        return stringJoiner.toString();
    }
}
