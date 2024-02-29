package ee.coffee.coffeeshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
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
    
    public CartProduct findCartProduct(Long productId) {
        return isEmpty() ? null : cartProducts
            .stream()
            .filter(e -> e.getProduct().getId().equals(productId))
            .findFirst()
            .orElse(null);
    }
    
    public boolean isEmpty() {
        return cartProducts == null || cartProducts.size() == 0;
    }
    
    public BigDecimal getSum() {
        BigDecimal sum = new BigDecimal(0);
        if(!isEmpty()) {
            for(CartProduct cartProduct : cartProducts) {
                sum = sum.add(cartProduct.getSum());
            }
        }
        return sum;
    }
}
