package ee.coffee.coffeeshop.configurations;

import ee.coffee.coffeeshop.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfiguration {

    private final CustomUserDetailsService userDetailsService;


@Bean
public DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception {
    http
             .authorizeHttpRequests((requests) -> requests
             .requestMatchers("/", "/product/**", "/registration", "/login").permitAll()
             .anyRequest().authenticated()
             )
              .formLogin((form) -> form
              .loginPage("/login")
              .permitAll()
              )
              .logout((logout) -> logout.permitAll());

      return http.build();
  }

 @Bean
 public UserDetailsService configure() {
    UserDetails user =
             User.withDefaultPasswordEncoder()
                      .username("user")
                      .password("password")
                      .roles("USER")
                      .build();

      return new InMemoryUserDetailsManager(user);
  }



  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(8);
  }
}