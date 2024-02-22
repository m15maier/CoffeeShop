package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(nativeQuery = true, value = "SELECT * FROM users")
//    List<User> getAllUsers();

    @Query(nativeQuery = true, value = "SELECT * FROM users")
    User findByEmail(String user_email);
}
