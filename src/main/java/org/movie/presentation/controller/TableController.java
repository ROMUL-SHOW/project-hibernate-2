package org.movie.presentation.controller;

import org.movie.presentation.presenter.*;
import org.movie.presentation.provider.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TableController implements Controller {
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private FilmController filmController;
    private ActorController actorController;
    private CustomerController customerController;
    private StaffController staffController;
    private AddressController addressController;
    private CategoryController categoryController;
    private LanguageController languageController;
    private CityController cityController;
    private CountryController countryController;
    private FilmTextController filmTextController;
    private InventoryController inventoryController;
    private StoreController storeController;
    private RentalController rentalController;
    private PaymentController paymentController;
    private boolean isRunning = true;
    private final static String MENU = "Select table number:" +
            "\n1. Films\n2. Actors\n3. Customers\n4. Staffers\n5. Addresses\n6. Categories" +
            "\n7. Languages\n8. Cities\n9. Countries\n10. FilmTexts\n11. Inventories\n12. Stores" +
            "\n13. Rentals\n14. Payments\n\n0. Exit\n";

    @Override
    public void start() {
        while (isRunning) {
            System.out.println(MENU);
            switch (getCommand()) {
                case "1":
                    this.filmController.start();
                    break;
                case "2":
                    this.actorController.start();
                    break;
                case "3":
                    this.customerController.start();
                    break;
                case "4":
                    this.staffController.start();
                    break;
                case "5":
                    this.addressController.start();
                    break;
                case "6":
                    this.categoryController.start();
                    break;
                case "7":
                    this.languageController.start();
                    break;
                case "8":
                    this.cityController.start();
                    break;
                case "9":
                    this.countryController.start();
                    break;
                case "10":
                    this.filmTextController.start();
                    break;
                case "11":
                    this.inventoryController.start();
                    break;
                case "12":
                    this.storeController.start();
                    break;
                case "13":
                    this.rentalController.start();
                    break;
                case "14":
                    this.paymentController.start();
                    break;
            }
        }
    }

    public void initComponents() {
        FilmInteractorProvider filmInteractorProvider = new FilmInteractorProvider();
        FilmPresenter filmPresenter = new FilmPresenter();
        this.filmController = new FilmController(filmInteractorProvider.provide(), this, filmPresenter);

        ActorInteractorProvider actorInteractorProvider = new ActorInteractorProvider();
        ActorPresenter actorPresenter = new ActorPresenter();
        this.actorController = new ActorController(actorInteractorProvider.provide(), this, actorPresenter);

        CustomerInteractorProvider customerInteractorProvider = new CustomerInteractorProvider();
        CustomerPresenter customerPresenter = new CustomerPresenter();
        this.customerController = new CustomerController(customerInteractorProvider.provide(), this, customerPresenter);

        StaffInteractorProvider staffInteractorProvider = new StaffInteractorProvider();
        StaffPresenter staffPresenter = new StaffPresenter();
        this.staffController = new StaffController(staffInteractorProvider.provide(), this, staffPresenter);

        AddressInteractorProvider addressInteractorProvider = new AddressInteractorProvider();
        AddressPresenter addressPresenter = new AddressPresenter();
        this.addressController = new AddressController(addressInteractorProvider.provide(), this, addressPresenter);

        CategoryInteractorProvider categoryInteractorProvider = new CategoryInteractorProvider();
        CategoryPresenter categoryPresenter = new CategoryPresenter();
        this.categoryController = new CategoryController(categoryInteractorProvider.provide(), this, categoryPresenter);

        LanguageInteractorProvider languageInteractorProvider = new LanguageInteractorProvider();
        LanguagePresenter languagePresenter = new LanguagePresenter();
        this.languageController = new LanguageController(languageInteractorProvider.provide(), this, languagePresenter);

        CityInteractorProvider cityInteractorProvider = new CityInteractorProvider();
        CityPresenter cityPresenter = new CityPresenter();
        this.cityController = new CityController(cityInteractorProvider.provide(), this, cityPresenter);

        CountryInteractorProvider countryInteractorProvider = new CountryInteractorProvider();
        CountryPresenter countryPresenter = new CountryPresenter();
        this.countryController = new CountryController(countryInteractorProvider.provide(), this, countryPresenter);

        FilmTextInteractorProvider filmTextInteractorProvider = new FilmTextInteractorProvider();
        FilmTextPresenter filmTextPresenter = new FilmTextPresenter();
        this.filmTextController = new FilmTextController(filmTextInteractorProvider.provide(), this, filmTextPresenter);

        InventoryInteractorProvider inventoryInteractorProvider = new InventoryInteractorProvider();
        InventoryPresenter inventoryPresenter = new InventoryPresenter();
        this.inventoryController = new InventoryController(inventoryInteractorProvider.provide(), this, inventoryPresenter);

        StoreInteractorProvider storeInteractorProvider = new StoreInteractorProvider();
        StorePresenter storePresenter = new StorePresenter();
        this.storeController = new StoreController(storeInteractorProvider.provide(), this, storePresenter);

        RentalInteractorProvider rentalInteractorProvider = new RentalInteractorProvider();
        RentalPresenter rentalPresenter = new RentalPresenter();
        this.rentalController = new RentalController(rentalInteractorProvider.provide(), this, rentalPresenter);

        PaymentInteractorProvider paymentInteractorProvider = new PaymentInteractorProvider();
        PaymentPresenter paymentPresenter = new PaymentPresenter();
        this.paymentController = new PaymentController(paymentInteractorProvider.provide(), this, paymentPresenter);
    }

    public static String getCommand() {
        String command = null;
        try {
            command = reader.readLine();
            if (command != null && command.equals("0")) {
                reader.close();
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return command;
    }
}
