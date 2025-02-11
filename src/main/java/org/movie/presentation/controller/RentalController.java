package org.movie.presentation.controller;

import org.movie.data.entity.*;
import org.movie.domain.interactor.RentalInteractor;
import org.movie.presentation.presenter.RentalPresenter;

import java.util.List;

public class RentalController implements Controller {
    private final RentalInteractor rentalInteractor;
    private final Controller controller;
    private final RentalPresenter rentalPresenter;
    private boolean isRunning = true;


    public RentalController(RentalInteractor rentalInteractor, Controller controller, RentalPresenter rentalPresenter) {
        this.rentalInteractor = rentalInteractor;
        this.controller = controller;
        this.rentalPresenter = rentalPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            rentalPresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<Rental> rentals = rentalInteractor.findAll();
                    rentalPresenter.showRentals(rentals);
                    break;
                case "2":
                    this.findRental();
                    break;
                case "3":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findRental() {
        while (true) {
            rentalPresenter.promptForRentalId();
            Integer idForSearch = parseIntegerInput();
            Rental rental = rentalInteractor.findById(idForSearch);

            if (rental != null) {
                rentalPresenter.showRental(rental);
                while (true) {
                    rentalPresenter.promptShowProperties();
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Staff staff = rental.getStaff();
                        rentalPresenter.showStaff(staff);
                        continue;
                    }
                    if (input.equals("2")) {
                        Customer customer = rental.getCustomer();
                        rentalPresenter.showCustomer(customer);
                        continue;
                    }
                    if (input.equals("3")) {
                        Inventory inventory = rental.getInventory();
                        rentalPresenter.showInventory(inventory);
                        continue;
                    }
                    if (input.equals("4")) {
                        break;
                    }
                }
            } else {
                rentalPresenter.rentalNotFound();
            }
            rentalPresenter.promptShowNextRental();
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
                rentalPresenter.invalidInputMessage();
            }
        }
    }
}
