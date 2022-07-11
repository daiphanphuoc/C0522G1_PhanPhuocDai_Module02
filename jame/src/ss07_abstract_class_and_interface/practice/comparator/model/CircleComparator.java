package ss07_abstract_class_and_interface.practice.comparator.model;

import ss06_inheritance_polymorphirm.exercise.circle_cylinder.model.Circle;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle circle1, Circle circle2) {

        if (circle1.getRadius()>circle2.getRadius()){
            return 1;
        }

        if(circle1.getRadius()<circle2.getRadius()){
            return -1;
        }

        return 0;
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator thenComparing(Comparator other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public Comparator thenComparingInt(ToIntFunction keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator thenComparingLong(ToLongFunction keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }

    @Override
    public Comparator thenComparing(Function keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator thenComparing(Function keyExtractor, Comparator keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }
}
