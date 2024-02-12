package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.models.Delivery;
import ee.coffee.coffeeshop.services.impl.DeliveryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryServiceImpl deliveryService;

    @GetMapping(value = "/delivery")
    public ResponseEntity<List<Delivery>> findAllDelivery() {
        List<Delivery> delivery = deliveryService.findAllDelivery();
        return ResponseEntity.ok(delivery);
    }

    @GetMapping(value = "/delivery/{id}")
    public Delivery getDeliveryById(@PathVariable(value = "id") Integer id) {
        return deliveryService.getById(id);
    }

    @PostMapping(value = "/delivery/save")
    public void saveDelivery(@RequestBody Delivery delivery) throws IOException {
        deliveryService.save(delivery);
    }

    @DeleteMapping(value = "/delivery/delete")
    public void deleteById(@PathVariable(value = "delivery_id") Integer id) {

        deliveryService.deleteById(id);
    }

    @PutMapping(value = "/delivery/update/{id}")
    public void updateById(@PathVariable(value = "delivery_id") Integer id, @RequestBody Delivery delivery) {
        deliveryService.update(id, delivery);
    }
}

