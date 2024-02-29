package ee.coffee.coffeeshop.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {  // enum - перечисления
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        // для спринг секурити важно, чтобы роли были с префиксом 'ROLE_'
        return name();
    }
}
