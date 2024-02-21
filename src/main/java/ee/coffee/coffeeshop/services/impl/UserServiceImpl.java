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

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import static ee.coffee.coffeeshop.enums.UserRole.ADMIN;


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
    public void saveSecurity(Long userId, String userEmail, String userPassword) {

        Security security = new Security();
        security.setUserId(Math.toIntExact(userId));
        security.setLogin(userEmail);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(userPassword);
        security.setPassword(encodePassword);

        security.setRole(UserRole.USER);
        securityRepository.save(security);
    }

    @Transactional
    @Override
    public User getUserById(Long user_id) {
        return null;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Transactional
    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(UserRole.values())
                .map(UserRole::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(UserRole.valueOf(ADMIN));
            }
        }
        userRepository.save(user);

    }
    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }
}