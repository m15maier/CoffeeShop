package ee.coffee.coffeeshop.configurations;

import ee.coffee.coffeeshop.services.impl.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig  {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//     метод для настройки безопасности приложения
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)   // отключение банковской защиты от CSRF атак
                .cors(AbstractHttpConfigurer::disable)   // отключение защиты от межсайтовых атак
                .authorizeHttpRequests((request) -> {      // настройка правил доступа для различных URL-адресов
                    request.requestMatchers("/admin/**").hasRole("ADMIN");
                    request.requestMatchers("/user/**").hasAnyRole("ADMIN", "USER");
                    request.requestMatchers("/", "/error", "/login", "/logout", "/registration", "/images/**", "/public/**").permitAll();
//                      request.requestMatchers("/**").permitAll();
                })
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                );
                http.httpBasic(httpBasic -> httpBasic.init(http));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }
}
