package domain.company;

import domain.car.Car;

public class CarReport {

    private final String report;

    public CarReport(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName());
        stringBuilder.append(" : ");
        stringBuilder.append(((int) car.getChargeQuantity()));
        stringBuilder.append("리터");
        this.report = stringBuilder.toString();
    }

    public String report() {
        return report;
    }
}
