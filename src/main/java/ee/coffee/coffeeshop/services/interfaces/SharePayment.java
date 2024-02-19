package ee.coffee.coffeeshop.services.interfaces;

public interface SharePayment {

    void sharePayment(Long fromId, Long toId, Integer countOfPayment);
}

