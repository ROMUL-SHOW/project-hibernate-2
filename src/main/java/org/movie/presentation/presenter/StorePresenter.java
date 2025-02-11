package org.movie.presentation.presenter;

import org.movie.data.entity.*;
import org.movie.data.entity.Store;

import java.util.List;

public class StorePresenter {
    private final static String MENU = "\nSelect action number:" +
            "\n1. Find all stores" +
            "\n2. Find store" +
            "\n3. Return to main menu" +
            "\n\n0. Exit\n";
    private final static String INVENTORY_MENU = "\nSelect the field number of this store:\n1. Staff\n2. Address\n3. Finish";
    private final static String UPDATE_MENU = "\nSelect the field number for update:\n1. First name\n2. Last name\n3. Finish the update";
    private final static String FIND_NEXT_INVENTORY_MENU = "\nFind next store?\n1. Yes\n2. No, back to store menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showStores(List<Store> stores) {
        if (stores.isEmpty()) {
            System.out.println("No stores found");
        } else {
            stores.forEach(System.out::println);
        }
    }

    public void showStore(Store store) {
        System.out.println(store);
    }

    public void showStaff(Staff staff) {
        if (staff != null) {
            System.out.println(staff.getFirstName() + " " + staff.getLastName());
        } else {
            System.out.println("🙁 No staff found");
        }
    }

    public void showAddress(Address address) {
        if (address != null) {
            System.out.println(address.getAddress());
        } else {
            System.out.println("🙁 No address found");
        }
    }

    public void promptForStoreId() {
        System.out.println("\nEnter store id");
    }

    public void storeNotFound() {
        System.out.println("🙁 Store not found");
    }

    public void promptShowProperties() {
        System.out.println(INVENTORY_MENU);
    }

    public void promptShowNextStore() {
        System.out.println(FIND_NEXT_INVENTORY_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
