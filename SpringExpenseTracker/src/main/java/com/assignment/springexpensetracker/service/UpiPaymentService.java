package com.assignment.springexpensetracker.service;
import org.springframework.stereotype.Component;

@Component
public class UpiPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment of ₹" + amount);
    }
}