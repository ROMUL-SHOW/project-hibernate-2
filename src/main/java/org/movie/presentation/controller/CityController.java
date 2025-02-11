package org.movie.presentation.controller;

import org.movie.data.entity.City;
import org.movie.data.entity.Country;
import org.movie.domain.interactor.CityInteractor;
import org.movie.presentation.presenter.CityPresenter;

import java.util.List;

public class CityController implements Controller {
    private final CityInteractor cityInteractor;
    private final Controller controller;
    private final CityPresenter cityPresenter;
    private boolean isRunning = true;

    public CityController(CityInteractor cityInteractor, Controller controller, CityPresenter cityPresenter) {
        this.cityInteractor = cityInteractor;
        this.controller = controller;
        this.cityPresenter = cityPresenter;
    }


    @Override
    public void start() {
        while (isRunning) {
            cityPresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<City> cities = cityInteractor.findAll();
                    cityPresenter.showCities(cities);
                    break;
                case "2":
                    this.findCity();
                    break;
                case "3":
                    this.saveCity();
                    break;
                case "4":
                    this.updateCity();
                    break;
                case "5":
                    this.deleteCity();
                    break;
                case "6":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findCity() {
        while (true) {
            cityPresenter.promptForCityId();
            Short idForSearch = parseShortInput();
            City city = cityInteractor.findById(idForSearch);
            if (city != null) {
                cityPresenter.showCity(city);
                cityPresenter.promptShowCountry(city.getCity());
                while (true) {
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Country country = city.getCountry();
                        cityPresenter.showCountry(country);
                        break;
                    }
                    if (input.equals("2")) {
                        break;
                    }
                }
            } else {
                cityPresenter.cityNotFound();
            }
            cityPresenter.promptShowNextCity();
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

    private void saveCity() {
        cityPresenter.promptForCityName();
        String name = TableController.getCommand();
        City newCity = new City();
        newCity.setCity(name);
        //TODO: add logic for setCountry
        Country country = new Country();
        country.setId(Short.parseShort("88"));
        newCity.setCountry(country);
        /////////////////////////////////
        cityInteractor.save(newCity);
    }

    private void updateCity() {
        while (true) {
            cityPresenter.promptForCityId();
            Short idForUpdate = parseShortInput();
            City  cityForUpdate = cityInteractor.findById(idForUpdate);
            if (cityForUpdate == null) {
                cityPresenter.cityNotFound();
                break;
            }
            cityPresenter.showCity(cityForUpdate);

            while (true) {
                cityPresenter.promptForUpdateOption();
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
                    cityForUpdate.setCity(name);
                    cityInteractor.update(cityForUpdate);
                    break;
                }
            }
            cityPresenter.promptUpdateNextCity();
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

    private void deleteCity() {
        cityPresenter.promptForCityId();
        Short idForDelete = parseShortInput();
        cityInteractor.delete(idForDelete);
    }

    private Short parseShortInput() {
        while (true) {
            try {
                return Short.parseShort(TableController.getCommand());
            } catch (NumberFormatException e) {
                cityPresenter.invalidInputMessage();
            }
        }
    }
}
