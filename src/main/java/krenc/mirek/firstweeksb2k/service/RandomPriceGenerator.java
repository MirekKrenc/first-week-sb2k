package krenc.mirek.firstweeksb2k.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RandomPriceGenerator implements PriceGenerator {

    //minimal price in the shop
    private static final BigDecimal MIN = BigDecimal.valueOf(50);
    private static final BigDecimal MAX = BigDecimal.valueOf(300);

    @Override
    public BigDecimal getPrice() {
        BigDecimal randomBigDecimal = MIN.add(new BigDecimal(Math.random()).multiply(MAX.subtract(MIN)));
        return randomBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
