package org.movie.presentation.controller;

import org.movie.data.entity.Actor;
import org.movie.data.entity.Film;
import org.movie.domain.interactor.ActorInteractor;

import java.util.List;
import java.util.Set;

public class ActorController {
    private final ActorInteractor actorInteractor;

    private final static String menu = "\nSelect action number:\n1. Find all actors\n2. Find actor\n3. Save actor\n4. Update actor\n5. Delete actor\n6. Return to main menu\n\n0. Exit\n";

    public ActorController(ActorInteractor actorInteractor) {
        this.actorInteractor = actorInteractor;
    }

    public void start() {
        while (true) {
            System.out.println(menu);

            switch (TableController.getCommand()) {
                case "1":
                    List<Actor> actors = actorInteractor.findAll();
                    actors.forEach(System.out::println);
                    break;
                case "2":
                    this.findActor();
                    break;
                case "3":
                    this.saveActor();
                    break;
                case "4":
                    this.updateActor();
                    break;
                case "5":
                    this.deleteActor();
                    break;
                case "6":
                    System.out.println();
                    TableController tableController = new TableController();
                    tableController.start();
                    break;
            }
        }
    }

    private void findActor() {
        while (true) {
            String searchMenu = "1. Find actor by ID\n2. Find actor by full name\n\n3.Back to actor menu";
            System.out.println(searchMenu);
            String command = TableController.getCommand();
            if (command.equals("3")) {
                return;
            }
            Actor actor = null;
            switch (command) {
                case "1":
                    System.out.println("\nEnter actor id");
                    Short idForSearch = parseShortInput();
                    actor = actorInteractor.findById(idForSearch);
                    break;
                case "2":
                    System.out.println("\nEnter first name");
                    String firstName = TableController.getCommand();
                    System.out.println("Enter last name");
                    String lastName = TableController.getCommand();
                    actor = actorInteractor.findByFullName(firstName, lastName);
                    break;
                default:
                    continue;
            }
            if (actor != null) {
                System.out.println(actor);
                System.out.println("\nShow all movies with " + actor.getFirstName() + " " + actor.getLastName() + "?\n1. Yes\n2. No");
                while (true) {
                    String input = TableController.getCommand();
                    if (input.equals("1")) {
                        Set<Film> films = actor.getFilms();
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
                System.out.println("\nActor not found");
            }
            System.out.println("\nFind next actor?\n1. Yes\n2. No, back to actor menu\n\n0. Exit");
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

    private void saveActor() {
        System.out.println("\nEnter first name");
        String firstName = TableController.getCommand();
        System.out.println("Enter last name");
        String lastName = TableController.getCommand();
        Actor newActor = new Actor();
        newActor.setFirstName(firstName);
        newActor.setLastName(lastName);
        actorInteractor.save(newActor);
    }

    private void updateActor() {
        while (true) {
            System.out.println("\nEnter actor id");
            Short idForUpdate = parseShortInput();
            Actor actorForUpdate = actorInteractor.findById(idForUpdate);
            if (actorForUpdate == null) {
                System.out.println("Actor not found");
                break;
            }
            System.out.println(actorForUpdate);
            while (true) {
                System.out.println("\nSelect the field number for update:\n1. First name\n2. Last name\n3. Finish the update");
                String input = TableController.getCommand();
                if (input.equals("3")) {
                    break;
                }
                switch (input) {
                    case "1":
                        System.out.println("Enter a new first name");
                        String updateFirstName = TableController.getCommand();
                        actorForUpdate.setFirstName(updateFirstName);
                        actorInteractor.update(actorForUpdate);
                        continue;
                    case "2":
                        System.out.println("Enter a new last name");
                        String updateLastName = TableController.getCommand();
                        actorForUpdate.setLastName(updateLastName);
                        actorInteractor.update(actorForUpdate);
                        continue;
                }
            }
            System.out.println("\nFind next actor for update?\n1. Yes\n2. No, back to actor menu\n\n0. Exit");
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

    private void deleteActor() {
        System.out.println("Enter actor id");
        Short idForDelete = parseShortInput();
        actorInteractor.delete(idForDelete);
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
