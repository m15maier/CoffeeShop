package ee.coffee.coffeeshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "order_products_list")    // таблица
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JsonIgnore
    private Order order;
}
