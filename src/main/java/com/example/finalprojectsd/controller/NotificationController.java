package com.example.finalprojectsd.controller;

import com.example.finalprojectsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/notification")
@RestController
public class NotificationController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/{orderId}")
    public void sendNotification(@PathVariable(value = "userId") long userId, @PathVariable(value = "orderId") long orderId) throws IOException {
        userService.sendNotification(userId, orderId);
    }
}
