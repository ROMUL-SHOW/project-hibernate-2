package org.movie.presentation.presenter;

import org.movie.data.entity.FilmText;

import java.util.List;

public class FilmTextPresenter {
    private final String MENU = "\nSelect action number:\n1. Find all filmTexts\n2. Find filmText by ID\n3. Return to main menu\n\n0. Exit\n";
    private final static String FIND_NEXT_FILM_TEXT_MENU = "\nFind next filmText?\n1. Yes\n2. No, back to filmText menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showFilmTexts(List<FilmText> filmTexts){
        if(filmTexts.isEmpty()){
            System.out.println("🙁 No filmTexts found");
        } else {
            filmTexts.forEach(System.out::println);
        }
    }

    public void showFilmText(FilmText filmText) {
        System.out.println(filmText.getTitle());
    }

    public void showDescription(String description) {
        System.out.println(description);
    }

    public void promptForFilmTextId(){
        System.out.println("\nEnter filmText id");
    }

    public void filmTextNotFound(){
        System.out.println("🙁 Film not found");
    }

    public void promptShowDescription(String filmTitle){
        System.out.println("\nShow description of \"" + filmTitle + "\"?\n1. Yes\n2. No");
    }

    public void promptShowNextFilmText(){
        System.out.println(FIND_NEXT_FILM_TEXT_MENU);
    }
    public void invalidInputMessage(){
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
