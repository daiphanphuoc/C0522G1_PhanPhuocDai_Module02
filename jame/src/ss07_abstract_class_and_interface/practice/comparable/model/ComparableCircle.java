package ss07_abstract_class_and_interface.practice.comparable.model;

import org.jetbrains.annotations.NotNull;
import ss06_inheritance_polymorphirm.exercise.circle_cylinder.model.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius, String color) {
        super(radius, color);
    }

    @Override
    public int compareTo(@NotNull ComparableCircle o) {
        if(getRadius()>o.getRadius()){
            return 1;
        }else if(getRadius()<o.getRadius()){
            return -1;
        }
        return 0;
    }
}
