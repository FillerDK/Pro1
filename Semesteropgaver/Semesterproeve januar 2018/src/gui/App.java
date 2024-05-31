package gui;

import javafx.application.Application;
import model.Uddannelse;
import service.Service;
import storage.Storage;

public class App {
    public static void main(String[] args) {
        Service.initStorage();
        System.out.println(Service.holdUdenTutorer());
        System.out.println(Storage.getUddannelser().getFirst().tutorOversigt());
        Service.tutorOversigtTilFil("Oversigten");
        Application.launch(Gui.class);
    }
}
