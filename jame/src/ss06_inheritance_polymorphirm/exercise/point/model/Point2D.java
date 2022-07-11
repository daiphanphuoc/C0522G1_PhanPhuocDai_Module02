package ss06_inheritance_polymorphirm.exercise.point.model;

import java.lang.reflect.Array;

public class Point2D {
    private float x = 0;
    private float y = 0;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public float[] getXY() {
        float[] arr = new float[2];
        arr[0] = getX();
        arr[1] = getY();
        return arr;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point(" + x + "," + y + ")";
    }
}
