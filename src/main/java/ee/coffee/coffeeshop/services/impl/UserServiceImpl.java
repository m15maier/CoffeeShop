package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Security;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.enums.UserRole;
import ee.coffee.coffeeshop.repositories.SecurityRepository;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SecurityRepository securityRepository;

    @Transactional
    @Override
    public User saveUser(String name, String email, String address, String phone) {

        User user = new User();
        user.setUser_name(name);
        user.setUser_email(email);
        user.setUser_address(address);
        user.setUser_phone(phone);
        userRepository.save(user);

        return user;
    }

    @Transactional
    @Override
        public void saveSecurity(Integer userId, String userEmail, String userPassword) {

        Security security = new Security();
        security.setUserId(userId);
        security.setLogin(userEmail);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(userPassword);
        security.setPassword(encodePassword);

        security.setRole(UserRole.USER);
        securityRepository.save(security);

    }

    @Transactional
    @Override
    public User getUserById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);

    }

    @Transactional
    @Override
        public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    }
