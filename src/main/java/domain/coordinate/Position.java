package domain.coordinate;

public class Position {

    private final int x;
    private final int y;

    private Position(int x, int y) {
        validate(x);
        validate(y);
        this.x = x;
        this.y = y;
    }

    private void validate(int number) {
        if (number < 0 || 24 < number) {
            throw new CoordinateException("좌표는 0부터 24까지 숫자만 들어갈 수 있습니다.");
        }
    }

    public static Position create(int x, int y) {
        return new Position(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public double distance(Position target) {
        return Math.sqrt(Math.pow(this.x - target.x, 2) + Math.pow(this.y - target.y, 2));
    }
}
