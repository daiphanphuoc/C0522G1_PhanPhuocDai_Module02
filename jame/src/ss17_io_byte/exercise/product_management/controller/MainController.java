package ss17_io_byte.exercise.product_management.controller;

import ss17_io_byte.exercise.product_management.libs.InputUtil;
import ss17_io_byte.exercise.product_management.model.Product;
import ss17_io_byte.exercise.product_management.service.impl.ProductService;

import java.util.List;

public class MainController {
    public void  mainMenu(){
        ProductService productService=new ProductService();

        while (true){
            System.out.println("=====Product Management=====");
            System.out.println("1.\tAdd product.");
            System.out.println("2.\tDisplay product.");
            System.out.println("3.\tSearch product.");
            System.out.println("4.\tExit.");

            int choose= InputUtil.getInt("Enter choose");
            switch (choose){
                case 1:{
                    productService.add();
                    break;
                }
                case 2:{
                    productService.display();
                    break;
                }
                case 3:{
                    String string=InputUtil.getString("Nhập vào tên sản phẩm cần tìm :");
                    List<Product> productList=productService.search(string);
                    for (Product product:productList){
                        System.out.println(product);
                    }
                    break;
                }
                case 4:{
                    System.exit(0);
                }
                default:
                    System.err.println("Không có lựa chọn này!!!");
            }



        }
    }
}
