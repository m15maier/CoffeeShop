package ee.coffee.coffeeshop.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity  // указывает на то, что класс является конфигурацией безопасности для веб-приложения
@Configuration      // указывает на то, что класс является конфигурационным классом
public class WebSecurityConfiguration {


            //     метод для настройки безопасности приложения
    @Bean   // указывает на то, что метод возвращает экземпляр объекта, который будет управлять фильтрами безопасности
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)   // отключение банковской защиты от CSRF атак
                .cors(AbstractHttpConfigurer::disable)   // отключение защиты от межсайтовых атак
                .authorizeHttpRequests((requests) -> {      // настройка правил доступа для различных URL-адресов
                    requests.requestMatchers("/admin/****").hasRole("ADMIN");
                    requests.requestMatchers("/***").permitAll();
                    requests.anyRequest().permitAll();
                })
                .formLogin(AbstractHttpConfigurer::disable);    // отключение формы входа
        http.httpBasic(httpBasic -> httpBasic.init(http));

        return http.build();

    }

    // метод для аутентификации и авторизации пользователей
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails =
        User.builder()
                .username("Admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);

}



//    @Bean
//    public UserDetailsService userDetailsService(SecurityRepository securityRepository) {
//        UserDetailsService userDetailsService;
//        userDetailsService = (user_email) -> {
//
//            Security security = securityRepository.findByLogin(user_email); // поиск пользователя по мейлу
//            if (security != null) {    // если найден, то позвращается
//                return security;
//            } else {
//                throw new UsernameNotFoundException("User not found");  // если нет, то выбрасывает исключение
//            }
//        };
//        return userDetailsService;
//    }



//     метод для шифрования паролей
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        System.out.println(bCryptPasswordEncoder.encode("qwerty")); // просмотр зашифрованных
//        System.out.println(bCryptPasswordEncoder.encode("admin"));
//        return bCryptPasswordEncoder;
//    }
}