package com.assignment.expesnetracker.service;
public class SmsNotificationService implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}