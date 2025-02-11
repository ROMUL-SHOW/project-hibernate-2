package org.movie.presentation.presenter;

import org.movie.data.entity.*;

import java.util.List;

public class RentalPresenter {
    private final static String MENU = "\nSelect action number:" +
            "\n1. Find all rentals" +
            "\n2. Find rental" +
            "\n3. Return to main menu" +
            "\n\n0. Exit\n";
    private final static String INVENTORY_MENU = "\nSelect the field number of this rental:\n1. Staff\n2. Customer\n3. Inventory\n4. Finish";
    private final static String FIND_NEXT_INVENTORY_MENU = "\nFind next rental?\n1. Yes\n2. No, back to rental menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showRentals(List<Rental> rentals) {
        if (rentals.isEmpty()) {
            System.out.println("No rentals found");
        } else {
            rentals.forEach(System.out::println);
        }
    }

    public void showRental(Rental rental) {
        System.out.println(rental);
    }

    public void showInventory(Inventory inventory) {
        if (inventory != null) {
            System.out.println(inventory);
        } else {
            System.out.println("🙁 No inventory found");
        }
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

    public void promptForRentalId() {
        System.out.println("\nEnter rental id");
    }

    public void rentalNotFound() {
        System.out.println("🙁 Rental not found");
    }

    public void promptShowProperties() {
        System.out.println(INVENTORY_MENU);
    }

    public void promptShowNextRental() {
        System.out.println(FIND_NEXT_INVENTORY_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
