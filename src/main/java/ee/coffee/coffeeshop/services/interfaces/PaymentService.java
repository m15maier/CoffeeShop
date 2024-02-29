package ee.coffee.coffeeshop.services.interfaces;

public interface PaymentService {

    void sharePayment(Long fromId, Long toId, Integer countOfPayment);
}

