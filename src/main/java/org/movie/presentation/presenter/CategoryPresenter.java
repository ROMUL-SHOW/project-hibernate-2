package org.movie.presentation.presenter;


import org.movie.data.entity.Category;

import java.util.List;

public class CategoryPresenter {

    private final static String MENU = "\nSelect action number:\n1. Find all categories\n2. Find category by ID\n3. Save category\n4. Update category\n5. Delete category\n6. Return to main menu\n\n0. Exit\n";
    private final static String UPDATE_MENU = "\nUpdate name this category?\n1. Yes\n2. No";
    private final static String FIND_NEXT_CATEGORY_MENU = "\nFind next category?\n1. Yes\n2. No, back to category menu\n\n0. Exit";
    private final static String FIND_NEXT_UPDATE_MENU = "\nFind next category for update?\n1. Yes\n2. No, back to category menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showCategories(List<Category> categories){
        if(categories.isEmpty()){
            System.out.println("🙁 No categories found");
        } else {
            categories.forEach(System.out::println);
        }
    }

    public void showCategory(Category category) {
        System.out.println(category);
    }

    public void promptForCategoryName() {
        System.out.println("\nEnter category name");
    }

    public void promptForCategoryId(){
        System.out.println("\nEnter category id");
    }

    public void categoryNotFound(){
        System.out.println("🙁 Category not found");
    }

    public void promptShowFilms(String categoryName) {
        System.out.println("\nShow all movies with " + categoryName + "?\n1. Yes\n2. No");
    }

    public void promptShowNextCategory() {
        System.out.println(FIND_NEXT_CATEGORY_MENU);
    }

    public void promptForUpdateOption() {
        System.out.println(UPDATE_MENU);
    }

    public void promptUpdateNextCategory() {
        System.out.println(FIND_NEXT_UPDATE_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }

}
