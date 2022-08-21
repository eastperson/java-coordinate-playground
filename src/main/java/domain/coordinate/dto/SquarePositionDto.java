package domain.coordinate.dto;

public class SquarePositionDto {

    private final PositionCreateDto first;
    private final PositionCreateDto second;
    private final PositionCreateDto third;
    private final PositionCreateDto fourth;

    public SquarePositionDto(PositionCreateDto first, PositionCreateDto second, PositionCreateDto third, PositionCreateDto fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public PositionCreateDto getFirst() {
        return first;
    }

    public PositionCreateDto getSecond() {
        return second;
    }

    public PositionCreateDto getThird() {
        return third;
    }

    public PositionCreateDto getFourth() {
        return fourth;
    }
}
