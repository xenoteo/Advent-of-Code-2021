package xenoteo.com.github.day05;

/**
 * The class representing a line from point1 to point2 on a 2D plane.
 */
public class Line {

    public final Point point1;
    public final Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public String toString() {
        return point1 + " -> " + point2;
    }
}
