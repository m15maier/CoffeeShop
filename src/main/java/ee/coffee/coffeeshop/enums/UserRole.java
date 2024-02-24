package ee.coffee.coffeeshop.enums;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;

import javax.management.relation.Role;

public enum UserRole implements GrantedAuthority {  // enum - перечисления
    USER,
    ADMIN;

    @Bean
    public static Role valueOf(UserRole userRole) {
        return null;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
