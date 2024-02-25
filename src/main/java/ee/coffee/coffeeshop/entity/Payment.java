package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table    // таблица
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
@AllArgsConstructor     // конструктор со всеми полями
@NoArgsConstructor      //конструктор без аргументов

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;
}
