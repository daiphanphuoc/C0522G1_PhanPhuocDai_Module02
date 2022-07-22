package exercise.student_management_file.service;

import java.util.ArrayList;

public interface IService<E> {
    void add();

    void display();

    void delete(String id);

    E find(String id);

    ArrayList<E> search(String name);

    void insertionSort();

    void update(String string);
}
