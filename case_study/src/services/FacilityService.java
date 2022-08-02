package services;

import java.util.ArrayList;

public interface FacilityService<E> extends Service<E> {
    ArrayList<E> search(String name);
}
