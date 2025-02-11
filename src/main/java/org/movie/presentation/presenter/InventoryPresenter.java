package org.movie.presentation.presenter;

import org.movie.data.entity.Film;
import org.movie.data.entity.Inventory;
import org.movie.data.entity.Store;

import java.util.List;

public class InventoryPresenter {
    private final static String MENU = "\nSelect action number:" +
            "\n1. Find all inventories" +
            "\n2. Find inventory" +
            "\n3. Return to main menu" +
            "\n\n0. Exit\n";
    private final static String INVENTORY_MENU = "\nSelect the field number of this inventory:\n1. Film\n2. Store\n3. Finish";
    private final static String UPDATE_MENU = "\nSelect the field number for update:\n1. First name\n2. Last name\n3. Finish the update";
    private final static String FIND_NEXT_INVENTORY_MENU = "\nFind next inventory?\n1. Yes\n2. No, back to inventory menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showInventories(List<Inventory> inventories) {
        if (inventories.isEmpty()) {
            System.out.println("No inventories found");
        } else {
            inventories.forEach(System.out::println);
        }
    }

    public void showInventory(Inventory inventory) {
        System.out.println(inventory);
    }

    public void showFilm(Film film) {
        if (film != null) {
            System.out.println(film.getTitle());
        } else {
            System.out.println("🙁 No film found");
        }
    }

    public void showStore(Store store) {
        if (store != null) {
            System.out.println(store);
        } else {
            System.out.println("🙁 No store found");
        }
    }

    public void promptForInventoryId() {
        System.out.println("\nEnter inventory id");
    }

    public void inventoryNotFound() {
        System.out.println("🙁 Inventory not found");
    }

    public void promptShowProperties() {
        System.out.println(INVENTORY_MENU);
    }

    public void promptShowNextInventory() {
        System.out.println(FIND_NEXT_INVENTORY_MENU);
    }

    public void promptForUpdateOption() {
        System.out.println(UPDATE_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
