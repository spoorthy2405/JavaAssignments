package com.assignment.springexpensetracker.app;

import com.assignment.springexpensetracker.config.AppConfig;
import com.assignment.springexpensetracker.model.Expense;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ExpenseService expenseService =
                context.getBean(ExpenseService.class);

        Expense expense = new Expense("Groceries", 2500);

        expenseService.addExpense(expense);
    }
}
