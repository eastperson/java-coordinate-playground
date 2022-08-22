package coordinate;

import coordinate.creator.FigureCreator;
import coordinate.creator.LineCreator;
import coordinate.creator.RectangleCreator;
import coordinate.creator.TriangleCreator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {

    public static final Map<Integer, FigureCreator> map = new HashMap<>();

    static {
        map.put(Line.LINE_POINT_SIZE, new LineCreator());
        map.put(Triangle.TRIANGLE_POINT_SIZE, new TriangleCreator());
        map.put(Rectangle.RECTANGLE_POINT_SIZE, new RectangleCreator());
    }

    static Figure getInstance(List<Point> points) {

        FigureCreator figureCreator = map.get(points.size());
        if (figureCreator == null) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }
        return figureCreator.create(points);
    }
}
