package ss05_access_modifier_static.exercise.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle=new Circle(3);
        System.out.println("Radius : "+circle.getRadius());
        System.out.println("Area : "+circle.getArea());
    }
}
