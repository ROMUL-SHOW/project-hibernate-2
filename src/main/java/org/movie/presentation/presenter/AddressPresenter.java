package org.movie.presentation.presenter;

import org.movie.data.entity.Address;
import org.movie.data.entity.City;

import java.util.List;

public class AddressPresenter {
    private final static String MENU = "\nSelect action number:" +
            "\n1. Find all addresses" +
            "\n2. Find address" +
            "\n3. Save address" +
            "\n4. Update address" +
            "\n5. Delete address" +
            "\n6. Return to main menu" +
            "\n\n0. Exit\n";

    private final static String UPDATE_MENU = "\nSelect the field number for update:\n1. Address\n2. District\n3. Finish the update";
    private final static String FIND_NEXT_ADDRESS_MENU = "\nFind next address?\n1. Yes\n2. No, back to address menu\n\n0. Exit";
    private final static String FIND_NEXT_UPDATE_MENU = "\nFind next address for update?\n1. Yes\n2. No, back to address menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showAddress(Address address) {
        System.out.println(address);
    }

    public void showAddresses(List<Address> addresses) {
        if (addresses.isEmpty()) {
            System.out.println("No addresses found");
        } else {
            addresses.forEach(System.out::println);
        }
    }

    public void promptForAddressId() {
        System.out.println("\nEnter address id");
    }

    public void promptForAddress() {
        System.out.println("\nEnter address");
    }

    public void promptForAddressDistrict() {
        System.out.println("\nEnter address district");
    }

    public void promptForAddressPhone() {
        System.out.println("\nEnter address phone");
    }

    public void addressNotFound() {
        System.out.println("🙁 Address not found");
    }

    public void showCity(City city) {
        System.out.println(city);
    }

    public void promptShowCity(String addressName) {
        System.out.println("\nShow city of " + addressName + "?\n1. Yes\n2. No");
    }

    public void promptShowNextAddress() {
        System.out.println(FIND_NEXT_ADDRESS_MENU);
    }

    public void promptForUpdateOption() {
        System.out.println(UPDATE_MENU);
    }

    public void promptUpdateNextAddress() {
        System.out.println(FIND_NEXT_UPDATE_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }

}
