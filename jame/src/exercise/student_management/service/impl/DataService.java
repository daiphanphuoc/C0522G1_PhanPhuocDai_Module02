package exercise.student_management.service.impl;

import exercise.student_management.model.Person;
import exercise.student_management.model.Student;
import exercise.student_management.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    public static List<Person> personList;
    static {
        personList=new ArrayList<>();
        personList.add(new Student("111","Huy","1999-1-1",true,"c05",8.7));
        personList.add(new Student("112","Huân","1991-1-1",true,"c05",7.5));
        personList.add(new Teacher("1111","Công","1991-1-1",true,"Tin"));
        personList.add(new Teacher("1112","Hải TT","1996-1-1",true,"Tin"));
        personList.add(new Student("113","Ân","1993-1-1",true,"c05",3.7));
        personList.add(new Student("114","Tiến","1997-1-1",true,"c05",8.7));
        personList.add(new Student("115","Anh","1996-1-1",true,"c05",4.7));
        personList.add(new Teacher("1113","Quang","1995-1-1",true,"Tin"));
        personList.add(new Teacher("1114","Chánh","1986-1-1",true,"Tin"));
        personList.add(new Teacher("1115","Trung","1976-1-1",true,"Tin"));
    }
}
