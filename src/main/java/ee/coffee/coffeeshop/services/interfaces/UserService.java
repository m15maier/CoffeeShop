package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.User;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;

public interface UserService {


    List<User> list();

    boolean createUser(User user);

    void changeUserRoles(User user, Map<String, String> form);
}
