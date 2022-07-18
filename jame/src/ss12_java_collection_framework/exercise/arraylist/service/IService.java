package ss12_java_collection_framework.exercise.arraylist.service;

import ss12_java_collection_framework.exercise.arraylist.model.Product;

import java.util.ArrayList;

public interface IService<E> {
    void add();

    void  display();

    void remove(String id);

    void update(String id);

    ArrayList<E> find(String name);

    void sort();

    void reverse();
}
