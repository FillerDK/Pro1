package gui;

import model.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import controller.Controller;

import java.time.LocalDate;
import java.util.ArrayList;

public class SeatPickerWindow extends Stage {
    Show show;
    LocalDate date;
    Costumer costumer;
    ArrayList<CheckBox> btns = new ArrayList<>();

    public SeatPickerWindow(String title, Show show, LocalDate date, Costumer costumer) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.show = show;
        this.date = date;
        this.costumer = costumer;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene seatPickScene = new Scene(pane);
        this.setScene(seatPickScene);
    }

    private GridPane seatsPane;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        // Creating GridPane
        seatsPane = new GridPane();
        seatsPane.setPadding(new Insets(10));


        // Adding buttons (seats)
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 20; j++) {
                CheckBox btn = new CheckBox();
                btn.setPrefWidth(20);
                btn.setPrefHeight(20);
                btn.setUserData(Controller.getSeats().get(((i - 1) * 20 + j) - 1));
                btns.add(btn);
                seatsPane.add(btn, j, i);
                if (j < 3 || j > 18) { // outer seats
                    if (i < 6) // green
                        if (Controller.isSeatAvailable(show, i, j, date))
                            btn.getStylesheets().add(getClass().getResource("buttonGreen.css").toExternalForm());
                        else {
                            btn.getStylesheets().add(getClass().getResource("buttonReserved.css").toExternalForm());
                            btn.setDisable(true);
                        }
                    else // blue
                        if (Controller.isSeatAvailable(show, i, j, date))
                            btn.getStylesheets().add(getClass().getResource("buttonBlue.css").toExternalForm());
                        else {
                            btn.getStylesheets().add(getClass().getResource("buttonReserved.css").toExternalForm());
                            btn.setDisable(true);
                        }
                } else { // inner seats
                    if (i < 6) // yellow
                        if (Controller.isSeatAvailable(show, i, j, date))
                            btn.getStylesheets().add(getClass().getResource("buttonYellow.css").toExternalForm());
                        else {
                            btn.getStylesheets().add(getClass().getResource("buttonReserved.css").toExternalForm());
                            btn.setDisable(true);
                        }
                    else if (i < 11) // green
                        if (Controller.isSeatAvailable(show, i, j, date))
                            btn.getStylesheets().add(getClass().getResource("buttonGreen.css").toExternalForm());
                        else {
                            btn.getStylesheets().add(getClass().getResource("buttonReserved.css").toExternalForm());
                            btn.setDisable(true);
                        }
                    else // blue
                        if (Controller.isSeatAvailable(show, i, j, date))
                            btn.getStylesheets().add(getClass().getResource("buttonBlue.css").toExternalForm());
                        else {
                            btn.getStylesheets().add(getClass().getResource("buttonReserved.css").toExternalForm());
                            btn.setDisable(true);
                        }

                    if (i == 10)
                        if (7 < j && j < 13) {
                            if (Controller.isSeatAvailable(show, i, j, date))
                                btn.getStylesheets().add(getClass().getResource("buttonWheelChair.css").toExternalForm());
                            else {
                                btn.getStylesheets().add(getClass().getResource("buttonReserved.css").toExternalForm());
                                btn.setDisable(true);
                            }
                        }
                    if (i == 11)
                        if (7 < j && j < 13) {
                            if (Controller.isSeatAvailable(show, i, j, date))
                                btn.getStylesheets().add(getClass().getResource("extraLeg.css").toExternalForm());
                            else {
                                btn.getStylesheets().add(getClass().getResource("buttonReserved.css").toExternalForm());
                                btn.setDisable(true);
                            }
                        }
                }
//                btn.setOnAction(event -> selectSeatAction(btn));
            }
        }
        Label lblStage = new Label("- - - - Stage - - - -");
        pane.add(lblStage, 0, 0);
        GridPane.setHalignment(lblStage, HPos.CENTER);

        // Setting horizontal and vertical gap
        seatsPane.setHgap(5);
        seatsPane.setVgap(5);

        // GridPane to GridPane
        pane.add(seatsPane, 0, 1);


        Label lblSeatCount = new Label("Booked Seats : " + show.getBookedSeatCount(date) + "/300");
        pane.add(lblSeatCount,0,2);
        GridPane.setHalignment(lblSeatCount,HPos.RIGHT);

        Label lblShowName = new Label(show.getName());
        pane.add(lblShowName,0,0);
        GridPane.setHalignment(lblShowName,HPos.LEFT);

        Label lblDate = new Label(date.toString());
        pane.add(lblDate,0,0);
        GridPane.setHalignment(lblDate, HPos.RIGHT);

        Button btnCreateReservation = new Button("Create reservation");
        pane.add(btnCreateReservation,0,2);
        GridPane.setHalignment(btnCreateReservation,HPos.CENTER);
        btnCreateReservation.setOnAction(e -> createReservation());
    }

    // -----------------------actions---------------------------

    private void selectSeatAction(Button btn) {
        boolean stylesheet = btn.getStylesheets().add(getClass().getResource("buttonSelected.css").toExternalForm());
        btn.getUserData();

        if (!stylesheet)
            btn.getStylesheets().add(getClass().getResource("buttonSelected.css").toExternalForm());
    }

    public void createReservation() {
        ArrayList<Seat> seats = new ArrayList<>();
        for (CheckBox e : btns) {
            if (e.isSelected()) {
                seats.add((Seat) e.getUserData());
            }

        }
        Reservation reservation = Controller.createReservationWithSeats(show, costumer, date, seats);
        this.hide();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reservation Created");
        String string = String.format("%s booked \n %s for %s(%s)",costumer.getName(),seats,show.getName(),date);
        alert.setHeaderText("Booking Created, Total Cost is " + reservation.calcTotalPrice() + "Dkk");
        alert.setContentText(string);
        alert.show();
    }
}
