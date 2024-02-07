package ee.coffee.coffeeshop.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
//@RequiredArgsConstructor
public class SecurityConfigurationCoffee {

@Bean
public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((requests) -> {
                requests.requestMatchers(HttpMethod.GET, "/products/create/**", "/products/delete/**").hasRole("ADMIN");
                requests.anyRequest().permitAll();
            })
            .formLogin(AbstractHttpConfigurer::disable)
            .httpBasic(httpBasic -> httpBasic.init(http));
    return http.build();
}

@Bean
public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.builder().username("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();
    return new InMemoryUserDetailsManager(user);
}

//@Bean
//public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder(8);
//}




@Bean
public PasswordEncoder passwordEncoder() {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    System.out.println(bCryptPasswordEncoder.encode("qwerty")); // просмотр зашифрованных
    System.out.println(bCryptPasswordEncoder.encode("admin"));
    return bCryptPasswordEncoder;
}
}