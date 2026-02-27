package com.assignment.springexpensetracker.service;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email: " + message);
    }
}
