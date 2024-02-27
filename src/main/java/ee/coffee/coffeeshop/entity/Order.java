package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Table(name = "orders")
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private BigDecimal price;

//    @Column
//    private String status;
//
//    @Column
//    private String payment_type;
//
//    @Column
//    private String delivery_type;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;
}
