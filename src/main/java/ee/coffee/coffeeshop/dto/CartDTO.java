package ee.coffee.coffeeshop.dto;

import lombok.Data;

@Data       // getter + setter + required args + to string + equals
public class CartDTO {
    private Integer productId;
    private Integer quantity;
}
