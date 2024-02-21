package ee.coffee.coffeeshop.enums;

import org.springframework.security.core.GrantedAuthority;

import javax.management.relation.Role;

public enum UserRole implements GrantedAuthority {
    USER,
    ADMIN;

    public static Role valueOf(UserRole userRole) {
        return null;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
