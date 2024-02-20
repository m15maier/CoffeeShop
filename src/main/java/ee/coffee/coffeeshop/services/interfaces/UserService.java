package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {


    @Transactional
    User saveUser(String name, String email, String address, String phone);

    @Transactional
    void saveSecurity(Long userId, String userEmail, String userPassword);

    @Transactional
    User getUserById(Long id);

    @Transactional
    List<User> getAllUsers();


//    boolean addUser(User user);
}
