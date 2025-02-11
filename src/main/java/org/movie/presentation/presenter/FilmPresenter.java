package org.movie.presentation.presenter;

import org.movie.data.entity.Actor;
import org.movie.data.entity.Film;

import java.util.List;
import java.util.Set;

public class FilmPresenter {
    private final String MENU = "\nSelect action number:\n1. Find all films\n2. Find film by ID\n3. Return to main menu\n\n0. Exit\n";
    private final static String FIND_NEXT_FILM_MENU = "\nFind next film?\n1. Yes\n2. No, back to film menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showFilms(List<Film> films){
        if(films.isEmpty()){
            System.out.println("🙁 No films found");
        } else {
            films.forEach(System.out::println);
        }
    }

    public void showFilm(Film film) {
        System.out.println(film);
    }

    public void showActors(Film film) {
        if(film.getActors().isEmpty()){
            System.out.println("🙁 No actors found");
        } else {
            Set<Actor> actors = film.getActors();
            actors.stream()
                    .map(actor -> actor.getFirstName() + " " + actor.getLastName())
                    .forEach(System.out::println);
        }
    }

    public void promptForFilmId(){
        System.out.println("\nEnter film id");
    }

    public void filmNotFound(){
        System.out.println("🙁 Film not found");
    }

    public void promptShowActors(String filmTitle){
        System.out.println("\nShow all the actors from \"" + filmTitle + "\"?\n1. Yes\n2. No");
    }

    public void promptShowNextFilm(){
        System.out.println(FIND_NEXT_FILM_MENU);
    }
    public void invalidInputMessage(){
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
