package ss07_abstract_class_and_interface.practice.animal_and_edible.controller;

import ss07_abstract_class_and_interface.practice.animal_and_edible.model.*;
import ss07_abstract_class_and_interface.practice.animal_and_edible.services.Edible;

public class AbstractAndInterfaceController {

    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }


        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
