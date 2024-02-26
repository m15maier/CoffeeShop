package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {     // название, первичный ключ

    User findByEmail(String user_email);
}
