package ss17_io_byte.exercise.product_management.service;

import java.util.List;

public interface IService<E> {
    void add();

    void display();

    List<E> search(String name);
}
