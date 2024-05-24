package ch.zhaw.it.cadprototyp.tablemodel;

import java.util.List;

public class Line {
    /**
     * The start point of the line.
     */
    private final Point startPoint;
    /**
     * The end point of the line.
     */
    private final Point endPoint;
    /**
     * The middle point of the line.
     */
    private Point middlePoint;
    /**
     * The length of the line.
     */
    private double length;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.middlePoint = calculateMiddlePoint();
        this.length = calculateLength();
    }

    private Point calculateMiddlePoint() {
        double x = (startPoint.getX() + endPoint.getX()) / 2;
        double y = (startPoint.getY() + endPoint.getY()) / 2;
        return new Point(x, y, true);
    }

    private double calculateLength() {
        double x = endPoint.getX() - startPoint.getX();
        double y = endPoint.getY() - startPoint.getY();
        return Math.sqrt(x * x + y * y);
    }

    public Point.PointRecord getStartPoint() {
        return startPoint.getPointRecord();
    }

    public Point.PointRecord getEndPoint() {
        return endPoint.getPointRecord();
    }

    public Point.PointRecord getMiddlePoint() {
        return middlePoint.getPointRecord();
    }

    public double getLength() {
        return length;
    }

    /**
     * Moves the line by the given delta values.
     * This methode should be called when moved by the middle point.
     *
     * @param deltaX the delta value for the x-coordinate
     * @param deltaY the delta value for the y-coordinate
     */
    public void move(double deltaX, double deltaY) {
        this.startPoint.move(deltaX, deltaY);
        this.middlePoint.move(deltaX, deltaY);
        this.endPoint.move(deltaX, deltaY);
    }

    public void moveStartPoint(double deltaX, double deltaY) {
        this.startPoint.move(deltaX, deltaY);
        this.middlePoint = calculateMiddlePoint();
        this.length = calculateLength();
    }

    public void moveStartPointTo(double x, double y) {
        this.startPoint.moveTo(x, y);
        this.middlePoint = calculateMiddlePoint();
        this.length = calculateLength();
    }

    public void moveEndPoint(double deltaX, double deltaY) {
        this.endPoint.move(deltaX, deltaY);
        this.middlePoint = calculateMiddlePoint();
        this.length = calculateLength();
    }

    public void moveEndPointTo(double x, double y) {
        this.endPoint.moveTo(x, y);
        this.middlePoint = calculateMiddlePoint();
        this.length = calculateLength();
    }

    public Polygon addBreakPoint(Point newPoint) {
        Line line1 = new Line(startPoint, newPoint);
        Line line2 = new Line(newPoint, endPoint);
        List<Line> lines = List.of(line1, line2);
        return new Polygon(lines);
    }
}
