package exercise.student_management_file.service.impl;

import exercise.student_management_file.model.Person;
import exercise.student_management_file.service.IPersonService;
import exercise.student_management_file.until.UtilCompare;
import exercise.student_management_file.until.UtilFile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class PersonService implements IPersonService {
    private Scanner sc = new Scanner(System.in);


    @Override
    public void add() {

    }

    @Override
    public void display() {
        for (Person person: DataService.studentList){
                System.out.println(person);
        }

        for (Person person: DataService.teacherList){
                System.out.println(person);
        }

    }



    @Override
    public void delete(String id) {

    }

    @Override
    public Person find(String id) {
        return null;
    }

    @Override
    public ArrayList<Person> search(String name) {
        return null;
    }

    public  void insertionSort(@NotNull List<Person> list ){
        for (int i=1;i<list.size();i++){
            Person key=list.get(i);
            int j=i;
            for(;j>0;j--){

                if(UtilCompare.compareString(key.getName(),list.get(j-1).getName())==-1){
                    list.set(j,list.get(j-1));
                }else{
                    break;
                }
            }
            list.set(j,key);
        }
    }


}
