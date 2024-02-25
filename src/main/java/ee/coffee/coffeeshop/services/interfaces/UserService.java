package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {


    List<User> list();

    void createUser(User user) throws CreateUserExeption;

    void changeUserRoles(User user, Map<String, String> form);
}
