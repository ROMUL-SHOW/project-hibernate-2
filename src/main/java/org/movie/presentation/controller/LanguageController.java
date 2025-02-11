package org.movie.presentation.controller;

import org.movie.data.entity.Language;
import org.movie.domain.interactor.LanguageInteractor;
import org.movie.presentation.presenter.LanguagePresenter;

import java.util.List;

public class LanguageController implements Controller{
    private final LanguageInteractor languageInteractor;
    private final Controller controller;
    private final LanguagePresenter languagePresenter;
    private boolean isRunning = true;

    public LanguageController(LanguageInteractor languageInteractor, Controller controller, LanguagePresenter languagePresenter) {
        this.languageInteractor = languageInteractor;
        this.controller = controller;
        this.languagePresenter = languagePresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            languagePresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<Language> languages = languageInteractor.findAll();
                    languagePresenter.showLanguages(languages);
                    break;
                case "2":
                    this.findLanguage();
                    break;
                case "3":
                    this.saveLanguage();
                    break;
                case "4":
                    this.updateLanguage();
                    break;
                case "5":
                    this.deleteLanguage();
                    break;
                case "6":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findLanguage() {
        while (true) {
            languagePresenter.promptForLanguageId();
            Byte idForSearch = parseByteInput();
            Language language = languageInteractor.findById(idForSearch);
            if (language != null) {
                languagePresenter.showLanguage(language);
            } else {
                languagePresenter.languageNotFound();
            }
            languagePresenter.promptShowNextLanguage();
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

    private void saveLanguage() {
        languagePresenter.promptForLanguageName();
        String name = TableController.getCommand();
        Language newLanguage = new Language();
        newLanguage.setName(name);
        languageInteractor.save(newLanguage);
    }

    private void updateLanguage() {
        while (true) {
            languagePresenter.promptForLanguageId();
            Byte idForUpdate = parseByteInput();
            Language languageForUpdate = languageInteractor.findById(idForUpdate);
            if (languageForUpdate == null) {
                languagePresenter.languageNotFound();
                break;
            }
            languagePresenter.showLanguage(languageForUpdate);

            while (true) {
                languagePresenter.promptForUpdateOption();
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
                    languageForUpdate.setName(name);
                    languageInteractor.update(languageForUpdate);
                    break;
                }
            }
            languagePresenter.promptUpdateNextLanguage();
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

    private void deleteLanguage() {
        languagePresenter.promptForLanguageId();
        Byte idForDelete = parseByteInput();
        languageInteractor.delete(idForDelete);
    }

    private Byte parseByteInput(){
        while (true){
            try{
                return Byte.parseByte(TableController.getCommand());
            } catch (NumberFormatException e){
                languagePresenter.invalidInputMessage();
            }
        }
    }
}
