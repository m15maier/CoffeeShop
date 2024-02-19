package ee.coffee.coffeeshop.dto;

import lombok.Data;

@Data       // getter + setter + required args + to string + equals
public class SharePaymentDTO {
    private Long fromId;
    private Long toId;
    private Integer countOfPayment;
}

