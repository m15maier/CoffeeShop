package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharePaymentRepository extends JpaRepository<User, Long> {
    List<User> getUsersByNameStartingWithIgnoreCase(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE user_name LIKE :name% ") // SQL
    List<User> findAutocomplete(@Param(value = "name") String name);
}
