package org.movie;

import org.movie.data.db.dao.ActorDAO;
import org.movie.data.db.dao.FilmDAO;
import org.movie.data.entity.Actor;
import org.movie.data.entity.Film;
import org.movie.presentation.controller.TableController;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TableController tableController = new TableController();
        tableController.start();

        // for tests
        //Film film = new FilmDAO().findById((short)2);
        //System.out.println("Film:\n" + film.getTitle() + " " + film.getRating() + " " + film.getSpecialFeatures());
        //Set<Actor> actors = film.getActors();
        //System.out.println("\nActors:");
        //actors.stream().map(actor -> actor.getFirstName() + " " + actor.getLastName()).forEach(System.out::println);

        //ActorDAO actorDAO = new ActorDAO();
        //Actor actor = actorDAO.findById((short) 4);
        //Set<Film> films = actor.getFilms();
        //System.out.println(actor);
        //System.out.println();
        //films.stream().map(film -> film.getTitle() + " - " + film.getRating()).forEach(System.out::println);
    }
}