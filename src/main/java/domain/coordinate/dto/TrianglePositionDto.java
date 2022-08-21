package domain.coordinate.dto;

public class TrianglePositionDto {

    private final PositionCreateDto first;
    private final PositionCreateDto second;
    private final PositionCreateDto third;

    public TrianglePositionDto(PositionCreateDto first, PositionCreateDto second, PositionCreateDto third) {
        this.first = first;
        this.second = second;
        this.third = third;
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
}
