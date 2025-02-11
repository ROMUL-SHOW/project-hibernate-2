package org.movie.presentation.controller;

import org.movie.data.entity.Address;
import org.movie.data.entity.Customer;
import org.movie.data.entity.Staff;
import org.movie.data.entity.Store;
import org.movie.domain.interactor.CustomerInteractor;
import org.movie.presentation.presenter.CustomerPresenter;

import java.util.List;

public class CustomerController implements Controller {
    private final CustomerInteractor customerInteractor;
    private final Controller controller;
    private final CustomerPresenter customerPresenter;
    private boolean isRunning = true;

    public CustomerController(CustomerInteractor customerInteractor, Controller controller, CustomerPresenter customerPresenter) {
        this.customerInteractor = customerInteractor;
        this.controller = controller;
        this.customerPresenter = customerPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            customerPresenter.showMenu();
            switch (TableController.getCommand()) {
                case "1":
                    List<Customer> customers = customerInteractor.findAll();
                    customerPresenter.showCustomer(customers);
                    break;
                case "2":
                    findCustomer();
                    break;
                case "3":
                    saveCustomer();
                    break;
                case "4":
                    updateCustomer();
                    break;
                case "5":
                    deleteCustomer();
                    break;
                case "6":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findCustomer() {
        while (true) {
            customerPresenter.promptForCustomerId();
            Short idForSearch = parseShortInput();
            Customer customer = customerInteractor.findById(idForSearch);
            if (customer != null) {
                customerPresenter.showCustomer(customer);
                customerPresenter.promptShowAddress(customer.getFirstName(), customer.getLastName());
                while (true) {
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Address address= customer.getAddress();
                        System.out.println(address.getAddress() + " " + address.getAddress2() + " " + address.getDistrict());
                        break;
                    }
                    if (input.equals("2")) {
                        break;
                    }
                }
            } else {
                customerPresenter.customerNotFound();
            }
            customerPresenter.promptShowNextCustomer();
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


    private void saveCustomer() {
        customerPresenter.promptForCustomerFirstName();
        String firstName = TableController.getCommand();
        customerPresenter.promptForCustomerLastName();
        String lastName = TableController.getCommand();
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);

        // TODO: will add logic with other fields for newCustomer
        Staff staff = new Staff();
        staff.setId(Byte.parseByte("2"));

        Address address = new Address();
        address.setId(Short.parseShort("123"));

        Store store = new Store();
        store.setId(Byte.parseByte("2"));
        store.setStaff(staff);
        store.setAddress(address);

        newCustomer.setActive(true);
        newCustomer.setStore(store);
        newCustomer.setAddress(address);
        /////////////////////////////////////////////

        customerInteractor.save(newCustomer);
    }

    private void updateCustomer() {
        while (true) {
            customerPresenter.promptForCustomerId();
            Short idForUpdate = parseShortInput();
            Customer customerForUpdate = customerInteractor.findById(idForUpdate);
            if (customerForUpdate == null) {
                customerPresenter.customerNotFound();
                break;
            }
            customerPresenter.showCustomer(customerForUpdate);

            while (true) {
                customerPresenter.promptForUpdateOption();
                String input = TableController.getCommand();
                if (input.equals("3")) {
                    break;
                }
                switch (input) {
                    case "1":
                        System.out.println("Enter a new first name");
                        String updateFirstName = TableController.getCommand();
                        customerForUpdate.setFirstName(updateFirstName);
                        customerInteractor.update(customerForUpdate);
                        continue;
                    case "2":
                        System.out.println("Enter a new last name");
                        String updateLastName = TableController.getCommand();
                        customerForUpdate.setLastName(updateLastName);
                        customerInteractor.update(customerForUpdate);
                        continue;
                }
            }
            customerPresenter.promptUpdateNextCustomer();
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

    private void deleteCustomer() {
        customerPresenter.promptForCustomerId();
        Short idForDelete = parseShortInput();
        customerInteractor.delete(idForDelete);
    }

    private Short parseShortInput(){
        while (true){
            try{
                return Short.parseShort(TableController.getCommand());
            } catch (NumberFormatException e){
                customerPresenter.invalidInputMessage();
            }
        }
    }
}
