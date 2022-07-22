package exercise.student_management_file.service.impl;

import com.sun.istack.internal.NotNull;
import exercise.student_management_file.model.Person;
import exercise.student_management_file.service.IPersonService;
import exercise.student_management_file.until.UtilCompare;

import java.util.List;
import java.util.Scanner;

public abstract class PersonService implements IPersonService<Person>  {
    private Scanner sc = new Scanner(System.in);









   /* public  void insertionSort( List<Person> list ){
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
    }*/


}
