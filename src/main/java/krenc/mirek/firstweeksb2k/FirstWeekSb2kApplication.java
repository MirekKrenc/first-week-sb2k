package krenc.mirek.firstweeksb2k;

import krenc.mirek.firstweeksb2k.service.PriceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class FirstWeekSb2kApplication {

    @Autowired
    private PriceGenerator priceGenerator;

    public static void main(String[] args) {
        SpringApplication.run(FirstWeekSb2kApplication.class, args);
    }

}
