package ee.coffee.coffeeshop.enums;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {  // enum - перечисления
    ROLE_USER,
    ROLE_ADMIN;

    @Bean
    public static Role valueOf(Role role) {
        return null;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
