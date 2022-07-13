package ss10_dsa_list.exercise._arraylist.controller;

import ss10_dsa_list.exercise._arraylist.model.Person;
import ss10_dsa_list.exercise._arraylist.service.MyListTest;

import java.util.Scanner;

public class MyListController {
    Scanner sc = new Scanner(System.in);
    MyListTest myListTest = new MyListTest();

    public void displayMainMenu() {
        int choose;
        while (true) {

            System.out.println("-----------------Menu-----------------");
            System.out.println("1. thêm vào 1 phần tử vào cuối:");
            System.out.println("2. thêm vào 1 phần tử vào vị trí:");
            System.out.println("3.xóa phần tử tại vị trí:");
            System.out.println("4.kiểm tra phần tử tồn  tại trong danh sách:");
            System.out.println("5.lấy giá trị 1 phần tử trong danh sách tại vị trí:");
            System.out.println("6.exit");
            System.out.println("Mời bạn nhập vào lựa chọn: ");
            boolean isChoose;
            int index;
            do {
                choose = Integer.parseInt(sc.nextLine());
                isChoose = choose < 0 || choose > 6;
                if (isChoose) {
                    System.out.println("không có lựa chọn, nhập lại:");
                }
            } while (isChoose);


            switch (choose) {

                case 1:
                    System.out.println("danh sách trước khi thêm:");
                    myListTest.display();

                    myListTest.addPerson();

                    System.out.println("danh sách sau khi thêm:");
                    myListTest.display();
                    break;

                case 2:
                    System.out.println("danh sách trước khi thêm:");
                    myListTest.display();

                    index = myListTest.inputIndex("mời bạn nhập vào vị trí cần thêm:");
                    myListTest.addPerson(index);

                    System.out.println("danh sách sau khi thêm:");
                    myListTest.display();
                    break;

                case 3:

                    System.out.println("danh sách trước khi xóa:");
                    myListTest.display();

                    index = myListTest.inputIndex("mời bạn nhập vào vị trí cần xóa:");
                    myListTest.deletePerson(index);

                    System.out.println("danh sách sau khi xóa:");
                    myListTest.display();
                    break;


                case 4:
                    myListTest.survive(myListTest.createPerson());
                    break;


                case 5:
                    index = myListTest.inputIndex("mời bạn nhập vào vị trí cần lấy ra:");
                    Person person=myListTest.getPerson(index);
                    System.out.println(person);
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }
}
