package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.dto.UserSignupDTO;
import ee.coffee.coffeeshop.entity.User;

import java.util.List;

public interface UserService {

    List<User> list();

    void createUser(User user) throws CoffeeShopExeption;
    
    User getById(Long id);
    
    void deleteUser(Long id);
    
    void updateUser(UserSignupDTO user) throws CoffeeShopExeption;
    
    void signUp(UserSignupDTO data) throws CoffeeShopExeption;
}
