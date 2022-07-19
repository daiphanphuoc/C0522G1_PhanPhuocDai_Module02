package exercise.student_management.service.impl;

import exercise.student_management.model.Person;
import exercise.student_management.service.IPersonService;
import exercise.student_management.service.IService;

import java.util.ArrayList;
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
    public Object find(String id) {
        return null;
    }

    @Override
    public ArrayList search(String name) {
        return null;
    }
}
