package org.movie.presentation.controller;

import org.movie.data.entity.FilmText;
import org.movie.domain.interactor.FilmTextInteractor;
import org.movie.presentation.presenter.FilmTextPresenter;

import java.util.List;

public class FilmTextController implements Controller {
    private final FilmTextInteractor filmTextInteractor;
    private final Controller controller;
    private final FilmTextPresenter filmTextPresenter;
    private boolean isRunning = true;

    public FilmTextController(FilmTextInteractor filmTextInteractor, Controller controller, FilmTextPresenter filmTextPresenter) {
        this.filmTextInteractor = filmTextInteractor;
        this.controller = controller;
        this.filmTextPresenter = filmTextPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            filmTextPresenter.showMenu();
            switch (TableController.getCommand()) {
                case "1":
                    List<FilmText> filmsTexts = filmTextInteractor.findAll();
                    filmTextPresenter.showFilmTexts(filmsTexts);
                    break;
                case "2":
                    findFilmText();
                    break;
                case "3":
                    controller.start();
                    break;
            }
        }
    }

    private void findFilmText() {
        while (true) {
            filmTextPresenter.promptForFilmTextId();
            Short idForSearch = parseShortInput();
            FilmText filmText = filmTextInteractor.findById(idForSearch);
            if (filmText != null) {
                filmTextPresenter.showFilmText(filmText);
                filmTextPresenter.promptShowDescription(filmText.getTitle());
                while (true) {
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        filmTextPresenter.showDescription(filmText.getDescription());
                        break;
                    }
                    if (input.equals("2")) {
                        break;
                    }
                }
            } else {
                filmTextPresenter.filmTextNotFound();
            }
            filmTextPresenter.promptShowNextFilmText();
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

    private Short parseShortInput(){
        while (true){
            try{
                return Short.parseShort(TableController.getCommand());
            } catch (NumberFormatException e){
                filmTextPresenter.invalidInputMessage();
            }
        }
    }
}
