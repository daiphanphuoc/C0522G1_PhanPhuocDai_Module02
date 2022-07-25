package ss17_io_byte.exercise.product_management.service.impl;

import org.jetbrains.annotations.NotNull;
import ss17_io_byte.exercise.product_management.libs.IOFileUtil;
import ss17_io_byte.exercise.product_management.libs.InputUtil;
import ss17_io_byte.exercise.product_management.model.Product;
import ss17_io_byte.exercise.product_management.service.IService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService<Product> {
    public static final String PATH_PRODUCT = "jame/src/ss17_io_byte/exercise/product_management/data/product.txt";

    @Override
    public void add() {
        List<Product> products = IOFileUtil.readDataFromFile(PATH_PRODUCT);
        while (true) {
            try {
                String id = InputUtil.getString("Nhập vào mã sản phẩm:");
                for (Product product : products) {
                    if (id.equals(product.getIDProduct())) {
                        throw new Exception("trùng mã");
                    }
                }
                Product product = createProduct(id);
                products.add(product);
                IOFileUtil.writeToFile(PATH_PRODUCT, products);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private @NotNull Product createProduct(String id) {
        String name = InputUtil.getString("Nhập vào tên sản phẩm:");
        String manufacturer = InputUtil.getString("Nhập vào tên hãng sản xuất:");
        double price = InputUtil.getDouble("Nhập vào đơn giá:");
        String comment = InputUtil.getString("Nhập vào các mô tả về sản phẩm:");
        return new Product(id, name, manufacturer, price, comment);
    }

    @Override
    public void display() {
        List<Product> products = IOFileUtil.readDataFromFile(PATH_PRODUCT);
        for (Product product:products){
            System.out.println(product);
        }

    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = IOFileUtil.readDataFromFile(PATH_PRODUCT);
        List<Product> productList=new ArrayList<>();
        for (Product product:products){
            if (product.getName().contains(name)){
                productList.add(product);

            }
        }
        return productList;
    }
}
