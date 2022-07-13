package ss10_dsa_list.exercise._arraylist.controller;

import ss10_dsa_list.exercise._arraylist.model.Person;
import ss10_dsa_list.exercise._arraylist.service.MyListService;

import java.util.Scanner;

public class MyListController {
    Scanner sc = new Scanner(System.in);
    MyListService myListService = new MyListService();

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
                    myListService.display();

                    myListService.addPerson();

                    System.out.println("danh sách sau khi thêm:");
                    myListService.display();
                    break;

                case 2:
                    System.out.println("danh sách trước khi thêm:");
                    myListService.display();

                    index = myListService.inputIndex("mời bạn nhập vào vị trí cần thêm:");
                    myListService.addPerson(index);

                    System.out.println("danh sách sau khi thêm:");
                    myListService.display();
                    break;

                case 3:

                    System.out.println("danh sách trước khi xóa:");
                    myListService.display();

                    index = myListService.inputIndex("mời bạn nhập vào vị trí cần xóa:");
                    myListService.deletePerson(index);

                    System.out.println("danh sách sau khi xóa:");
                    myListService.display();
                    break;


                case 4:
                    myListService.survive(myListService.createPerson());
                    break;


                case 5:
                    index = myListService.inputIndex("mời bạn nhập vào vị trí cần lấy ra:");
                    Person person= myListService.getPerson(index);
                    System.out.println(person);
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }
}
