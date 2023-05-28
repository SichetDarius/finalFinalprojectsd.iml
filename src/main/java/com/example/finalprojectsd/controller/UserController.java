package com.example.finalprojectsd.controller;

import com.example.finalprojectsd.dto.LoginDto;
import com.example.finalprojectsd.model.User;
import com.example.finalprojectsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/waiters")
    public List<User> showWaiters() {
        return userService.getAllUsers().stream().filter(user -> user.getRole().equals("WAITER")).collect(Collectors.toList());
    }
    @GetMapping("/kitchenemployees")
    public List<User> showEmployees() {
        return userService.getAllUsers().stream().filter(user -> user.getRole().equals("EMPLOYEE")).collect(Collectors.toList());
    }
   @PostMapping("/addwaiter")
   public void addWaiter(@RequestBody User user) {
       user.setRole("Waiter");
       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       String encodedPassword = passwordEncoder.encode(user.getPassword());
       user.setPassword(encodedPassword);
       userService.saveUser(user);
   }

    @PostMapping("/updatewaiter")
    public void updateWaiter(@RequestBody User user) {
        user.setRole("Waiter");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
    }

    @PostMapping("/addemployee")
    public void addKitchenEmployee(@RequestBody User user) {
        user.setRole("Kitchen_employee");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
    }

    @PostMapping("/updateemployee")
    public void updateKitchenEmployee(@RequestBody User user) {
        user.setRole("Kitchen_employee");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
    }
    @PostMapping("/add")
    public void addClient(@RequestBody User user) {
        user.setRole("Client");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
    }
    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto login) {
        return userService.login(login.getUsername(), login.getPassword());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUserById(id);
    }


  //  private void verifyUserRole(String token, String roleNeeded) {
  //      Optional<String> role = userService.getJwtTokenUtil().getRoleFromToken(token.substring(7));
  //      if(!role.isPresent() || !Objects.equals(role.get(), roleNeeded)) {
  //          throw new ForbiddenException("The user does not have teacher role!");
  //      }
  //  }

}