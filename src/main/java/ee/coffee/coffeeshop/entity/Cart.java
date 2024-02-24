package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cart")   // таблица
@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
@AllArgsConstructor     // конструктор со всеми полями
@NoArgsConstructor      //конструктор без аргументов
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "cart_quantity")
    private Integer quantity;

    @Column(name = "user_id")
    private Integer user_id;

    @ManyToOne
    @JoinColumn(name = "cart_products")
    private Product products;

    @ManyToOne
    private User user;

    @ManyToOne
    private Order order;

}


