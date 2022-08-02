package service;

public interface Service<E> {
    void add();

    void delete(String id);

    void update(String id);

    void display();

    void find(String data);
}
