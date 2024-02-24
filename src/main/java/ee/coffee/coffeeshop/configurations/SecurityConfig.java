package ee.coffee.coffeeshop.configurations;

import ee.coffee.coffeeshop.entity.Security;
import ee.coffee.coffeeshop.repositories.SecurityRepository;
import ee.coffee.coffeeshop.services.impl.CustomUserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity  // указывает на то, что класс является конфигурацией безопасности для веб-приложения
@Configuration      // указывает на то, что класс является конфигурационным классом
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor     // конструктор со всеми полями
public class SecurityConfig  {

    private DataSource dataSource;
    private final CustomUserDetailsServiceImpl userDetailsServiceImpl;

    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("products");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/product-create").setViewName("product-create");
        registry.addViewController("/admin").setViewName("admin");
    }


//     метод для настройки безопасности приложения
    @Bean   // указывает на то, что метод возвращает экземпляр объекта, который будет управлять фильтрами безопасности
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf(AbstractHttpConfigurer::disable)   // отключение банковской защиты от CSRF атак
//                .cors(AbstractHttpConfigurer::disable)   // отключение защиты от межсайтовых атак
                .authorizeHttpRequests((requests) -> {      // настройка правил доступа для различных URL-адресов

//                  requests.requestMatchers("/admin/****").hasRole("ADMIN");
                    requests.requestMatchers("/", "/login", "/registration/**", "/user/**").permitAll();
                  requests.anyRequest().permitAll();
//                  requests.anyRequest().authenticated();
                })

//                .formLogin(AbstractHttpConfigurer::disable);    // отключение формы входа
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                );
                http.httpBasic(httpBasic -> httpBasic.init(http));

        return http.build();

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




//         метод для аутентификации и авторизации пользователей
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails =
                User.builder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(userDetails);
    }


}
