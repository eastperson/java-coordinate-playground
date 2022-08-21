package domain.car;

public class K5 implements Car {

    private static final String NAME = "K5";
    private static final double DISTANCE_PER_LITER = 13;
    private final double tripDistance;

    public K5(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return this.tripDistance;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
