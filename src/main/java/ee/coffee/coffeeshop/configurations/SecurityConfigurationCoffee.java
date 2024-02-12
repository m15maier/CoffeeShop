package ee.coffee.coffeeshop.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfigurationCoffee {

    @Bean
    public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests((requests) -> {
                    requests.requestMatchers("/", "/product/**", "/registration", "/user/**", "/cart").permitAll();
//                    requests.requestMatchers("/admin").hasAuthority("ADMIN");
//                    requests.requestMatchers("/login/**");
                    requests.anyRequest().permitAll();
                })
                .formLogin(form -> form
                                .loginPage("/login")
                                .permitAll());
//                .formLogin(Customizer.withDefaults());
//                .formLogin(formLogin -> formLogin.disable());
//                .httpBasic(httpBasic -> httpBasic.init(http));

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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


//@Bean
//public PasswordEncoder passwordEncoder() {
//    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    System.out.println(bCryptPasswordEncoder.encode("qwerty")); // просмотр зашифрованных
//    System.out.println(bCryptPasswordEncoder.encode("admin"));
//    return bCryptPasswordEncoder;
//}