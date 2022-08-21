package domain.coordinate.dto;

public class DoublePositionDto {
    private final PositionCreateDto first;
    private final PositionCreateDto second;

    public DoublePositionDto(PositionCreateDto first, PositionCreateDto second) {
        this.first = first;
        this.second = second;
    }

    public int firstX() {
        return this.first.getX();
    }

    public int firstY() {
        return this.first.getY();
    }

    public int secondX() {
        return this.second.getX();
    }

    public int secondY() {
        return this.second.getY();
    }
}
