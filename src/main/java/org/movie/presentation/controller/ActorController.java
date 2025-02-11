package org.movie.presentation.controller;

import org.movie.data.entity.Actor;
import org.movie.data.entity.Film;
import org.movie.domain.interactor.ActorInteractor;
import org.movie.presentation.presenter.ActorPresenter;

import java.util.List;
import java.util.Set;

public class ActorController implements Controller {
    private final ActorInteractor actorInteractor;
    private final Controller controller;
    private final ActorPresenter actorPresenter;
    private boolean isRunning = true;

    public ActorController(ActorInteractor actorInteractor, Controller controller, ActorPresenter actorPresenter) {
        this.actorInteractor = actorInteractor;
        this.controller = controller;
        this.actorPresenter = actorPresenter;
    }

    @Override
    public void start() {
        while (isRunning) {
            actorPresenter.showMenu();

            switch (TableController.getCommand()) {
                case "1":
                    List<Actor> actors = actorInteractor.findAll();
                    actorPresenter.showActors(actors);
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
                    this.controller.start();
                    break;
            }
        }
    }

    private void findActor() {
        while (true) {
            actorPresenter.promptForSearchOption();
            String command = TableController.getCommand();
            if (command.equals("3")) {
                return;
            }
            Actor actor = null;
            switch (command) {
                case "1":
                    actorPresenter.promptForActorId();
                    Short idForSearch = parseShortInput();
                    actor = actorInteractor.findById(idForSearch);
                    break;
                case "2":
                    actorPresenter.promptForActorFirstName();
                    String firstName = TableController.getCommand();
                    actorPresenter.promptForActorLastName();
                    String lastName = TableController.getCommand();
                    actor = actorInteractor.findByFullName(firstName, lastName);
                    break;
                default:
                    continue;
            }
            if (actor != null) {
                actorPresenter.showActor(actor);
                actorPresenter.promptShowFilms(actor.getFirstName(), actor.getLastName());
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
                actorPresenter.actorNotFound();
            }
            actorPresenter.promptShowNextActor();
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
        actorPresenter.promptForActorFirstName();
        String firstName = TableController.getCommand();
        actorPresenter.promptForActorLastName();
        String lastName = TableController.getCommand();
        Actor newActor = new Actor();
        newActor.setFirstName(firstName);
        newActor.setLastName(lastName);
        actorInteractor.save(newActor);
    }

    private void updateActor() {
        while (true) {

            actorPresenter.promptForActorId();
            Short idForUpdate = parseShortInput();
            Actor actorForUpdate = actorInteractor.findById(idForUpdate);
            if (actorForUpdate == null) {
                actorPresenter.actorNotFound();
                break;
            }
            actorPresenter.showActor(actorForUpdate);

            while (true) {
                actorPresenter.promptForUpdateOption();
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
            actorPresenter.promptUpdateNextActor();
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
        actorPresenter.promptForActorId();
        Short idForDelete = parseShortInput();
        actorInteractor.delete(idForDelete);
    }

    private Short parseShortInput() {
        while (true) {
            try {
                return Short.parseShort(TableController.getCommand());
            } catch (NumberFormatException e) {
                actorPresenter.invalidInputMessage();
            }
        }
    }
}
