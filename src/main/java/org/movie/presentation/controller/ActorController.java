package org.movie.presentation.controller;

import org.movie.data.entity.Actor;
import org.movie.data.entity.Film;
import org.movie.domain.interactor.ActorInteractor;
import java.util.List;
import java.util.Set;

public class ActorController {
    private final ActorInteractor actorInteractor;
    private final static String menu = "\nSelect action number:\n1. Find all actors\n2. Find actor by ID\n3. Save actor\n4. Update actor\n5. Delete actor\n6. Return to main menu\n\n0. Exit\n";

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
                    while (true) {
                        System.out.println("\nEnter actor id");
                        Short idForSearch = Short.parseShort(TableController.getCommand());
                        Actor actor = actorInteractor.findById(idForSearch);
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
                    break;
                case "3":
                    System.out.println("\nEnter first name");
                    String firstName = TableController.getCommand();
                    System.out.println("Enter last name");
                    String lastName = TableController.getCommand();
                    Actor newActor = new Actor();
                    newActor.setFirstName(firstName);
                    newActor.setLastName(lastName);
                    actorInteractor.save(newActor);
                    break;
                case "4":
                    System.out.println("\nEnter actor id");
                    Short idForUpdate = Short.parseShort(TableController.getCommand());
                    Actor actorForUpdate = actorInteractor.findById(idForUpdate);
                    if (actorForUpdate == null) {
                        System.out.println("Actor not found");
                        break;
                    }
                    System.out.println(actorForUpdate);
                    System.out.println("\nSelect the field number for update:\n1. First name\n2. Last name");
                    switch (TableController.getCommand()) {
                        case "1":
                            System.out.println("Enter a new first name");
                            String updateFirstName = TableController.getCommand();
                            actorForUpdate.setFirstName(updateFirstName);
                            actorInteractor.update(actorForUpdate);
                            break;
                        case "2":
                            System.out.println("Enter a new last name");
                            String updateLastName = TableController.getCommand();
                            actorForUpdate.setLastName(updateLastName);
                            actorInteractor.update(actorForUpdate);
                            break;
                        default:
                            break;
                    }
                    break;
                case "5":
                    System.out.println("Enter actor id");
                    Short idForDelete = Short.parseShort(TableController.getCommand());
                    actorInteractor.delete(idForDelete);
                    break;
                case "6":
                    System.out.println();
                    TableController tableController = new TableController();
                    tableController.start();
                    break;
            }
        }
    }
}
