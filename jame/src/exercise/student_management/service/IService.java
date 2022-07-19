package exercise.student_management.service;

import exercise.student_management.model.Student;

import java.util.ArrayList;

public interface IService<E> {
    void add();
    void display();
    void delete(String id);
    E find(String id);
    ArrayList<E> search(String name);
}
