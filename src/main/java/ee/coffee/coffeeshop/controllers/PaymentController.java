package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.dto.PaymentDTO;
import ee.coffee.coffeeshop.services.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(value = "/share_payment/")
    public void sharePayment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.sharePayment(paymentDTO.getFromId(), paymentDTO.getToId(), paymentDTO.getCountOfPayment());

    }
}
