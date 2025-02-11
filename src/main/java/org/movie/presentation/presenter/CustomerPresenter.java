package org.movie.presentation.presenter;

import org.movie.data.entity.Customer;

import java.util.List;

public class CustomerPresenter {
    private final static String MENU = "\nSelect customer number:\n1. Find all customers\n2. Find customer by ID\n3. Save customer\n4. Update customer\n5. Delete customer\n6. Return to main menu\n\n0. Exit\n";
    private final static String UPDATE_MENU = "\nSelect the field number for update:\n1. First name\n2. Last name\n3. Finish the update";
    private final static String FIND_NEXT_CUSTOMER_MENU = "\nFind next customer?\n1. Yes\n2. No, back to customer menu\n\n0. Exit";
    private final static String FIND_NEXT_UPDATE_MENU = "\nFind next customer for update?\n1. Yes\n2. No, back to customer menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showCustomer(List<Customer> customers){
        if(customers.isEmpty()){
            System.out.println("🙁 No films found");
        } else {
            customers.forEach(System.out::println);
        }
    }

    public void showCustomer(Customer customer) {
        System.out.println(customer);
    }

    public void promptForCustomerId(){
        System.out.println("\nEnter customer id");
    }

    public void promptForCustomerFirstName() {
        System.out.println("\nEnter first name");
    }

    public void promptForCustomerLastName() {
        System.out.println("Enter last name");
    }

    public void promptShowAddress(String firstName, String lastName) {
        System.out.println("\nShow " + firstName + " " + lastName + "'s address?\n1. Yes\n2. No");
    }

    public void customerNotFound(){
        System.out.println("🙁 Customer not found");
    }

    public void promptShowNextCustomer() {
        System.out.println(FIND_NEXT_CUSTOMER_MENU);
    }

    public void promptForUpdateOption() {
        System.out.println(UPDATE_MENU);
    }

    public void promptUpdateNextCustomer() {
        System.out.println(FIND_NEXT_UPDATE_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
