package services;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public interface PersonService<E> extends Service{
    ArrayList<E> search(@NotNull String name);
}
