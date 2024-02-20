package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM products WHERE product_id = :product_id")
    Product getProductsById(@Param(value = "product_id") Integer id);

    List<Product> findByTitle(String title);

}
