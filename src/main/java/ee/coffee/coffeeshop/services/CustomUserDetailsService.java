package ee.coffee.coffeeshop.services;


import ee.coffee.coffeeshop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email)  {
        Optional<UserDetails> optional = userRepository.findByEmail(email);

        return optional.orElse(null);
    }
}
