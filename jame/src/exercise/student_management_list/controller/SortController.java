package exercise.student_management_list.controller;

import exercise.student_management_list.service.impl.DataService;
import exercise.student_management_list.service.impl.PersonService;

public class SortController {
    public void sort(){
        PersonService personService=new PersonService();
        personService.insertionSort(DataService.personList);
    }
}
