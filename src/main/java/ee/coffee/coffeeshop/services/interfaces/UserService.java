package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {


    @Transactional
    User saveUser(String name, String email, String address, String phone);

    @Transactional
    void saveSecurity(Integer userId, String userEmail, String userPassword);

    @Transactional
    User getUserById(Integer user_id);


    @Transactional
    List<User> getAllUsers();

//    boolean addUser(User user);
}
