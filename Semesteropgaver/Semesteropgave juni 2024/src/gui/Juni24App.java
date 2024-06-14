package gui;

import controller.Controller;
import javafx.application.Application;
import model.Badge;
import model.Deltager;
import model.Hold;
import model.Tur;
import storage.Storage;

import java.time.LocalDate;

public class Juni24App {
    public static void main(String[] args) {
        initStorage();
        Controller.udskrivDeltagerOversigt("test");
        Application.launch(Gui.class);
    }

    // section S3
    public static void initStorage() {
        // Hold
        Hold cyklisterne = Controller.createHold("Cyklisterne");
        Hold optimisterne = Controller.createHold("Optimisterne");

        // Deltagere
        Deltager ole = Controller.createDeltager("Ole", "12345678", cyklisterne);
        Deltager ib = Controller.createDeltager("Ib", "12341234", cyklisterne);
        Deltager pia = Controller.createDeltager("Pia", "12344321", cyklisterne);

        // Ture
        Tur ole1 = Controller.createTur(LocalDate.of(2024, 5, 15), 120, 30, ole);
        Tur ole2 = Controller.createTur(LocalDate.of(2024, 5, 16), 60, 15, ole);
        Tur ib1 = Controller.createTur(LocalDate.of(2024, 5, 16), 90, 25, ib);

        // Badges
        Badge dag25km = Controller.createBadge("25 km på én dag.");
        Badge dag2træk = Controller.createBadge("2 dage i træk.");
        Badge hentKollega = Controller.createBadge("Hent en kollega.");

        Controller.linkDeltagerTilBadge(ole, dag25km);
        Controller.linkDeltagerTilBadge(ib, dag25km);
        Controller.linkDeltagerTilBadge(ole, dag2træk);
    }
}
