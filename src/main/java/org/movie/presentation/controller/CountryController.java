package org.movie.presentation.controller;

import org.movie.data.entity.Country;
import org.movie.domain.interactor.CountryInteractor;
import org.movie.presentation.presenter.CountryPresenter;

import java.util.List;

public class CountryController implements Controller {
    private final CountryInteractor countryInteractor;
    private final Controller controller;
    private final CountryPresenter countryPresenter;
    private boolean isRunning = true;

    public CountryController(CountryInteractor countryInteractor, Controller controller, CountryPresenter countryPresenter) {
        this.countryInteractor = countryInteractor;
        this.controller = controller;
        this.countryPresenter = countryPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            countryPresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<Country> categories = countryInteractor.findAll();
                    countryPresenter.showCountries(categories);
                    break;
                case "2":
                    this.findCountry();
                    break;
                case "3":
                    this.saveCountry();
                    break;
                case "4":
                    this.updateCountry();
                    break;
                case "5":
                    this.deleteCountry();
                    break;
                case "6":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findCountry() {
        while (true) {
            countryPresenter.promptForCountryId();
            Short idForSearch = parseShortInput();
            Country country = countryInteractor.findById(idForSearch);
            if (country != null) {
                countryPresenter.showCountry(country);
            } else {
                countryPresenter.countryNotFound();
            }
            countryPresenter.promptShowNextCountry();
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

    private void saveCountry() {
        countryPresenter.promptForCountryName();
        String name = TableController.getCommand();
        Country newCountry = new Country();
        newCountry.setCountry(name);
        countryInteractor.save(newCountry);
    }


    private void updateCountry() {
        while (true) {
            countryPresenter.promptForCountryId();
            Short idForUpdate = parseShortInput();
            Country countryForUpdate = countryInteractor.findById(idForUpdate);
            if (countryForUpdate == null) {
                countryPresenter.countryNotFound();
                break;
            }
            countryPresenter.showCountry(countryForUpdate);

            while (true) {
                countryPresenter.promptForUpdateOption();
                String input = TableController.getCommand();
                if(input.isBlank()) {
                    continue;
                }
                if (input.equals("2")) {
                    break;
                }
                if(input.equals("1")) {
                    System.out.println("Enter a new name");
                    String name = TableController.getCommand();
                    countryForUpdate.setCountry(name);
                    countryInteractor.update(countryForUpdate);
                    break;
                }
            }
            countryPresenter.promptUpdateNextCountry();
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

    private void deleteCountry() {
        countryPresenter.promptForCountryId();
        Short idForDelete = parseShortInput();
        countryInteractor.delete(idForDelete);
    }


    private Short parseShortInput() {
        while (true) {
            try {
                return Short.parseShort(TableController.getCommand());
            } catch (NumberFormatException e) {
                countryPresenter.invalidInputMessage();
            }
        }
    }
}
