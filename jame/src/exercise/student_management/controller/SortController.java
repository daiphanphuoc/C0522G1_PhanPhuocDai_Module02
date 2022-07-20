package exercise.student_management.controller;

import exercise.student_management.service.impl.DataService;
import exercise.student_management.service.impl.PersonService;

public class SortController {
    public void sort(){
        PersonService personService=new PersonService();
        personService.insertionSort(DataService.personList);
    }
}
