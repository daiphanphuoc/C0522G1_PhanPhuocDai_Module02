package ss10_dsa_list.exercise._arraylist.service.impl;

import ss10_dsa_list.exercise._arraylist.model.Person;
import ss10_dsa_list.exercise._arraylist.service.IPersonService;

import java.util.Scanner;

public class PersonService implements IPersonService {
    Scanner sc = new Scanner(System.in);
    public static MyList<Person> people;

    static {
        people = new MyList<Person>();
        people.add(new Person("Đạt", "200234789", "2-02-1993", true, "0902345678", "dat9993@gmail.com"));
        people.add(new Person("Huân", "200456789", "20-02-2000", true, "0902323478", "huan43@gmail.com"));
        people.add(new Person("Ân", "200456234", "20-02-2000", true, "0902323478", "an99@gmail.com"));
    }

    public void display(){
        for (int i=0;i<people.size();i++){
            System.out.println(people.elementData[i]);
        }
    }

    public Person createPerson(){
        System.out.println("Nhập vào tên");
        String name = sc.nextLine();

        System.out.println("Nhập vào mã số công dân:");
        String iDCitizen = sc.nextLine();

        System.out.println("Nhập vào ngày sinh:");
        String birthday = sc.nextLine();

        System.out.println("Nhập vào giới tính:");
        boolean sex = Boolean.parseBoolean(sc.nextLine());

        System.out.println("Nhập vào số điện thoại:");
        String phone = sc.nextLine();

        System.out.println("Nhập vào email:");
        String email = sc.nextLine();

        return new Person(name,iDCitizen,birthday,sex,phone,email);

    }

    public void addPerson() {
        people.add(createPerson());
    }

    public int inputIndex(String str){
        System.out.println(str);
        return sc.nextInt();
    }

    public void addPerson(int index) {
        people.add(index,createPerson());
    }

    public void deletePerson(int index){
        people.remove(index);
    }

    public void survive(Person person){
        if(people.contains(person)){
            System.out.println("tồn tại trong danh sách");
        }else{
            System.out.println("không tồn tại trong danh sách");
        }
    }

    public Person getPerson(int index){
        return people.get(index);
    }
}
