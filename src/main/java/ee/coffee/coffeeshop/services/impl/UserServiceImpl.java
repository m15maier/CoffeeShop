package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.dto.UserDTO;
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user) throws CoffeeShopExeption
    {
        checkNotEmpty(user.getEmail(), "email");
        checkNotEmpty(user.getUsername(), "name");
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
    
    private void checkNotEmpty(String value, String name) throws CoffeeShopExeption
    {
        if(!StringUtils.hasText(value)) {
            throw new CoffeeShopExeption("Empty value not allowed for '" + name + "'");
        }
    }
    
    @Override
    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.setRole(Role.ADMIN);
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.setRole(Role.ADMIN);
            }
        }
        userRepository.save(user);
    }
    
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    @Override public void updateUser(UserDTO dto) throws CoffeeShopExeption
    {
        User user = userRepository.findById(dto.getId()).orElseThrow(
            () -> new CoffeeShopExeption("User not found, id=" + dto.getId()));
        BeanUtils.copyProperties(dto, user);
        userRepository.save(user);
    }
    
    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

}
