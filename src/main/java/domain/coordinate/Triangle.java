package domain.coordinate;

import domain.coordinate.dto.TrianglePositionDto;

public class Triangle {

    private final Position first;
    private final Position second;
    private final Position third;

    public Triangle(Position first, Position second, Position third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static Triangle create(TrianglePositionDto trianglePositionDto) {
        return new Triangle(
                Position.create(trianglePositionDto.getFirst().getX(), trianglePositionDto.getFirst().getY()),
                Position.create(trianglePositionDto.getSecond().getX(), trianglePositionDto.getSecond().getY()),
                Position.create(trianglePositionDto.getThird().getX(), trianglePositionDto.getThird().getY())
        );
    }

    /**
     * 헤론의 공식
     * 각 변의 길이가 a, b, c인 삼각형이 있고 s = (a + b + c) / 2 라고 할 때
     * 삼각형의 넓이 S는 S=Math.sqrt(s * (s - a) * (s - b) * (s - c)) 이다.
     * @return
     */
    public double area() {
        double a = first.distance(second);
        double b = second.distance(third);
        double c = third.distance(first);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
