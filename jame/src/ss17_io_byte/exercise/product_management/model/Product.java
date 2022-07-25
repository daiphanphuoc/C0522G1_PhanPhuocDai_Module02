package ss17_io_byte.exercise.product_management.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String iDProduct;
    private String name;
    private String manufacturer;
    private double price;
    private String comment;

    public Product() {
    }

    public Product(String iDProduct, String name,
                   String manufacturer, double price, String comment) {
        this.iDProduct = iDProduct;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.comment = comment;
    }

    public String getIDProduct() {
        return iDProduct;
    }

    public void setIDProduct(String iDProduct) {
        this.iDProduct = iDProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Product{" +
                "iDProduct='" + iDProduct + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                '}';
    }
}
