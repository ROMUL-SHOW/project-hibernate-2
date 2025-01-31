package org.movie.presentation.controller;

import org.movie.presentation.provider.ActorInteractorProvider;
import org.movie.presentation.provider.FilmInteractorProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TableController {
    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        while (true) {
            System.out.println("Select table number:\n1. Films\n2. Actors\n\n0. Exit\n");
            switch (getCommand()) {
                case "1":
                    FilmInteractorProvider filmInteractorProvider = new FilmInteractorProvider();
                    FilmController filmController = new FilmController(filmInteractorProvider.provide());
                    filmController.start();
                    break;
                case "2":
                    ActorInteractorProvider actorInteractorProvider = new ActorInteractorProvider();
                    ActorController actorController = new ActorController(actorInteractorProvider.provide());
                    actorController.start();
                    break;
                default:
                    break;
            }
        }
    }

    public static String getCommand() {
        String command = null;
        try {
            command = reader.readLine();
            if (command.equals("0")) {
                reader.close();
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return command;
    }
}
