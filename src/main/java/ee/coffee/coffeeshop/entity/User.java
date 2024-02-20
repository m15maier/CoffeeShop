package ee.coffee.coffeeshop.entity;

import ch.qos.logback.core.status.StatusManager;
import ee.coffee.coffeeshop.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users")      // таблица
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
@AllArgsConstructor     // конструктор со всеми полями
@NoArgsConstructor      //конструктор без аргументов
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_email", unique = true, nullable = false)
    private String user_email;

    @Column(name = "user_phone", length = 8, nullable = false)
    private String user_phone;

    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "user_address", nullable = false)
    private String user_address;

    @Column(name = "user_payment")
    private int payment;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

}