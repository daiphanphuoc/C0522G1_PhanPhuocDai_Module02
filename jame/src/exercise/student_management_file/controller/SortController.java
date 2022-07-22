package exercise.student_management_file.controller;

import exercise.student_management_file.service.impl.DataService;
import exercise.student_management_file.service.impl.PersonService;

public class SortController {
    public void sort(){
        PersonService personService=new PersonService();
        personService.insertionSort(DataService.personList);
    }
}
