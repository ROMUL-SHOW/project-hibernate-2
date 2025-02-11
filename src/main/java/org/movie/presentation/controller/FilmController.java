package org.movie.presentation.controller;

import org.movie.data.entity.Film;
import org.movie.domain.interactor.FilmInteractor;
import org.movie.presentation.presenter.FilmPresenter;

import java.util.List;

public class FilmController implements Controller {
    private final FilmInteractor filmInteractor;
    private final Controller controller;
    private final FilmPresenter filmPresenter;
    private boolean isRunning = true;

    public FilmController(FilmInteractor filmInteractor, Controller controller, FilmPresenter filmPresenter) {
        this.filmInteractor = filmInteractor;
        this.controller = controller;
        this.filmPresenter = filmPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            filmPresenter.showMenu();
            switch (TableController.getCommand()) {
                case "1":
                    List<Film> films = filmInteractor.findAll();
                    filmPresenter.showFilms(films);
                    break;
                case "2":
                    findFilm();
                    break;
                case "3":
                    controller.start();
                    break;
            }
        }
    }

    private void findFilm() {
        while (true) {
            filmPresenter.promptForFilmId();
            Short idForSearch = parseShortInput();
            Film film = filmInteractor.findById(idForSearch);
            if (film != null) {
                filmPresenter.showFilm(film);
                filmPresenter.promptShowActors(film.getTitle());
                while (true) {
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        filmPresenter.showActors(film);
                        break;
                    }
                    if (input.equals("2")) {
                        break;
                    }
                }
            } else {
                filmPresenter.filmNotFound();
            }
            filmPresenter.promptShowNextFilm();
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
                filmPresenter.invalidInputMessage();
            }
        }
    }
}
