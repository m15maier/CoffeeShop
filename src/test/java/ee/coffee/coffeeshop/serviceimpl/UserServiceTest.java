package ee.coffee.coffeeshop.serviceimpl;

import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.impl.UserServiceImpl;
import ee.coffee.coffeeshop.services.interfaces.CoffeeShopExeption;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

        @Mock
        private UserRepository userRepository;
        @InjectMocks
        private UserServiceImpl userService;

    @Test
        public void createUser() throws CoffeeShopExeption {
            User ann = new User();
            ann.setName("ann");
            ann.setEmail("ann@gmail.com");
            ann.setAddress("USA");
            ann.setPhone("1234567");

            userService.createUser(ann);
            assertEquals(ann, new User());

            userService.createUser(ann);
            assertEquals(ann, new User());

            verify(userRepository, times(1)).save(ann);
        }

        @Test
        public void listTest() {

            List<User> list = new ArrayList<>();

            User ann = new User();
            ann.setId(1L);
            list.add(ann);

            User mike = new User();
            ann.setId(2L);
            list.add(mike);

            when(userRepository.findAll()).thenReturn(list);   // задаётся поведение мокито для метода
            List<User> users1 = userService.list();      // запускается тестируемый метод

            assertNotNull(list);               // проверяются результаты теста
            assertNotNull(users1);

            assertEquals (list.size(), users1.size());

            verify(userRepository, times(2)).findAll();
        }


    public void getByIdTest() {

        User jess = new User();
        jess.setName("jess");
        jess.setId(8L);

        when(userRepository.findById(8L)).thenReturn(Optional.of(jess));  // задаётся поведение мокито для метода
        User jess2 = userService.getById(8L);      // запускается тестируемый метод

        assertEquals (jess, jess2);   // проверяются результаты теста

        verify(userRepository, times(1)).findAll();
    }
}
