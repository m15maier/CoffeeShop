package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("No such email");
        }
        return new UserDetails() {
            @Override public Collection<? extends GrantedAuthority> getAuthorities() {
                if(user.getRole() == null) {
                    return Collections.EMPTY_LIST;
                }
                return Collections.singletonList(user.getRole());
            }
            
            @Override public String getPassword() {
                return user.getPassword();
            }
            
            @Override public String getUsername() {
                return user.getEmail();
            }
            
            @Override public boolean isAccountNonExpired() {
                return true;
            }
            
            @Override public boolean isAccountNonLocked() {
                return true;
            }
            
            @Override public boolean isCredentialsNonExpired() {
                return true;
            }
            
            @Override public boolean isEnabled() {
                return user.isActive();
            }
        };
    }
}
