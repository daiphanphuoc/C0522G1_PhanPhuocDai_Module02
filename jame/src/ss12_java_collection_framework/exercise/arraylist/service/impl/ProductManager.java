package ss12_java_collection_framework.exercise.arraylist.service.impl;

import ss12_java_collection_framework.exercise.arraylist.model.Product;

import java.util.ArrayList;

public class ProductManager {
    static ArrayList<Product> productArrayList =new ArrayList<>();

    static {

        productArrayList.add(new Product("hh01","Kẹo Gừng", 12, 6000));
        productArrayList.add(new Product("hh02","Kẹo Bạc Hà", 112, 5000));
        productArrayList.add(new Product("hh03","Kẹo Me", 22, 7000));
        productArrayList.add(new Product("hh04","Kẹo Ổi", 82, 5000));
        productArrayList.add(new Product("hh05","Kẹo Chanh muối", 19, 6000));
    }

}
