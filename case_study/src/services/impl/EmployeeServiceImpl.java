package services.impl;

import models.Employee;
import services.EmployeeService;

import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {
    public static ArrayList<Employee> employees;
    public static final String PATH_EMPLOYEE="case_study/src/data/employee.csv";


    @Override
    public void add() {

    }

    @Override
    public void display() {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public int find(String id) {
        return 0;
    }

    @Override
    public ArrayList search(String name) {
        return null;
    }
}
