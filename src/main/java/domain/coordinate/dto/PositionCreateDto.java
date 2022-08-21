package domain.coordinate.dto;

public class PositionCreateDto {
    private final int x;
    private final int y;

    public PositionCreateDto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
