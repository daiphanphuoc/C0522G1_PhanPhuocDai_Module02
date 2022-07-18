package ss12_java_collection_framework.exercise.arraylist.service.impl;

import ss12_java_collection_framework.exercise.arraylist.model.Product;
import ss12_java_collection_framework.exercise.arraylist.service.IService;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManagerService implements IService<Product> {
    Scanner sc = new Scanner(System.in);

    public Product createProduct() {
        System.out.println("Mòi nhập vào mã hàng hóa");
        String id = sc.nextLine();

        System.out.println("Mời nhập vào tên sản phẩm:");
        String name = sc.nextLine();

        System.out.println("Mời nhập vào số lượng sản phẩm:");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.println("Mời nhập vào giá sản phẩm:");
        double unit = Double.parseDouble(sc.nextLine());

        return new Product(id, name, quantity, unit);
    }

    @Override
    public void add() {
        ProductManager.productArrayList.add(createProduct());
    }

    @Override
    public void display() {
        for (Product product : ProductManager.productArrayList) {
            System.out.println(product);
        }
    }

    @Override
    public void remove(String id) {
        for(Product product:ProductManager.productArrayList){
            if(id.equals(product.getProductCode())){
                System.out.println("Bạn chắc chắn muốn xóa:1.Yes. ");
                int isRemove = Integer.parseInt(sc.nextLine());

                if(isRemove==1){
                    ProductManager.productArrayList.remove(product);
                    System.out.println("xóa thành công");
                    return;
                }
                return;
            }

        }
        System.out.println("Không tìm thấy.");
    }

    @Override
    public void update(String id) {
        int i=0;
        for(Product product:ProductManager.productArrayList){
            if(id.equals(product.getProductCode())){
                System.out.println("Bạn chắc chắn muốn sửa:1.Yes. ");
                int isUpdate = Integer.parseInt(sc.nextLine());

                if(isUpdate==1){

                    ProductManager.productArrayList.set(i,createProduct());
                    System.out.println("sửa thành công");
                    return;
                }
                return;
            }
            i++;
        }
        System.out.println("Không tìm thấy.");
    }

    @Override
    public ArrayList<Product> find(String name) {
        ArrayList<Product> products = new ArrayList<>();

        for (Product product : ProductManager.productArrayList) {
            if (name.equals(product.getProductName())) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public void sort() {
        ProductManager.productArrayList.sort(Comparator.naturalOrder());
    }

    @Override
    public void reverse() {
        ProductManager.productArrayList.sort(Comparator.reverseOrder());
    }
}
