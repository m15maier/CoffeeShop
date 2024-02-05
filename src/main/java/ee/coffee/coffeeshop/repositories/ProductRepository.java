package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.models.Product;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EntityScan("ee.coffee.*")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
