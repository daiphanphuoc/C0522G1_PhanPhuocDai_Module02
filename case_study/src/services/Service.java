package services;

import java.util.ArrayList;

public interface Service<E> {
    void  add();

    void display();

    void update(String id);

    void remove(String id);

    int find(String id);

    ArrayList<E> search(String name);
}
