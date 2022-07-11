package ss06_inheritance_polymorphirm.exercise.moveable.model;

import ss06_inheritance_polymorphirm.exercise.point.model.Point2D;

public class MovablePoint extends Point2D {
    private float xSpeed=0;
    private float ySpeed=0;

    public MovablePoint() {
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float xSpeed,float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed() {float[] arr=new float[2];
        arr[0]=this.xSpeed;
        arr[1]=this.ySpeed;

        return arr;
    }

    public void setSpeed(float xSpeed,float ySpeed) {
        this.xSpeed=xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint move(){
        setX(getX()+xSpeed);
        setY(getY()+ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return super.toString()+"\tMovablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
}
