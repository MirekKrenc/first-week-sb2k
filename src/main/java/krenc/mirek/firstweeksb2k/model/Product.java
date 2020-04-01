package krenc.mirek.firstweeksb2k.model;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String productName;
    private BigDecimal price;
    private BigDecimal basePrice;

    public Product(int id, String productName, BigDecimal price, BigDecimal basePrice) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.basePrice = basePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price + "PLN" +
                ", basePrice=" + basePrice + "PLN" +
                '}';
    }
}
