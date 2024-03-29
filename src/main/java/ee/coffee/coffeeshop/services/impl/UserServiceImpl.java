package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.dto.UserSignupDTO;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.enums.Role;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.CoffeeShopExeption;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user) throws CoffeeShopExeption {
        checkNotEmpty(user.getEmail(), "email");
        checkNotEmpty(user.getName(), "name");
        checkNotEmpty(user.getPassword(), "password");
        
        User userFromDb = userRepository.findByEmail(user.getEmail());   // валидация, что такой юзер с таком мейлом не зарегистрирован
        if (userFromDb != null) {   // если такой юзер есть в базе, то выдаит ошибку
             throw new CoffeeShopExeption("Email already registered");
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        log.info("Saving new User with email: {}", user.getEmail());
        userRepository.save(user);
    }
    
    private void checkNotEmpty(String value, String name) throws CoffeeShopExeption {
        if(!StringUtils.hasText(value)) {
            throw new CoffeeShopExeption("Empty value not allowed for '" + name + "'");
        }
    }
    
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    @Override
    public void updateUser(UserSignupDTO dto) throws CoffeeShopExeption {
//        User user = userRepository.findById(dto.getId()).orElseThrow(
//            () -> new CoffeeShopExeption("User not found, id=" + dto.getId()));
//        BeanUtils.copyProperties(dto, user);
//        userRepository.save(user);
    }
    
    @Override
    public void signUp(UserSignupDTO data) throws CoffeeShopExeption {
        if(!data.getPassword().equals(data.getPasswordConfirm())) {
            throw new CoffeeShopExeption("Passwords doesnt match");
        }
        User userFromDb = userRepository.findByEmail(data.getEmail());   // валидация, что такой юзер с таком мейлом не зарегистрирован
        if (userFromDb != null) {   // если такой юзер есть в базе, то выдаит ошибку
            throw new CoffeeShopExeption("Email already registered");
        }
        User user = new User();
        BeanUtils.copyProperties(data, user);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        user.setActive(true);
        userRepository.save(user);
    }
    
    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}
