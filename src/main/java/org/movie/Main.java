package org.movie;

import org.movie.presentation.controller.TableController;


public class Main {
    public static void main(String[] args) {
        TableController tableController = new TableController();
        tableController.initComponents();
        tableController.start();
    }
}