package org.movie.presentation.controller;

import org.movie.data.entity.Actor;
import org.movie.data.entity.Address;
import org.movie.data.entity.City;
import org.movie.domain.interactor.AddressInteractor;
import org.movie.presentation.presenter.AddressPresenter;

import java.util.List;

public class AddressController implements Controller {
    private final AddressInteractor addressInteractor;
    private final Controller controller;
    private final AddressPresenter addressPresenter;
    private boolean isRunning = true;

    public AddressController(AddressInteractor addressInteractor, Controller controller, AddressPresenter addressPresenter) {
        this.addressInteractor = addressInteractor;
        this.controller = controller;
        this.addressPresenter = addressPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            addressPresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<Address> addresses = addressInteractor.findAll();
                    addressPresenter.showAddresses(addresses);
                    break;
                case "2":
                    this.findAddress();
                    break;
                case "3":
                    this.saveAddress();
                    break;
                case "4":
                    this.updateAddress();
                    break;
                case "5":
                    this.deleteAddress();
                    break;
                case "6":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findAddress() {
        while (true) {
            addressPresenter.promptForAddressId();
            Short idForSearch = parseShortInput();
            Address address = addressInteractor.findById(idForSearch);
            if (address != null) {
                addressPresenter.showAddress(address);
                addressPresenter.promptShowCity(address.getAddress());
                while (true) {
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        City city = address.getCity();
                        addressPresenter.showCity(city);
                        break;
                    }
                    if (input.equals("2")) {
                        break;
                    }
                }
            } else {
                addressPresenter.addressNotFound();
            }
            addressPresenter.promptShowNextAddress();
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

    private void saveAddress() {
        addressPresenter.promptForAddress();
        String address = TableController.getCommand();
        addressPresenter.promptForAddressDistrict();
        String district = TableController.getCommand();
        addressPresenter.promptForAddressPhone();
        String phone = TableController.getCommand();

        Address newAddress = new Address();
        newAddress.setAddress(address);
        newAddress.setDistrict(district);
        newAddress.setPhone(phone);
        // TODO:
        City city = new City();
        city.setId((short) 1);
        newAddress.setCity(city);

        addressInteractor.save(newAddress);
    }

    private void updateAddress() {
        while (true) {
            addressPresenter.promptForAddressId();
            Short idForUpdate = parseShortInput();
            Address addressForUpdate = addressInteractor.findById(idForUpdate);
            if (addressForUpdate == null) {
                addressPresenter.addressNotFound();
                break;
            }
            addressPresenter.showAddress(addressForUpdate);

            while (true) {
                addressPresenter.promptForUpdateOption();
                String input = TableController.getCommand();
                if (input.equals("3")) {
                    break;
                }
                switch (input) {
                    case "1":
                        System.out.println("Enter a new address");
                        String updateAddress = TableController.getCommand();
                        addressForUpdate.setAddress(updateAddress);
                        addressInteractor.update(addressForUpdate);
                        continue;
                    case "2":
                        System.out.println("Enter a new district");
                        String updateDistrict = TableController.getCommand();
                        addressForUpdate.setDistrict(updateDistrict);
                        addressInteractor.update(addressForUpdate);
                        continue;
                }
            }
            addressPresenter.promptUpdateNextAddress();
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

    private void deleteAddress() {
        addressPresenter.promptForAddressId();
        Short idForDelete = parseShortInput();
        addressInteractor.delete(idForDelete);
    }

    private Short parseShortInput() {
        while (true) {
            try {
                return Short.parseShort(TableController.getCommand());
            } catch (NumberFormatException e) {
                addressPresenter.invalidInputMessage();
            }
        }
    }
}
