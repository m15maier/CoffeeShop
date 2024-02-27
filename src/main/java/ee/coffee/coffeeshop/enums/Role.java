package ee.coffee.coffeeshop.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {  // enum - перечисления
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
