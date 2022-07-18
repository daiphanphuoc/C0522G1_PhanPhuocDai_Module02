package ss12_java_collection_framework.exercise.linkedlist.service.impl;

import ss12_java_collection_framework.exercise.linkedlist.model.Product;

import java.util.ArrayList;
import java.util.LinkedList;

public class ProductManager {
    static LinkedList<Product> productArrayList =new LinkedList<>();

    static {

        productArrayList.add(new Product("hh01","Kẹo Gừng", 12, 5000));
        productArrayList.add(new Product("hh02","Kẹo Bạc Hà", 112, 7000));
        productArrayList.add(new Product("hh03","Kẹo Me", 22, 6500));
        productArrayList.add(new Product("hh04","Kẹo Ổi", 82, 5000));
        productArrayList.add(new Product("hh05","Kẹo Chanh muối", 19, 6000));
    }

}
