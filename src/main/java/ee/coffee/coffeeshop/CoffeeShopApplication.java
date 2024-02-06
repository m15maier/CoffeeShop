package ee.coffee.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@Repository
//@ComponentScan("ee.coffee.*")
//@EnableJpaRepositories("ee.coffee.*")
//@EntityScan(basePackages = {"ee.coffee.*"})
@SpringBootApplication

public class CoffeeShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopApplication.class, args);
    }

}
