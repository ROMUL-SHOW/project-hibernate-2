package org.movie.presentation.presenter;

import org.movie.data.entity.Language;

import java.util.List;

public class LanguagePresenter {

    private final static String MENU = "\nSelect action number:\n1. Find all languages\n2. Find language by ID\n3. Save language\n4. Update language\n5. Delete language\n6. Return to main menu\n\n0. Exit\n";
    private final static String UPDATE_MENU = "\nUpdate name this language?\n1. Yes\n2. No";
    private final static String FIND_NEXT_LANGUAGE_MENU = "\nFind next language?\n1. Yes\n2. No, back to language menu\n\n0. Exit";
    private final static String FIND_NEXT_UPDATE_MENU = "\nFind next language for update?\n1. Yes\n2. No, back to language menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showLanguages(List<Language> languages){
        if(languages.isEmpty()){
            System.out.println("🙁 No languages found");
        } else {
            languages.forEach(System.out::println);
        }
    }

    public void showLanguage(Language language) {
        System.out.println(language);
    }

    public void promptForLanguageId(){
        System.out.println("\nEnter language id");
    }

    public void promptForLanguageName(){
        System.out.println("\nEnter language name");
    }

    public void languageNotFound(){
        System.out.println("🙁 Language not found");
    }

    public void promptShowNextLanguage() {
        System.out.println(FIND_NEXT_LANGUAGE_MENU);
    }

    public void promptForUpdateOption() {
        System.out.println(UPDATE_MENU);
    }

    public void promptUpdateNextLanguage() {
        System.out.println(FIND_NEXT_UPDATE_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
