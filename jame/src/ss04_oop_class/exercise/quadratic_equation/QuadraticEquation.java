package ss04_oop_class.exercise.quadratic_equation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    QuadraticEquation() {
    }

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }


    public double getDiscriminant() {
        return Math.pow(getB(),2) - 4 * getA() * getC();
    }

    public double  getRoot1(){
        if(getDiscriminant()>=0){
            return (-getB()-Math.pow(getDiscriminant(),0.5))/(2*getA());
        }
        return 0;
    }
    public double  getRoot2(){
        if(getDiscriminant()>=0){
            return (-getB()+Math.pow(getDiscriminant(),0.5))/(2*getA());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "QuadraticEquation{" + a +"x^2 + " + b +"x + " + c +" = 0}";
    }
}
