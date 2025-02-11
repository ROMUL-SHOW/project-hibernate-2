package org.movie.presentation.presenter;

import org.movie.data.entity.City;
import org.movie.data.entity.Country;

import java.util.List;

public class CityPresenter {
    private final static String MENU = "\nSelect action number:\n1. Find all cities\n2. Find city by ID\n3. Save city\n4. Update city\n5. Delete city\n6. Return to main menu\n\n0. Exit\n";
    private final static String UPDATE_MENU = "\nUpdate name this city?\n1. Yes\n2. No";
    private final static String FIND_NEXT_CITY_MENU = "\nFind next city?\n1. Yes\n2. No, back to city menu\n\n0. Exit";
    private final static String FIND_NEXT_UPDATE_MENU = "\nFind next city for update?\n1. Yes\n2. No, back to city menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showCities(List<City> cities){
        if(cities.isEmpty()){
            System.out.println("🙁 No cities found");
        } else {
            cities.forEach(System.out::println);
        }
    }

    public void showCity(City city) {
        System.out.println(city);
    }

    public void promptForCityId(){
        System.out.println("\nEnter city id");
    }

    public void promptForCityName(){
        System.out.println("\nEnter city name");
    }

    public void cityNotFound(){
        System.out.println("🙁 City not found");
    }

    public void promptShowCountry(String cityName){
        System.out.println("\nShow country of " + cityName + "?\n1. Yes\n2. No");
    }

    public void showCountry(Country country){
        System.out.println(country);
    }

    public void promptShowNextCity() {
        System.out.println(FIND_NEXT_CITY_MENU);
    }

    public void promptForUpdateOption() {
        System.out.println(UPDATE_MENU);
    }

    public void promptUpdateNextCity() {
        System.out.println(FIND_NEXT_UPDATE_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
