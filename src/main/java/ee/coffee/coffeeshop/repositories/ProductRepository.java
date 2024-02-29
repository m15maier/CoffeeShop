package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitle(String product_title);

}
