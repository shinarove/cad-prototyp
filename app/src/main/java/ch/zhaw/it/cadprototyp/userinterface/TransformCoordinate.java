package ch.zhaw.it.cadprototyp.userinterface;

public class TransformCoordinate {


    static double transformX(double x, double centerX) {
        return x - centerX;
    }

    static double transformY(double y, double centerY) {
        return centerY - y;
    }
}
