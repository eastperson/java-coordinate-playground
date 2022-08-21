package domain.coordinate;

import domain.coordinate.dto.DoublePositionDto;
import domain.coordinate.dto.PositionCreateDto;
import domain.coordinate.dto.SquarePositionDto;
import domain.coordinate.dto.TrianglePositionDto;
import domain.coordinate.exception.CoordinateException;

public class PositionParser {

    public static SquarePositionDto squareParse(String squarePosition) {
        String[] split = squarePosition.split("-");
        String first = split[0];
        String second = split[1];
        String third = split[2];
        String fourth = split[3];
        return new SquarePositionDto(parse(clean(first)), parse(clean(second)), parse(clean(third)), parse(clean(fourth)));
    }

    public static DoublePositionDto doubleParse(String doublePosition) {
        String[] split = doublePosition.split("-");
        String first = split[0];
        String second = split[1];
        return new DoublePositionDto(parse(clean(first)), parse(clean(second)));
    }

    private static String clean(String str) {
        str = str.replace("(", "");
        str = str.replace(")", "");
        return str;
    }

    public static PositionCreateDto parse(String inputPosition) {
        try {
            String[] splitInput = toArray(inputPosition);
            int x = Integer.parseInt(splitInput[0]);
            int y = Integer.parseInt(splitInput[1]);
            validate(x);
            validate(y);
            return new PositionCreateDto(x, y);
        } catch (NumberFormatException e) {
            throw new CoordinateException("숫자가 아닌 값이 입력되었습니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CoordinateException("구분자 입력이 잘못되었습니다.");
        }
    }

    private static String[] toArray(String inputPosition) {
        String[] splitInput = inputPosition.split(",");
        if (splitInput.length != 2) {
            throw new CoordinateException("형식에 맞지 않는 문자열입니다.");
        }
        return splitInput;
    }

    private static void validate(int number) {
        if (number < 0 || 24 < number) {
            throw new CoordinateException("좌표는 0부터 24까지 숫자만 들어갈 수 있습니다.");
        }
    }

    public static TrianglePositionDto triangleParse(String trianglePosition) {
        String[] split = trianglePosition.split("-");
        String first = split[0];
        String second = split[1];
        String third = split[2];
        return new TrianglePositionDto(parse(clean(first)), parse(clean(second)), parse(clean(third)));
    }
}
