package org.movie.presentation.controller;

import org.movie.data.entity.*;
import org.movie.domain.interactor.PaymentInteractor;
import org.movie.presentation.presenter.PaymentPresenter;

import java.util.List;

public class PaymentController implements Controller {
    private final PaymentInteractor paymentInteractor;
    private final Controller controller;
    private final PaymentPresenter paymentPresenter;
    private boolean isRunning = true;


    public PaymentController(PaymentInteractor paymentInteractor, Controller controller, PaymentPresenter paymentPresenter) {
        this.paymentInteractor = paymentInteractor;
        this.controller = controller;
        this.paymentPresenter = paymentPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            paymentPresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<Payment> payments = paymentInteractor.findAll();
                    paymentPresenter.showPayments(payments);
                    break;
                case "2":
                    this.findPayment();
                    break;
                case "3":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findPayment() {
        while (true) {
            paymentPresenter.promptForPaymentId();
            Short idForSearch = parseShortInput();
            Payment payment = paymentInteractor.findById(idForSearch);

            if (payment != null) {
                paymentPresenter.showPayment(payment);
                while (true) {
                    paymentPresenter.promptShowProperties();
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Staff staff = payment.getStaff();
                        paymentPresenter.showStaff(staff);
                        continue;
                    }
                    if (input.equals("2")) {
                        Customer customer = payment.getCustomer();
                        paymentPresenter.showCustomer(customer);
                        continue;
                    }
                    if (input.equals("3")) {
                        Rental rental = payment.getRental();
                        paymentPresenter.showRental(rental);
                        continue;
                    }
                    if (input.equals("4")) {
                        break;
                    }
                }
            } else {
                paymentPresenter.paymentNotFound();
            }
            paymentPresenter.promptShowNextPayment();
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

    private Short parseShortInput() {
        while (true) {
            try {
                return Short.parseShort(TableController.getCommand());
            } catch (NumberFormatException e) {
                paymentPresenter.invalidInputMessage();
            }
        }
    }
}
