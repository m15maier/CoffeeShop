package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.dto.SharePaymentDTO;
import ee.coffee.coffeeshop.services.interfaces.SharePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class SharePaymentController {

    private final SharePayment sharePayment;

    @PostMapping(value = "/share_payment/")
    public void sharePayment(@RequestBody SharePaymentDTO sharePaymentDTO) {
        sharePayment.sharePayment(sharePaymentDTO.getFromId(), sharePaymentDTO.getToId(), sharePaymentDTO.getCountOfPayment());

    }
}
