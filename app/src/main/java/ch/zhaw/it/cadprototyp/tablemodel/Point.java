package ch.zhaw.it.cadprototyp.tablemodel;


import ch.zhaw.it.cadprototyp.observer.BaseObservable;
import ch.zhaw.it.cadprototyp.observer.Observable;

public class Point {

    private boolean isVisible;
    private double x;
    private double y;

    private final BaseObservable<PointRecord> pointPositionProperty = new BaseObservable<>();
    private final BaseObservable<Boolean> visibilityProperty = new BaseObservable<>();


    public Point(double x, double y, boolean isVisible) {
        this.x = x;
        this.y = y;
        this.isVisible = isVisible;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean getVisibility() {
        return isVisible;
    }

    public PointRecord getPointRecord() {
        return new PointRecord(x, y);
    }

    public void setVisibility(boolean isVisible) {
        if (this.isVisible != isVisible) {
            boolean oldValue = this.isVisible;
            this.isVisible = isVisible;
            visibilityProperty.notifyObserver(oldValue, isVisible);
        }
    }

    /**
     * Moves the point by the given delta values.
     *
     * @param deltaX the delta value for the x-coordinate
     * @param deltaY the delta value for the y-coordinate
     */
    public void move(double deltaX, double deltaY) {
        PointRecord oldValue = new PointRecord(x, y);
        this.x += deltaX;
        this.y += deltaY;
        PointRecord newValue = new PointRecord(x, y);
        pointPositionProperty.notifyObserver(oldValue, newValue);
    }

    public void moveTo(double x, double y) {
        PointRecord oldValue = new PointRecord(x, y);
        this.x = x;
        this.y = y;
        PointRecord newValue = new PointRecord(x, y);
        pointPositionProperty.notifyObserver(oldValue, newValue);
    }

    public Observable<PointRecord> pointPositionProperty() {
        return pointPositionProperty;
    }

    public Observable<Boolean> visibilityProperty() {
        return visibilityProperty;
    }

    /**
     * Record for a point with x and y coordinates.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public record PointRecord(double x, double y){

        /**
         * Compares two points with a given delta.
         *
         * @param p the point to compare with
         * @param delta value in which the points are considered equal
         * @return true if the points are equal, false otherwise
         */
        public boolean equals(PointRecord p, double delta) {
            return Math.abs(this.x - p.x) < delta && Math.abs(this.y - p.y) < delta;
        }
    }
}
