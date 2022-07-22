package exercise.student_management_list.service.impl;

import exercise.student_management_list.model.Person;
import exercise.student_management_list.service.IPersonService;
import exercise.student_management_list.until.Until;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class PersonService implements  IPersonService {
    private Scanner sc = new Scanner(System.in);


    @Override
    public void add() {

    }

    @Override
    public void display() {
        for (Person person:DataService.personList){
                System.out.println(person);
        }
    }

    public String getID(){
        System.out.print("Nhập vào mã:");
        String id = sc.nextLine();
        return id;
    }

    @Override
    public void delete(String id) {
        for (Person person : DataService.personList) {
            if (id.equals(person.getID())){
                System.out.println("Bạn chắc chắn xóa 1.yes:"+ person);
                int isRemove= Integer.parseInt(sc.nextLine());

                if(isRemove==1){
                    DataService.personList.remove(person);
                    System.out.println("Bạn đã xóa thành công!");
                }
                break;
            }
        }
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

                if(Until.compareString(key.getName(),list.get(j-1).getName())==-1){
                    list.set(j,list.get(j-1));
                }else{
                    break;
                }
            }
            list.set(j,key);
        }
    }


}
