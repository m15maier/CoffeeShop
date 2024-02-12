package ee.coffee.coffeeshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Table(name = "delivery")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "delivery_id")
        private Integer delivery_id;

        @Column(name = "delivery_status")
        private String delivery_status;

        @Enumerated(EnumType.STRING)

        @ManyToOne
        private Order order;

        @ManyToOne
        private User user;
    }

