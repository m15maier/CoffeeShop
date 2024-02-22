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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_email", unique = true)
    private String user_email;

    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_address")
    private String user_address;

    @Column(name = "user_payment")
    private int payment;

    @Column(name = "count_of_payment")
    private int count_of_payment;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_active")
    private boolean user_active;

    @Column(name = "user_role")
    private String user_role;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
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
    public String getUsername() { return user_email; }

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
        return user_active;
    }
}