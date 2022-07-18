package ss12_java_collection_framework.exercise.arraylist.model;

import org.jetbrains.annotations.NotNull;

public class Product implements Comparable<Product>{
    private String productCode;
    private String productName;
    private int quantity;
    private  double unitPrice;

    public Product() {
    }

    public Product(String productCode, String productName, int quantity, double unitPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(@NotNull Product o) {
        return getUnitPrice()>o.getUnitPrice()?1:-1;
    }

    /*@Override
    public boolean equals(Product obj) {
        return getProductCode().equals(obj.getProductCode());
    }
    */

}
