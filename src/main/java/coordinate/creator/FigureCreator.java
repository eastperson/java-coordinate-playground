package coordinate.creator;

import coordinate.Figure;
import coordinate.Point;

import java.util.List;

public interface FigureCreator {
    Figure create(List<Point> points);
}
