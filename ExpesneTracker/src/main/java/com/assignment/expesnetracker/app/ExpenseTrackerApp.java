package com.assignment.expesnetracker.app;
import com.assignment.expesnetracker.model.Expense;
import com.assignment.expesnetracker.service.PaymentService;
import com.assignment.expesnetracker.service.NotificationService;

public class ExpenseTrackerApp {

    private PaymentService paymentService;
    private NotificationService notificationService;

    // Constructor Injection (DI)
    public ExpenseTrackerApp(PaymentService paymentService,
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

    // MAIN METHOD
    public static void main(String[] args) {

        // Choose implementation
        PaymentService payment = new com.assignment.expesnetracker.service.UpiPaymentService();
        NotificationService notification =
                new com.assignment.expesnetracker.service.EmailNotificationService();

        // Inject dependencies
        ExpenseTrackerApp app =
                new ExpenseTrackerApp(payment, notification);

        Expense expense = new Expense("Groceries", 2500);

        app.addExpense(expense);
    }
}
