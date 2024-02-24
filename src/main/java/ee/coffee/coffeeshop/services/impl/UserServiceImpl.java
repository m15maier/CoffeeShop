package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.enums.UserRole;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public boolean createUser(User user) {
        User userFromDb = userRepository.findByEmail(user.getUsername());

        if (userFromDb != null) {   // если такой юзер есть в базе, то выдаит ошибку
             return false;
        }

        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(UserRole.USER);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
    }


    @Override
    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(UserRole.values())
                .map(UserRole::name)
                .collect(Collectors.toSet());
        user.getRoles().add(UserRole.USER);
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(UserRole.valueOf(key));
            }
        }
        userRepository.save(user);

    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

}
