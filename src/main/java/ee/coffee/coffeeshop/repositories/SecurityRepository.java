package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.Security;
import org.springframework.data.repository.CrudRepository;

public interface SecurityRepository extends CrudRepository<Security, Integer> {
    Security findByLogin(String Login);
}
