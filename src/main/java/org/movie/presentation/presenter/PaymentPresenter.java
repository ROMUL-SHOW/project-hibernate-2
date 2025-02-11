package org.movie.presentation.presenter;

import org.movie.data.entity.*;

import java.util.List;

public class PaymentPresenter {
    private final static String MENU = "\nSelect action number:" +
            "\n1. Find all payments" +
            "\n2. Find payment" +
            "\n3. Return to main menu" +
            "\n\n0. Exit\n";
    private final static String INVENTORY_MENU = "\nSelect the field number of this payment:\n1. Staff\n2. Customer\n3. Rental\n4. Finish";
    private final static String FIND_NEXT_INVENTORY_MENU = "\nFind next payment?\n1. Yes\n2. No, back to payment menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showPayments(List<Payment> payments) {
        if (payments.isEmpty()) {
            System.out.println("No payments found");
        } else {
            payments.forEach(System.out::println);
        }
    }

    public void showPayment(Payment payment) {
        System.out.println(payment);
    }

    public void showStaff(Staff staff) {
        if (staff != null) {
            System.out.println(staff.getFirstName() + " " + staff.getLastName());
        } else {
            System.out.println("🙁 No staff found");
        }
    }

    public void showCustomer(Customer customer) {
        if (customer != null) {
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
        } else {
            System.out.println("🙁 No customer found");
        }
    }

    public void showRental(Rental rental) {
        if (rental != null) {
            System.out.println(rental);
        } else {
            System.out.println("🙁 No rental found");
        }
    }

    public void promptForPaymentId() {
        System.out.println("\nEnter payment id");
    }

    public void paymentNotFound() {
        System.out.println("🙁 Payment not found");
    }

    public void promptShowProperties() {
        System.out.println(INVENTORY_MENU);
    }

    public void promptShowNextPayment() {
        System.out.println(FIND_NEXT_INVENTORY_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
