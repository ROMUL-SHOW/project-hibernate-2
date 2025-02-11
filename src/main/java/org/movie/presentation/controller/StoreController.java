package org.movie.presentation.controller;

import org.movie.data.entity.*;
import org.movie.data.entity.Store;
import org.movie.domain.interactor.StoreInteractor;
import org.movie.presentation.presenter.StorePresenter;

import java.util.List;

public class StoreController implements Controller {
    private final StoreInteractor storeInteractor;
    private final Controller controller;
    private final StorePresenter storePresenter;
    private boolean isRunning = true;


    public StoreController(StoreInteractor storeInteractor, Controller controller, StorePresenter storePresenter) {
        this.storeInteractor = storeInteractor;
        this.controller = controller;
        this.storePresenter = storePresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            storePresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<Store> stores = storeInteractor.findAll();
                    storePresenter.showStores(stores);
                    break;
                case "2":
                    this.findStore();
                    break;
                case "3":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findStore() {
        while (true) {
            storePresenter.promptForStoreId();
            Byte idForSearch = parseByteInput();
            Store store = storeInteractor.findById(idForSearch);

            if (store != null) {
                storePresenter.showStore(store);
                while (true) {
                    storePresenter.promptShowProperties();
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Staff staff = store.getStaff();
                        storePresenter.showStaff(staff);
                        continue;
                    }
                    if (input.equals("2")) {
                        Address address = store.getAddress();
                        storePresenter.showAddress(address);
                        continue;
                    }
                    if (input.equals("3")) {
                        break;
                    }
                }
            } else {
                storePresenter.storeNotFound();
            }
            storePresenter.promptShowNextStore();
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

    private Byte parseByteInput(){
        while (true){
            try{
                return Byte.parseByte(TableController.getCommand());
            } catch (NumberFormatException e){
                storePresenter.invalidInputMessage();
            }
        }
    }
}
