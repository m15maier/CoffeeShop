package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.enums.Role;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.CreateUserExeption;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public void createUser(User user) throws CreateUserExeption {
        checkNotEmpty(user.getEmail(), "email");
        checkNotEmpty(user.getUsername(), "name");
        checkNotEmpty(user.getPassword(), "password");
        
        User userFromDb = userRepository.findByEmail(user.getEmail());   // валидация, что такой юзер с таком мейлом не зарегистрирован
        if (userFromDb != null) {   // если такой юзер есть в базе, то выдаит ошибку
             throw new CreateUserExeption("Email already registered");
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_ADMIN);
        log.info("Saving new User with email: {}", user.getEmail());
        userRepository.save(user);
    }
    
    private void checkNotEmpty(String value, String name) throws CreateUserExeption {
        if(!StringUtils.hasText(value)) {
            throw new CreateUserExeption("Empty value not allowed for '" + name + "'");
        }
    }
    
    
    @Override
    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.setRole(Role.ROLE_ADMIN);
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.setRole(Role.ROLE_ADMIN);
            }
        }
        userRepository.save(user);

    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

}
