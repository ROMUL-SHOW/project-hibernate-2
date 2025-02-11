package org.movie.presentation.controller;

import org.movie.data.entity.Inventory;
import org.movie.data.entity.Film;
import org.movie.data.entity.Store;
import org.movie.domain.interactor.InventoryInteractor;
import org.movie.presentation.presenter.InventoryPresenter;

import java.util.List;

public class InventoryController implements Controller {
    private final InventoryInteractor inventoryInteractor;
    private final Controller controller;
    private final InventoryPresenter inventoryPresenter;
    private boolean isRunning = true;


    public InventoryController(InventoryInteractor inventoryInteractor, Controller controller, InventoryPresenter inventoryPresenter) {
        this.inventoryInteractor = inventoryInteractor;
        this.controller = controller;
        this.inventoryPresenter = inventoryPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            inventoryPresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<Inventory> inventories = inventoryInteractor.findAll();
                    inventoryPresenter.showInventories(inventories);
                    break;
                case "2":
                    this.findInventory();
                    break;
                case "3":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findInventory() {
        while (true) {
            inventoryPresenter.promptForInventoryId();
            Integer idForSearch = parseIntegerInput();
            Inventory inventory = inventoryInteractor.findById(idForSearch);

            if (inventory != null) {
                inventoryPresenter.showInventory(inventory);
                while (true) {
                    inventoryPresenter.promptShowProperties();
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Film film = inventory.getFilm();
                        inventoryPresenter.showFilm(film);
                        continue;
                    }
                    if (input.equals("2")) {
                        Store store = inventory.getStore();
                        inventoryPresenter.showStore(store);
                        continue;
                    }
                    if (input.equals("3")) {
                        break;
                    }
                }
            } else {
                inventoryPresenter.inventoryNotFound();
            }
            inventoryPresenter.promptShowNextInventory();
            String input;
            while (true) {
                input = TableController.getCommand();
                if (input == null) {
                    continue;
                }
                if (input.equals("1") || input.equals("2") || input.equals("0")) {
                    break;
                }
            }
            if (input.equals("1")) {
                continue;
            }
            if (input.equals("2")) {
                break;
            }
        }
    }

    private Integer parseIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(TableController.getCommand());
            } catch (NumberFormatException e) {
                inventoryPresenter.invalidInputMessage();
            }
        }
    }
}
