package ss10_dsa_list.exercise._arraylist.controller;

import ss10_dsa_list.exercise._arraylist.service.MyListTest;

import java.util.Scanner;

public class MyListController {
    Scanner  sc =new Scanner(System.in);
    MyListTest myListTest=new MyListTest();
    public void displayMainMenu(){
        int choose;
        while (true){

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
                choose=Integer.parseInt(sc.nextLine());
                 isChoose=choose<0||choose>5;
                if(isChoose){
                    System.out.println("không có lựa chọn, nhập lại:");
                }
            }while (isChoose);


            switch (choose){
                case 1:
                    myListTest.addPerson();
                    break;
                case 2:
                     index= myListTest.inputIndex("mời bạn nhập vào vị trí cần thêm:");
                    myListTest.addPerson(index);
                    break;
                case 3:
                     index= myListTest.inputIndex("mời bạn nhập vào vị trí cần xóa:");
                     myListTest.deletePerson(index);
                    break;
                case 4:break;
                case 5:break;
                case 6:System.exit(0);
            }
        }

    }
}
