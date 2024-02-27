package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartProduct> cartProducts;
}


