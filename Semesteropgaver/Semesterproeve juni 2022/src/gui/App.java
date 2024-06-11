package gui;

import controller.Controller;
import javafx.application.Application;
import storage.Storage;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        Application.launch(Gui.class);
    }
}
