package org.movie.presentation.controller;

import org.movie.data.entity.Address;
import org.movie.data.entity.Customer;
import org.movie.domain.interactor.CustomerInteractor;

import java.util.List;

public class CustomerController {
    private final CustomerInteractor customerInteractor;
    private final static String menu = "\nSelect customer number:\n1. Find all customers\n2. Find customer by ID\n3. Save customer\n4. Update customer\n5. Delete customer\n6. Return to main menu\n\n0. Exit\n";

    public CustomerController(CustomerInteractor customerInteractor) {
        this.customerInteractor = customerInteractor;
    }

    public void start() {
        while (true) {
            System.out.println(menu);
            switch (TableController.getCommand()) {
                case "1":
                    List<Customer> customers = customerInteractor.findAll();
                    customers.forEach(System.out::println);
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
                    System.out.println();
                    TableController tableController = new TableController();
                    tableController.start();
                    break;
            }
        }
    }

    private void findCustomer() {
        while (true) {
            System.out.println("\nEnter customer id");
            Short idForSearch = parseShortInput();
            Customer customer = customerInteractor.findById(idForSearch);
            if (customer != null) {
                System.out.println(customer);
                System.out.println("\nShow  " + customer.getFirstName() + " " + customer.getLastName() + "'s address?\n1. Yes\n2. No");
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
                System.out.println("\nCustomer not found");
            }
            System.out.println("\nFind next customer?\n1. Yes\n2. No, back to customer menu\n\n0. Exit");
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
        System.out.println("\nEnter first name");
        String firstName = TableController.getCommand();
        System.out.println("Enter last name");
        String lastName = TableController.getCommand();
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);
        customerInteractor.save(newCustomer);
    }

    private void updateCustomer() {
        while (true) {
            System.out.println("\nEnter customer id");
            Short idForUpdate = parseShortInput();
            Customer customerForUpdate = customerInteractor.findById(idForUpdate);
            if (customerForUpdate == null) {
                System.out.println("Customer not found");
                break;
            }
            System.out.println(customerForUpdate);

            while (true) {
                System.out.println("\nSelect the field number for update:\n1. First name\n2. Last name\n3. Finish the update");
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
            System.out.println("\nFind next customer for update?\n1. Yes\n2. No, back to customer menu\n\n0. Exit");
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
        System.out.println("Enter customer id");
        Short idForDelete = parseShortInput();
        customerInteractor.delete(idForDelete);
    }

    private Short parseShortInput(){
        while (true){
            try{
                return Short.parseShort(TableController.getCommand());
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
