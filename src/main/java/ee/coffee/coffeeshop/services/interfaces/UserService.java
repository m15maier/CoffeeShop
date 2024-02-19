package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    User saveUser(String name, String email, String password, String address);

    @Transactional
    void saveSecurity(Integer userId, String userEmail, String UserPassword);

    User getUserById(Integer id);

    List<User> getAllUsers();
    List<User> getUserByStatus(String status);

    boolean createUser(User user);

//    void saveUser(String name, String email, String password, String address, String phone);

}
