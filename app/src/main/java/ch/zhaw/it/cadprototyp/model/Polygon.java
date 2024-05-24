package ch.zhaw.it.cadprototyp.model;

import java.util.ArrayList;
import java.util.List;

import static ch.zhaw.it.cadprototyp.SystemConfiguration.SYSTEM_DELTA;

public class Polygon {
    /**
     * The lines of the polygon.
     */
    private final List<Line> lines = new ArrayList<>();
    /**
     * Indicates if the polygon is closed.
     */
    private boolean closed;

    /**
     * Constructor to create an open polygon.
     *
     * @param lines the lines of the polygon
     */
    public Polygon(List<Line> lines) {
        this.lines.addAll(lines);
        closed = false;
    }

    /**
     * Constructor to create a closed triangle.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     */
    public Polygon(Point p1, Point p2, Point p3) {
        lines.add(new Line(p1, p2));
        lines.add(new Line(p2, p3));
        lines.add(new Line(p3, p1));
        closed = true;
    }

    /**
     * Constructor to create a closed rectangle.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @param p4 the fourth point
     */
    public Polygon(Point p1, Point p2, Point p3, Point p4) {
        lines.add(new Line(p1, p2));
        lines.add(new Line(p2, p3));
        lines.add(new Line(p3, p4));
        lines.add(new Line(p4, p1));
        closed = true;
    }

    public void closePolygon() {
        Point.PointRecord firstPoint = lines.getFirst().getStartPoint();
        Point.PointRecord lastPoint = lines.getLast().getEndPoint();
        if (!closed && firstPoint.equals(lastPoint, SYSTEM_DELTA)) {
            lines.getLast().moveEndPoint(firstPoint.x(), firstPoint.y());
            closed = true;
        } else if (!closed) {
            Point startPoint = new Point(lastPoint.x(), lastPoint.y());
            Point endPoint = new Point(firstPoint.x(), firstPoint.y());
            Line newLine = new Line(startPoint, endPoint);
            lines.add(newLine);
            closed = true;
        }
    }
}
