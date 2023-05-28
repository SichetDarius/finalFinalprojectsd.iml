package com.example.finalprojectsd.observer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class ObserverSend implements IObserverSend{
    @Override
    public void sendEmail(int i, String s) {

        System.out.println(s);

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("assignmentsdsic@gmail.com");
        mailSender.setPassword("xndsxvtqaqfvldew");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        mailSender.setJavaMailProperties(properties);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("assignmentsdsic@gmail.com");
        message.setTo("darius.sichet25@gmail.com");

        message.setText(s);
        mailSender.send(message);


    }
}
