package ee.coffee.coffeeshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data       // getter + setter + required args + to string + equals
@Entity     // сущность jpa
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Integer quantity = 0;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;
    
    public BigDecimal getSum() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
