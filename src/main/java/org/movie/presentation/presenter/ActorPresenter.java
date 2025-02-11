package org.movie.presentation.presenter;

import org.movie.data.entity.Actor;

import java.util.List;

public class ActorPresenter {
    private final static String MENU = "\nSelect action number:" +
            "\n1. Find all actors" +
            "\n2. Find actor" +
            "\n3. Save actor" +
            "\n4. Update actor" +
            "\n5. Delete actor" +
            "\n6. Return to main menu" +
            "\n\n0. Exit\n";
    private final static String SEARCH_MENU = "1. Find actor by ID\n2. Find actor by full name\n\n3.Back to actor menu";
    private final static String UPDATE_MENU = "\nSelect the field number for update:\n1. First name\n2. Last name\n3. Finish the update";
    private final static String FIND_NEXT_ACTOR_MENU = "\nFind next actor?\n1. Yes\n2. No, back to actor menu\n\n0. Exit";
    private final static String FIND_NEXT_UPDATE_MENU = "\nFind next actor for update?\n1. Yes\n2. No, back to actor menu\n\n0. Exit";

    public void showMenu() {
        System.out.println(MENU);
    }

    public void showActors(List<Actor> actors) {
        if (actors.isEmpty()) {
            System.out.println("No actors found");
        } else {
            actors.forEach(System.out::println);
        }
    }

    public void showActor(Actor actor) {
        System.out.println(actor);
    }

    public void promptForActorId() {
        System.out.println("\nEnter actor id");
    }

    public void promptForActorFirstName() {
        System.out.println("\nEnter first name");
    }

    public void promptForActorLastName() {
        System.out.println("Enter last name");
    }

    public void actorNotFound() {
        System.out.println("🙁 Actor not found");
    }

    public void promptShowFilms(String firstName, String lastName) {
        System.out.println("\nShow all movies with " + firstName + " " + lastName + "?\n1. Yes\n2. No");
    }

    public void promptForSearchOption() {

        System.out.println(SEARCH_MENU);
    }

    public void promptShowNextActor() {
        System.out.println(FIND_NEXT_ACTOR_MENU);
    }

    public void promptForUpdateOption() {
        System.out.println(UPDATE_MENU);
    }

    public void promptUpdateNextActor() {
        System.out.println(FIND_NEXT_UPDATE_MENU);
    }

    public void invalidInputMessage() {
        System.out.println("❌ Invalid input. Please enter a valid number.");
    }
}
