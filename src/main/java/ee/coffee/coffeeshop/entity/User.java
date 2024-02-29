package ee.coffee.coffeeshop.entity;

import ee.coffee.coffeeshop.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "users")
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
public class User {
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
    @Enumerated(EnumType.STRING) // использовать в базе название енума, не индекс
    private Role role;

    // security

    public boolean isAdmin() {
        return role == Role.ROLE_ADMIN;
    }

}
