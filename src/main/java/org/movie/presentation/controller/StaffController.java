package org.movie.presentation.controller;

import org.movie.data.entity.Address;
import org.movie.data.entity.Staff;
import org.movie.data.entity.Store;
import org.movie.domain.interactor.StaffInteractor;
import org.movie.presentation.presenter.StaffPresenter;

import java.util.List;

public class StaffController implements Controller {
    private final StaffInteractor staffInteractor;
    private final Controller controller;
    private final StaffPresenter staffPresenter;
    private boolean isRunning = true;

    public StaffController(StaffInteractor staffInteractor, Controller controller, StaffPresenter staffPresenter) {
        this.staffInteractor = staffInteractor;
        this.controller = controller;
        this.staffPresenter = staffPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            staffPresenter.showMenu();
            switch (TableController.getCommand()) {
                case "1":
                    List<Staff> staffers = staffInteractor.findAll();
                    staffPresenter.showStaff(staffers);
                    break;
                case "2":
                    findStaffer();
                    break;
                case "3":
                    saveStaffer();
                    break;
                case "4":
                    updateStaffer();
                    break;
                case "5":
                    deleteStaffer();
                    break;
                case "6":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findStaffer() {
        while (true) {
            staffPresenter.promptForStaffId();
            Byte idForSearch = parseByteInput();
            Staff staffer = staffInteractor.findById(idForSearch);
            if (staffer != null) {
                staffPresenter.showStaff(staffer);
                staffPresenter.promptShowAddress(staffer.getFirstName(), staffer.getLastName());
                while (true) {
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Address address = staffer.getAddress();
                        System.out.println(address.getAddress() + " " + address.getAddress2() + " " + address.getDistrict());
                        break;
                    }
                    if (input.equals("2")) {
                        break;
                    }
                }
            } else {
                staffPresenter.stafferNotFound();
            }
            staffPresenter.promptShowNextStaff();
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

    private void updateStaffer() {
        while (true) {
            staffPresenter.promptForStaffId();
            Byte idForUpdate = parseByteInput();
            Staff stafferForUpdate = staffInteractor.findById(idForUpdate);
            if (stafferForUpdate == null) {
                staffPresenter.stafferNotFound();
                break;
            }
            staffPresenter.showStaff(stafferForUpdate);

            while (true) {
                staffPresenter.promptForUpdateOption();
                String input = TableController.getCommand();
                if (input.equals("3")) {
                    break;
                }
                switch (input) {
                    case "1":
                        System.out.println("Enter a new first name");
                        String updateFirstName = TableController.getCommand();
                        stafferForUpdate.setFirstName(updateFirstName);
                        staffInteractor.update(stafferForUpdate);
                        continue;
                    case "2":
                        System.out.println("Enter a new last name");
                        String updateLastName = TableController.getCommand();
                        stafferForUpdate.setLastName(updateLastName);
                        staffInteractor.update(stafferForUpdate);
                        continue;
                }
            }
            staffPresenter.promptUpdateNextStaffer();
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

    private void saveStaffer() {
        staffPresenter.promptForStafferFirstName();
        String firstName = TableController.getCommand();
        staffPresenter.promptForStafferLastName();
        String lastName = TableController.getCommand();
        staffPresenter.promptForStafferUserName();
        String userName = TableController.getCommand();
        Staff newStaffer = new Staff();
        newStaffer.setFirstName(firstName);
        newStaffer.setLastName(lastName);
        newStaffer.setUsername(userName);
        newStaffer.setActive(false);

        Address address = new Address();
        address.setId(Short.parseShort("2"));
        Store store = new Store();
        store.setId(Byte.parseByte("2"));

        newStaffer.setAddress(address);
        newStaffer.setStore(store);

        staffInteractor.save(newStaffer);
    }

    private void deleteStaffer() {
        staffPresenter.promptForStaffId();
        Byte idForDelete = parseByteInput();
        staffInteractor.delete(idForDelete);
    }

    private Byte parseByteInput(){
        while (true){
            try{
                return Byte.parseByte(TableController.getCommand());
            } catch (NumberFormatException e){
                staffPresenter.invalidInputMessage();
            }
        }
    }
}
