package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.PaymentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {

private final UserRepository userRepository;

    @Override
    public void sharePayment(Long fromId, Long toId, Integer countOfPayment) {
        Optional<User> fromUserOptional = userRepository.findById(fromId.intValue());
        Optional<User> toUserOptional = userRepository.findById(toId.intValue());

        if(fromUserOptional.isPresent() && toUserOptional.isPresent()) {
            User fromUser = fromUserOptional.get();
            User toUser = toUserOptional.get();     // передача оплаты

            fromUser.setPayment(fromUser.getPayment() - countOfPayment);    // обновление оплаты
            toUser.setPayment(toUser.getPayment() + countOfPayment);

            userRepository.save(fromUser);

            if (true) {
                throw new RuntimeException();
            }

            userRepository.save(toUser);
        }
    }
}
