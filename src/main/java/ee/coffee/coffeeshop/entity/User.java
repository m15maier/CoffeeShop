package ee.coffee.coffeeshop.entity;

import ee.coffee.coffeeshop.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
@Table(name = "users")
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa

public class User implements UserDetails {
    @Id     // первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String phone;

    @Column
    private String username;

    @Column
    private String address;

    @Column
    private int payment;

    @Column
    private int amount;

    @Column
    private String password;

    @Column
    private boolean active;

    @Column
    private Role role;

    // security

    public boolean isAdmin() {
        return role == Role.ROLE_ADMIN;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(role == null) {
            return Collections.EMPTY_LIST;
        }
        List<Role> roles = new ArrayList<>(1);
        roles.add(role);
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}