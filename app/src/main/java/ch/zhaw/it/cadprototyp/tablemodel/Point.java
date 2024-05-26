package ch.zhaw.it.cadprototyp.tablemodel;

import ch.zhaw.it.cadprototyp.tablemodel.observerpattern.Observable;
import ch.zhaw.it.cadprototyp.tablemodel.observerpattern.Observer;

public class Point {

    private boolean isVisible;
    private double x;
    private double y;

    public enum PointProperties {
        VISIBILITY,
        POINT_POSITION
    }

    private final Observable<Boolean, PointProperties> pointVisibility;
    private final Observable<PointRecord, PointProperties> pointPosition;


    public Point(double x, double y, boolean isVisible) {
        this.x = x;
        this.y = y;
        this.isVisible = isVisible;
        pointPosition = new Observable<>(PointProperties.POINT_POSITION);
        pointVisibility = new Observable<>(PointProperties.VISIBILITY);
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
            pointVisibility.fireUpdate(oldValue, isVisible);
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
        pointPosition.fireUpdate(oldValue, newValue);
    }

    public void moveTo(double x, double y) {
        PointRecord oldValue = new PointRecord(x, y);
        this.x = x;
        this.y = y;
        PointRecord newValue = new PointRecord(x, y);
        pointPosition.fireUpdate(oldValue, newValue);
    }

    public void addObserver(Observer<PointProperties> observer) {
        pointVisibility.addObserver(observer);
        pointPosition.addObserver(observer);
    }

    public void removeObserver(Observer<PointProperties> observer) {
        pointVisibility.addObserver(observer);
        pointPosition.removeObserver(observer);
    }

    public record PointRecord(double x, double y){

        public boolean equals(PointRecord p, double delta) {
            return Math.abs(this.x - p.x) < delta && Math.abs(this.y - p.y) < delta;
        }
    }
}
