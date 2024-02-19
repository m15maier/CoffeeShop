package ee.coffee.coffeeshop.serviceimpl;

import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

        @Mock
        private UserRepository userRepository;
        @InjectMocks
        private UserServiceImpl userService;

        List<User> user;

        @Test
        public void saveUser() {
            User ann = new User();
            ann.setUser_name("ann");
            ann.setUser_email("ann@gmail.com");
            ann.setUser_address("USA");
            ann.setUser_phone("1234567");

            User mike = userService.saveUser("ann", "ann@gmail.com","USA", "1234567");
            assertEquals(ann, mike);
        }

        @Test
        public void getAllUsersTest() {

            List<User> users = new ArrayList<>();

            User ann = new User();
            ann.setUserId(1);
            users.add(ann);

            User mike = new User();
            ann.setUserId(2);
            users.add(mike);

            when(userRepository.getAllUsers()).thenReturn(users);   // задаётся поведение мокито для метода
            List<User> users1 = userService.getAllUsers();      // запускается тестируемый метод

            assertNotNull(users);               // проверяются результаты теста
            assertNotNull(users1);

            assertEquals (users.size(), users1.size());

            verify(userRepository, times(2)).getAllUsers();
        }


    }
