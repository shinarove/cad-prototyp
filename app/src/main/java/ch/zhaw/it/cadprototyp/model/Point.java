package ch.zhaw.it.cadprototyp.model;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public PointRecord getPointRecord() {
        return new PointRecord(x, y);
    }

    /**
     * Moves the point by the given delta values.
     *
     * @param deltaX the delta value for the x-coordinate
     * @param deltaY the delta value for the y-coordinate
     */
    public void move(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public record PointRecord(double x, double y){

        public boolean equals(PointRecord p, double delta) {
            return Math.abs(this.x - p.x) < delta && Math.abs(this.y - p.y) < delta;
        }
    }
}
