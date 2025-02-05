package org.movie.presentation.controller;

import org.movie.data.entity.Actor;
import org.movie.data.entity.Film;
import org.movie.domain.interactor.FilmInteractor;

import java.util.List;
import java.util.Set;

public class FilmController {
    private FilmInteractor filmInteractor;
    private final static String menu = "\nSelect action number:\n1. Find all films\n2. Find film by ID\n3. Return to main menu\n\n0. Exit\n";

    public FilmController(FilmInteractor filmInteractor) {
        this.filmInteractor = filmInteractor;
    }

    public void start() {
        while (true) {
            System.out.println(menu);
            switch (TableController.getCommand()) {
                case "1":
                    List<Film> films = filmInteractor.findAll();
                    films.forEach(System.out::println);
                    break;
                case "2":
                    findFilm();
                    break;
                case "3":
                    System.out.println();
                    TableController tableController = new TableController();
                    tableController.start();
                    break;
            }
        }
    }
    private void findFilm(){
        while (true) {
            System.out.println("\nEnter film id");
            Short idForSearch = parseShortInput();
            Film film = filmInteractor.findById(idForSearch);
            if (film != null) {
                System.out.println(film);
                System.out.println("\nShow all the actors from \"" + film.getTitle() + "\"?\n1. Yes\n2. No");
                while (true) {
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Set<Actor> actors = film.getActors();
                        actors.stream()
                                .map(actor -> actor.getFirstName() + " " + actor.getLastName())
                                .forEach(System.out::println);
                        break;
                    }
                    if (input.equals("2")) {
                        break;
                    }
                }
            } else {
                System.out.println("\nFilm not found");
            }
            System.out.println("\nFind next film?\n1. Yes\n2. No, back to film menu\n\n0. Exit");
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
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
