package com.example.finalprojectsd;

import com.example.finalprojectsd.controller.NotificationController;
import com.example.finalprojectsd.controller.OrderController;
import com.example.finalprojectsd.controller.UserController;
import com.example.finalprojectsd.model.Order;
import com.example.finalprojectsd.model.User;
import com.example.finalprojectsd.repository.UserRepository;
import com.example.finalprojectsd.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FinalprojectsdApplicationTests {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserController userController;
    @Mock
    private OrderController orderController;
    @Mock
    private NotificationController notificationController;
    @Test
    public void testCreateNotification() throws IOException {
        User user = new User(50L,"client@gmail.com","abc","aaa","aaa","aaa","Client",1,0);
        User waiter=new User(59L,"waiter@gmail.com","abc","abaa","abaa","abaa","Waiter",0,0);
        userController.addClient(user);
        Order order = new Order(40L,20,user,waiter);
        orderController.addOrder(order);
        notificationController.sendNotification(1,2);
    }

}
