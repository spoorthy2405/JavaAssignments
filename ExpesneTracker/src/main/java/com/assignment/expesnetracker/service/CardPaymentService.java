package com.assignment.expesnetracker.service;
public class CardPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Card payment of ₹" + amount);
    }
}
