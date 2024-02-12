package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.models.Delivery;
import ee.coffee.coffeeshop.models.User;
import ee.coffee.coffeeshop.repositories.DeliveryRepository;
import ee.coffee.coffeeshop.services.interfaces.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public Delivery getById(Integer delivery_id) {
        Optional<Delivery> optional = deliveryRepository.findById(delivery_id);
        return optional.orElse(null);
    }

    @Override
    public List<Delivery> findAllDelivery() {
        return deliveryRepository.findAll();
    }
    @Override
    public Collection<Delivery> getAllByUser(User user) {
        return deliveryRepository.findAllByUser(user);
    }

    @Override
    public void save(Delivery delivery) {
        if (delivery == null) {
            return;
        }
        deliveryRepository.save(delivery);
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && deliveryRepository.existsById(id)) {
            deliveryRepository.deleteById(id);
        }
    }

    @Override
    public void update(Integer id, Delivery delivery) {
        Optional<Delivery> persistDeliveryOptional = deliveryRepository.findById(id);
        if (persistDeliveryOptional.isPresent()) {     // Проверяет наличие
            Delivery persistDelivery = persistDeliveryOptional.get();   // Показывает
            persistDelivery.setDelivery_id(delivery.getDelivery_id());    // Устанавливает новое имя в корзину
            persistDelivery.setUser(delivery.getUser());
            persistDelivery.setDelivery_status(delivery.getDelivery_status());
            persistDelivery.setOrder(delivery.getOrder());
            deliveryRepository.save(persistDelivery);   // Пересохраняет доставку
        }
    }
}
