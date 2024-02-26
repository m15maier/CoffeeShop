package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

//    @Query(nativeQuery = true, value = "SELECT * FROM users ")
//    List<User> findAutocomplete(@Param(value = "name") String name);
}
