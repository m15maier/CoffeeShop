package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "delivery")       // таблица
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
@AllArgsConstructor     // конструктор со всеми полями
@NoArgsConstructor      //конструктор без аргументов
public class Delivery {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "delivery_id")
        private Long delivery_id;

        @Column(name = "delivery_status")
        private String delivery_status;

        @ManyToOne
        private Order order;

        @ManyToOne
        private User user;
    }

