package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.dto.UserDTO;
import ee.coffee.coffeeshop.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> list();

    void createUser(User user) throws CoffeeShopExeption;
    
    User getById(Long id);
    
    void deleteUser(Long id);
    
    void updateUser(UserDTO user) throws CoffeeShopExeption;
}
