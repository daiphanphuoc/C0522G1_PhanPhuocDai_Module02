package ss06_inheritance_polymorphirm.practice.model;

public class Square extends Rectangle{
    public Square() {
    }

    public Square(double size) {
        super(size, size);
    }

    public Square(String color, boolean filled, double length) {
        super(color, filled, length, length);
    }

    public double getWidth(){
        return getLength();
    }
    public void setWidth(double size){
        super.setWidth(size);
        setLength(size);
    }

    public void setLength(double size){
        setWidth(size);
    }

    @Override
    public String toString() {
        return "A Square with "
                +"size = "+getWidth()
                +", which is a subclass of "+ super.toString();
    }
}
