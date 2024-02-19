package ee.coffee.coffeeshop.dto;

import ee.coffee.coffeeshop.enums.DeliveryMethod;
import ee.coffee.coffeeshop.enums.PaymentMethod;
import lombok.Data;

@Data       // getter + setter + required args + to string + equals
public class OrderDTO {
    private PaymentMethod paymentMethod;
    private DeliveryMethod deliveryMethod;
}
