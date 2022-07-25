package ss17_io_byte.exercise.product_management.libs;

import ss17_io_byte.exercise.product_management.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileUtil {

    public static void writeToFile(String path, List<Product> products) {
        try {
            //File file=new File(path);
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }

}
