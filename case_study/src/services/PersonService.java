package services;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public interface PersonService<E> extends Service<E> {
    ArrayList<E> search(@NotNull String name);
}
