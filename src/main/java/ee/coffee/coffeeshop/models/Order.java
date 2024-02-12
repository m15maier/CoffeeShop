package ee.coffee.coffeeshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Table(name = "orders")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "order_price", nullable = false)
    private Integer order_price;


    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private Collection<Cart> carts;


}
