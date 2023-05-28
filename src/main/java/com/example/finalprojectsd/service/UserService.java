package com.example.finalprojectsd.service;

import com.example.finalprojectsd.config.authentification.JwtTokenUtil;
import com.example.finalprojectsd.model.Order;
import com.example.finalprojectsd.model.User;
import com.example.finalprojectsd.observer.Subject;
import com.example.finalprojectsd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService extends Subject {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UserService(UserRepository userRepository, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public JwtTokenUtil getJwtTokenUtil() {
        return jwtTokenUtil;
    }

    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public String login(String username, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<User> foundUser = userRepository.findAll().stream().filter(user -> user.getUsername().equals(username)).findFirst();
        if(foundUser.isPresent()) {
            if(passwordEncoder.matches(password, foundUser.get().getPassword())) {
                return jwtTokenUtil.generateToken(foundUser.get());
            }
            return "";
        }
        return "";
    }

    public List<User> getAllUsers() {
        List<User> users  = new ArrayList<>();

        userRepository.findAll()
                .forEach(users::add);

        return users;
    }

    public void registerUser(String password, String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token.substring(7));
        Optional<User> foundUser = userRepository.findAll().stream().filter(user -> user.getUsername().equals(username)).findFirst();
        if(foundUser.isPresent()) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            foundUser.get().setPassword(encodedPassword);
            userRepository.save(foundUser.get());
        }
    }

    public String saveUser(User user) {
        User createdUser = userRepository.save(user);
        return jwtTokenUtil.generateToken(createdUser);
    }

    public User getUserById(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }else{
            throw new RuntimeException("User is not found for id::" + id);
        }
        return user;
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public void sendNotification(long userId, long orderId) throws IOException {
        User fromUser = getUserById(userId);
        if(Objects.equals(fromUser.getRole(), "Kitchen_employee")) {
            Order order = orderService.getOrderById(orderId);
            User toUser = order.getWaiter();
            if(Objects.equals(toUser.getRole(), "Waiter")) {
                notifyObservers(0, toUser.getUsername() + " gets notified for order by id " + orderId +"\n");
            }
        }
    }
}
