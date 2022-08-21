package domain;

import domain.coordinate.CoordinateException;
import domain.coordinate.Position;
import domain.coordinate.PositionParser;
import domain.coordinate.dto.DoublePositionDto;
import domain.coordinate.dto.PositionCreateDto;
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
}