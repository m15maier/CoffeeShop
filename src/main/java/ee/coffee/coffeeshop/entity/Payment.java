package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table    // таблица
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;
}
