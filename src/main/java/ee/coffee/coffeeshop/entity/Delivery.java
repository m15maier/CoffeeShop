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
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column
        private Long id;

        @Column
        private DeliveryStatus deliveryStatus;

        @Column
        private DeliveryMethod deliveryMethod;

        @ManyToOne
        private Order order;

        public User getUser() {
        return order.getUser();
        }
}

