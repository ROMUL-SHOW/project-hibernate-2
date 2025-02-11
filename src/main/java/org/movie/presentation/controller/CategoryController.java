package org.movie.presentation.controller;

import org.movie.data.entity.Category;
import org.movie.data.entity.Film;
import org.movie.domain.interactor.CategoryInteractor;
import org.movie.presentation.presenter.CategoryPresenter;

import java.util.List;
import java.util.Set;

public class CategoryController implements Controller {
    private final CategoryInteractor categoryInteractor;
    private final Controller controller;
    private final CategoryPresenter categoryPresenter;
    private boolean isRunning = true;

    public CategoryController(CategoryInteractor categoryInteractor, Controller controller, CategoryPresenter categoryPresenter) {
        this.categoryInteractor = categoryInteractor;
        this.controller = controller;
        this.categoryPresenter = categoryPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            categoryPresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<Category> categories = categoryInteractor.findAll();
                    categoryPresenter.showCategories(categories);
                    break;
                case "2":
                    this.findCategory();
                    break;
                case "3":
                    this.saveCategory();
                    break;
                case "4":
                    this.updateCategory();
                    break;
                case "5":
                    this.deleteCategory();
                    break;
                case "6":
                    this.controller.start();
                    break;
            }
        }
    }

    private void findCategory() {
        while (true) {
            categoryPresenter.promptForCategoryId();
            Byte idForSearch = parseByteInput();
            Category category = categoryInteractor.findById(idForSearch);
            if (category != null) {
                categoryPresenter.showCategory(category);
                categoryPresenter.promptShowFilms(category.getName());
                while (true) {
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Set<Film> films = category.getFilms();
                        films.stream()
                                .map(Film::getTitle)
                                .forEach(System.out::println);
                        break;
                    }
                    if (input.equals("2")) {
                        break;
                    }
                }
            } else {
                categoryPresenter.categoryNotFound();
            }
            categoryPresenter.promptShowNextCategory();
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

    private void saveCategory() {
        categoryPresenter.promptForCategoryName();
        String name = TableController.getCommand();
        Category newCategory = new Category();
        newCategory.setName(name);
        categoryInteractor.save(newCategory);
    }


    private void updateCategory() {
        while (true) {
            categoryPresenter.promptForCategoryId();
            Byte idForUpdate = parseByteInput();
            Category categoryForUpdate = categoryInteractor.findById(idForUpdate);
            if (categoryForUpdate == null) {
                categoryPresenter.categoryNotFound();
                break;
            }
            categoryPresenter.showCategory(categoryForUpdate);

            while (true) {
                categoryPresenter.promptForUpdateOption();
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
                    categoryForUpdate.setName(name);
                    categoryInteractor.update(categoryForUpdate);
                    break;
                }
            }
            categoryPresenter.promptUpdateNextCategory();
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

    private void deleteCategory() {
        categoryPresenter.promptForCategoryId();
        Byte idForDelete = parseByteInput();
        categoryInteractor.delete(idForDelete);
    }


    private Byte parseByteInput(){
        while (true){
            try{
                return Byte.parseByte(TableController.getCommand());
            } catch (NumberFormatException e){
                categoryPresenter.invalidInputMessage();
            }
        }
    }
}
