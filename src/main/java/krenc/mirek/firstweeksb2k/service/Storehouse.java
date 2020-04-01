package krenc.mirek.firstweeksb2k.service;

import krenc.mirek.firstweeksb2k.model.Product;
import krenc.mirek.firstweeksb2k.model.ProductsNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@ConfigurationProperties(prefix = "init")
public class Storehouse {
    private PriceGenerator priceGenerator;
    private ProductsNames productsNames;
    private int prodCount;
    private int VAT;
    private int discount;

    private final int NUMBER_OF_PRODUCTS=5;
    private List<Product> productsList = new ArrayList<>();

    @Autowired
    public Storehouse(PriceGenerator priceGenerator, ProductsNames productsNames) {
        this.priceGenerator = priceGenerator;
        this.productsNames = productsNames;
        this.prodCount = productsNames.getCountOfProducts();
    }

    private String getProductsName()
    {
        double rand = Math.random();
        int index = (int)(rand*this.prodCount);
        return productsNames.getArrayOfProducts().get(index);
    }

    private void createProducts()
    {
        for(int i=0; i<NUMBER_OF_PRODUCTS; i++)
        {
            BigDecimal basePrice =  priceGenerator.getPrice();
//            System.out.println("Price=" + basePrice);
//            System.out.println("Discount=" + basePrice.multiply(BigDecimal.valueOf(discount/100.0)));
//            System.out.println("VAT=" + basePrice.multiply(BigDecimal.valueOf(VAT/100.0)));
            BigDecimal price = basePrice.subtract(basePrice.multiply(BigDecimal.valueOf(discount/100.0))).add(basePrice.multiply(BigDecimal.valueOf(VAT/100.0)));
//            System.out.println("Final price=" + price);
            Product p = new Product(i+1, getProductsName(), price.setScale(2, BigDecimal.ROUND_HALF_UP), basePrice);
            this.productsList.add(p);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ShowProducts()
    {
        if (VAT != 0 || discount != 0)
        System.out.println("VAT=" + VAT + ", Discount=" + discount);
        this.createProducts();
        System.out.println("For sell:");
        this.productsList.stream().forEach(System.out::println);
        BigDecimal sum = this.productsList.stream().map(p -> p.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Sumaryczna cena produktów = " + sum);
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
