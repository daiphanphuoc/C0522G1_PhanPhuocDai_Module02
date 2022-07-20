package exercise.student_management.service;

import exercise.student_management.model.Person;
import exercise.student_management.model.Student;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public interface IService<E> {
    void add();
    void display();
    void delete(String id);
    E find(String id);
    ArrayList<E> search(String name);
    void insertionSort(@NotNull List<E> list );
}
