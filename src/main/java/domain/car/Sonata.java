package domain.car;

public class Sonata implements Car {

    private static final String NAME = "Sonata";
    private static final double DISTANCE_PER_LITER = 10;
    private final double tripDistance;

    public Sonata(double tripDistance) {
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
