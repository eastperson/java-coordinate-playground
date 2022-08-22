package domain.coordinate.polygon;

import domain.coordinate.Position;
import domain.coordinate.dto.SquarePositionDto;

public class Square implements Polygon{

    private final Position first;
    private final Position second;
    private final Position third;
    private final Position fourth;

    @Override
    public double area() {
        return width() * height();
    }

    public double width() {
        int max = Math.max(Math.max(first.getX(), second.getX()), Math.max(third.getX(), fourth.getX()));
        int min = Math.min(Math.min(first.getX(), second.getX()), Math.min(third.getX(), fourth.getX()));
        return max - min;
    }

    public double height() {
        int max = Math.max(Math.max(first.getY(), second.getY()), Math.max(third.getY(), fourth.getY()));
        int min = Math.min(Math.min(first.getY(), second.getY()), Math.min(third.getY(), fourth.getY()));
        return max - min;
    }

    public Square(Position first, Position second, Position third, Position fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public static Square create(SquarePositionDto squarePositionDto) {
        return new Square(
                Position.create(squarePositionDto.getFirst().getX(), squarePositionDto.getFirst().getY()),
                Position.create(squarePositionDto.getSecond().getX(), squarePositionDto.getSecond().getY()),
                Position.create(squarePositionDto.getThird().getX(), squarePositionDto.getThird().getY()),
                Position.create(squarePositionDto.getFourth().getX(), squarePositionDto.getFourth().getY())
        );
    }
}
