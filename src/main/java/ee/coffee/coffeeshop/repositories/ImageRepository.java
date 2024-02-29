package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.Image;
import ee.coffee.coffeeshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
