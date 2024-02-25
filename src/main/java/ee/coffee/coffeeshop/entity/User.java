package ee.coffee.coffeeshop.entity;

import ee.coffee.coffeeshop.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users")      // таблица
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
@AllArgsConstructor     // конструктор со всеми полями
@NoArgsConstructor      //конструктор без аргументов
public class User implements UserDetails {
    @Id     // первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
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
    private UserRole role;

    // security

    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() { return email; }

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

    public void setActive(boolean b) {
    }
}