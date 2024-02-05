package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.models.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@EntityScan("ee.coffee.*")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
