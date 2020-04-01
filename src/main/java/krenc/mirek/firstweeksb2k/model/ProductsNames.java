package krenc.mirek.firstweeksb2k.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductsNames {

    private List<String> arrayOfProducts = Arrays.asList(
            "T-shirt męski Adidos",
            "Koszulka damska NIQE",
            "Telewizor 20\"",
            "Laptop Lestaro",
            "Komputer gamingowy BELL",
            "Mysz bezprzewodowa HPE",
            "Mini PC Fjujitsu",
            "Buty sportowe męskie - Adidos",
            "Skarpety ze złotą wszywką",
            "Zegarek męski - srebrny",
            "Odtwarzacz Blueray - Minto"
    );

    public ProductsNames() {
        this.arrayOfProducts = arrayOfProducts;
    }

    public List<String> getArrayOfProducts() {
        return arrayOfProducts;
    }

    public void setArrayOfProducts(List<String> arrayOfProducts) {
        this.arrayOfProducts = arrayOfProducts;
    }

    public int getCountOfProducts()
    {
        return arrayOfProducts.size();
    }
}
