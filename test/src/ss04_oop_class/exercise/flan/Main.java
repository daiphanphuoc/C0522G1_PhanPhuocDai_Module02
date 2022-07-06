package ss04_oop_class.exercise.flan;

public class Main {
    public static void main(String[] args) {

        Flan flanFast = new Flan(Flan.FAST, true, 10.0, "red");

        Flan flanMedium = new Flan(Flan.MEDIUM, false, 5.0, "blue");

        System.out.println(flanMedium);

        System.out.println(flanFast);
    }
}
