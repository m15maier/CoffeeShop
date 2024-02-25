package ee.coffee.coffeeshop.entity;

import ee.coffee.coffeeshop.enums.DeliveryMethod;
import ee.coffee.coffeeshop.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
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

