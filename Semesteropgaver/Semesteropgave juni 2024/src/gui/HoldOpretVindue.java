package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HoldOpretVindue extends Stage {

    public HoldOpretVindue(String title,Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final TextField txfNavn = new TextField();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNavn = new Label("Hold navn:");
        pane.add(lblNavn, 0, 0);

        txfNavn.setPrefWidth(300);
        pane.add(txfNavn, 0, 1);

        HBox btnBox = new HBox();
        btnBox.setSpacing(10);
        pane.add(btnBox, 0, 2);

        Button btnOpret = new Button("Opret hold");

        btnOpret.setOnAction(event -> opretAction());

        Button btnAnnuller = new Button("Annuller");

        btnBox.getChildren().addAll(btnOpret, btnAnnuller);

        btnAnnuller.setOnAction(event -> annullerAction());
    }

    // ========== btn actions ==========

    private void opretAction() {
        String navn = txfNavn.getText().trim();

        if (!navn.isBlank()) {
            Controller.createHold(navn);
            HoldOpretVindue.this.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Indtast venligst et hold navn!");
            alert.show();
        }
    }

    private void annullerAction() {
        HoldOpretVindue.this.hide();
    }
}