package domain;

import domain.coordinate.polygon.Triangle;
import domain.coordinate.dto.TrianglePositionDto;
import domain.coordinate.exception.CoordinateException;
import domain.coordinate.Position;
import domain.coordinate.PositionParser;
import domain.coordinate.polygon.Square;
import domain.coordinate.dto.DoublePositionDto;
import domain.coordinate.dto.PositionCreateDto;
import domain.coordinate.dto.SquarePositionDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

public class PositionTest {

    @Test
    @DisplayName("Position 생성")
    void create_position() {
        Position position = Position.create(10, 10);
        assertThat(position).isEqualTo(Position.create(10, 10));
    }

    @Test
    @DisplayName("Position 좌표가 24보다 넘어가면 에러가 발생")
    void create_position_exception_more_than() {
        assertThatThrownBy(() -> Position.create(25, 25)).isInstanceOf(CoordinateException.class);
    }

    @Test
    @DisplayName("Position 좌표가 0보다 작으면 에러가 발생")
    void create_position_exception_less_than() {
        assertThatThrownBy(() -> Position.create(-1, -2)).isInstanceOf(CoordinateException.class);
    }

    @Test
    @DisplayName("Position 파싱")
    void create_position_parse() {
        String inputPosition = "10,10";
        PositionCreateDto createDto = PositionParser.parse(inputPosition);
        Position position = Position.create(createDto.getX(), createDto.getY());
        assertThat(position).isEqualTo(Position.create(10, 10));
    }

    @Test
    @DisplayName("Position 파싱 - 구분자가 이상하면 에러 발생")
    void create_position_parse_exception() {
        String inputPosition = "10,10,10";
        assertThatThrownBy(() -> PositionParser.parse(inputPosition)).isInstanceOf(CoordinateException.class);
    }

    @Test
    @DisplayName("Position 파싱 - 두개 포지션")
    void create_position_parse_2_position() {
        String doublePosition = "(10,10)-(14,15)";
        DoublePositionDto doublePositionDto = PositionParser.doubleParse(doublePosition);
        Position firstPosition = Position.create(doublePositionDto.firstX(), doublePositionDto.firstY());
        Position secondPosition = Position.create(doublePositionDto.secondX(), doublePositionDto.secondY());
        assertThat(firstPosition.distance(secondPosition)).isEqualTo(6.403124, offset(0.00099));
    }

    @Test
    @DisplayName("Position 거리 계산")
    void position_distance_calculate() {
        Position position = Position.create(10, 10);
        Position target = Position.create(14, 15);
        double distance = position.distance(target);
        assertThat(distance).isEqualTo(6.403124, offset(0.00099));
    }

    /**
     * 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
     * 좌표값을 네 개 입력한 경우, 네 점을 연결하는 사각형으로 가정한다.
     * 네 점이 뒤틀어진 사다리꼴이나 마름모는 제외하고 직사각형만 허용하도록 검사한다.
     * 사각형인 경우 사각형의 넓이를 계산해서 출력한다.
     */
    @Test
    @DisplayName("Position 파싱 - 사각형 면적")
    void create_position_parse_square() {
        String squarePosition = "(10,10)-(22,10)-(22,18)-(10,18)";
        SquarePositionDto squarePositionDto = PositionParser.squareParse(squarePosition);
        Square square = Square.create(squarePositionDto);
        assertThat(square.area()).isEqualTo(96);
    }

    @Test
    @DisplayName("Position 파싱 - 삼각형 면적")
    void create_position_parse_triangle() {
        String trianglePosition = "(10,10)-(14,15)-(20,8)";
        TrianglePositionDto trianglePositionDto = PositionParser.triangleParse(trianglePosition);
        Triangle triangle = Triangle.create(trianglePositionDto);
        assertThat(triangle.area()).isEqualTo(29, offset(0.000000000001));
    }
}
