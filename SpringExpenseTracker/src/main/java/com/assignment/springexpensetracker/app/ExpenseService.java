package com.assignment.springexpensetracker.app;
import com.assignment.springexpensetracker.model.Expense;
import com.assignment.springexpensetracker.service.NotificationService;
import com.assignment.springexpensetracker.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpenseService {

    private PaymentService paymentService;
    private NotificationService notificationService;

    @Autowired
    public ExpenseService(PaymentService paymentService,
                          NotificationService notificationService) {
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public void addExpense(Expense expense) {

        System.out.println("Expense Added: " + expense.getTitle());

        paymentService.processPayment(expense.getAmount());

        notificationService.sendNotification(
                "Expense of ₹" + expense.getAmount() + " added successfully"
        );
    }
}
