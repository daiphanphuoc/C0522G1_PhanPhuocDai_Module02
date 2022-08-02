package services;

import java.util.ArrayList;

public interface FacilityService<E> extends Service{
    ArrayList<E> search(String name);
}
