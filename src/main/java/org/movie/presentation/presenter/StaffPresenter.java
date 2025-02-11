package org.movie.presentation.presenter;

import org.movie.data.entity.Staff;

import java.util.List;

public class StaffPresenter {
    private final static String MENU = "\nSelect action number:" +
            "\n1. Find all staffers" +
            "\n2. Find staffer" +
            "\n3. Save staffer" +
            "\n4. Update staffer" +
            "\n5. Delete staffer" +
            "\n6. Return to main menu" +
            "\n\n0. Exit\n";

    private final static String SEARCH_MENU = "1. Find staffer by ID\n2. Find staffer by full name\n\n3.Back to staffer menu";
    private final static String UPDATE_MENU = "\nSelect the field number for update:\n1. First name\n2. Last name\n3. Finish the update";
    private final static String FIND_NEXT_STAFF_MENU = "\nFind next staffer?\n1. Yes\n2. No, back to staff menu\n\n0. Exit";
    private final static String FIND_NEXT_UPDATE_MENU = "\nFind next staffer for update?\n1. Yes\n2. No, back to staffer menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showStaff(List<Staff> staffers){
        if (staffers.isEmpty()) {
            System.out.println("No staffers found");
        } else {
            staffers.forEach(System.out::println);
        }
    }

    public void showStaff(Staff staff) {
        System.out.println(staff);
    }

    public void promptForStaffId() {
        System.out.println("\nEnter staffer id");
    }

    public void promptForStafferFirstName() {
        System.out.println("\nEnter first name");
    }

    public void promptForStafferLastName() {
        System.out.println("Enter last name");
    }

    public void promptForStafferUserName() {
        System.out.println("Enter user name");
    }

    public void promptShowAddress(String firstName, String lastName) {
        System.out.println("\nShow " + firstName + " " + lastName + "'s address?\n1. Yes\n2. No");
    }

    public void stafferNotFound() {
        System.out.println("🙁 Staffer not found");
    }

    public void promptForSearchOption() {
        System.out.println(SEARCH_MENU);
    }

    public void promptForUpdateOption() {
        System.out.println(UPDATE_MENU);
    }

    public void promptUpdateNextStaffer() {
        System.out.println(FIND_NEXT_UPDATE_MENU);
    }

    public void promptShowNextStaff() {
        System.out.println(FIND_NEXT_STAFF_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
