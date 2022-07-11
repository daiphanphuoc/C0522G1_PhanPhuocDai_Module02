package ss07_abstract_class_and_interface.practice.animal_and_edible.model;

import ss07_abstract_class_and_interface.practice.animal_and_edible.services.Edible;

public class Chicken extends Animal implements Edible {

    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "Chicken could be fried";
    }
}
