package org.movie.presentation.presenter;


import org.movie.data.entity.Country;

import java.util.List;

public class CountryPresenter {

    private final static String MENU = "\nSelect action number:\n1. Find all countries\n2. Find country by ID\n3. Save country\n4. Update country\n5. Delete country\n6. Return to main menu\n\n0. Exit\n";
    private final static String UPDATE_MENU = "\nUpdate name this country?\n1. Yes\n2. No";
    private final static String FIND_NEXT_COUNTRY_MENU = "\nFind next country?\n1. Yes\n2. No, back to country menu\n\n0. Exit";
    private final static String FIND_NEXT_UPDATE_MENU = "\nFind next country for update?\n1. Yes\n2. No, back to country menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showCountries(List<Country> countries){
        if(countries.isEmpty()){
            System.out.println("🙁 No countries found");
        } else {
            countries.forEach(System.out::println);
        }
    }

    public void showCountry(Country country) {
        System.out.println(country);
    }

    public void promptForCountryName() {
        System.out.println("\nEnter country name");
    }

    public void promptForCountryId(){
        System.out.println("\nEnter country id");
    }

    public void countryNotFound(){
        System.out.println("🙁 Country not found");
    }

    public void promptShowNextCountry() {
        System.out.println(FIND_NEXT_COUNTRY_MENU);
    }

    public void promptForUpdateOption() {
        System.out.println(UPDATE_MENU);
    }

    public void promptUpdateNextCountry() {
        System.out.println(FIND_NEXT_UPDATE_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }

}
