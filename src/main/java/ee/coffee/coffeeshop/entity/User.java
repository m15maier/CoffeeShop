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

    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_username")
    private String username;

    @Column(name = "user_address")
    private String address;

    @Column(name = "user_payment")
    private int payment;

    @Column(name = "user_amount")
    private int amount;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_active")
    private boolean active;

    @Column(name = "user_role")
    private String role;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)   // fetch - загружает из таблицы, eager - только когда пользователь обратиться к таблице
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))   // аннотация описывает, что данное поле будет храниться в отдельной таблице, для которой не описывали метод
    @Enumerated(EnumType.STRING)    // хотим хранить в виде строки
    private Set<UserRole> roles = new HashSet<>();



    // security

    public boolean isAdmin() {
        return roles.contains(UserRole.ADMIN);
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