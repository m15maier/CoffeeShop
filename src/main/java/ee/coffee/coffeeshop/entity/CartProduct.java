package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;
}
