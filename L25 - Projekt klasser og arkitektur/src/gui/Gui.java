package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.Costumer;
import model.Reservation;
import model.Seat;
import model.Show;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Ticket Mister");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    //---------------------------------------------------

    //Show
    private final ListView<Show> lvwShows = new ListView<>();
    private final TextField txfShowName = new TextField();
    private final DatePicker dpStartDate = new DatePicker();
    private final DatePicker dpEndDate = new DatePicker();

    //Costumer
    private final ListView<Costumer> lvwCostumers = new ListView<>();
    private final TextField txfCostumerName = new TextField();
    private final TextField txfCostumerPhone = new TextField();

    //Seats

    private final ListView<Seat> lvwSeats = new ListView<Seat>();
    private final DatePicker dpSeatDate = new DatePicker();

    private final Label lblErrorMessage = new Label("");

    //---------------------------------------------------

    public void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(15);
        pane.setVgap(10);

        // ===== Date Picker Bullshit Formatting Code ============
        String pattern = "yyyy-MM-dd";
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null){
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String s) {
                if (s != null & !s.isEmpty()){
                    return LocalDate.parse(s, dateFormatter);
                } else {
                    return null;
                }
            }
        };

        //=========== Show Gui ================
        int lvwHeight = 200;
        Label lblShows = new Label("Shows");
        pane.add(lblShows, 0, 0);
        pane.add(lvwShows, 0, 1, 2, 1);
        lvwShows.setMaxHeight(lvwHeight);
        lvwShows.getItems().setAll(Controller.getShows());

        Label lblShowName = new Label("Name:");
        pane.add(lblShowName, 0, 2);
        pane.add(txfShowName, 1, 2);

        Label lblStartDate = new Label("Start Date:");
        pane.add(lblStartDate, 0, 3);
        pane.add(dpStartDate, 1, 3);
        dpStartDate.setEditable(false);
        dpStartDate.setConverter(converter);

        Label lblEndDate = new Label("End Date:");
        pane.add(lblEndDate, 0, 4);
        pane.add(dpEndDate, 1, 4);
        dpEndDate.setEditable(false);
        dpEndDate.setConverter(converter);

        Button btnCreateShow = new Button("Create Show");
        btnCreateShow.setOnAction(e -> createShow());
        pane.add(btnCreateShow, 1, 5);

        //=========== Costumer Gui ================
        Label lblCostumers = new Label("Costumers");
        pane.add(lblCostumers, 2, 0);
        pane.add(lvwCostumers, 2, 1, 2, 1);
        lvwCostumers.setMaxHeight(lvwHeight);
        lvwCostumers.getItems().setAll(Controller.getCostumers());

        Label lblCostumerName = new Label("Costumer Name:");
        pane.add(lblCostumerName, 2, 2);
        pane.add(txfCostumerName, 3, 2);

        Label lblCostumerPhone = new Label("Costumer Phone:");
        pane.add(lblCostumerPhone, 2, 3);
        pane.add(txfCostumerPhone, 3, 3);

        Button btnCreateCostumer = new Button("Create Costumer");
        pane.add(btnCreateCostumer, 3, 4);
        btnCreateCostumer.setOnAction(e -> createCostumer());




        //======================= Seat GUI =====================

        Label lblSeats = new Label("Seats");
        pane.add(lblSeats,4,0);
        pane.add(lvwSeats,4,1,2,1);
        lvwSeats.setMaxHeight(lvwHeight);
        lvwSeats.getItems().setAll(Controller.getSeats());
        lvwSeats.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Label lblSeatDate = new Label("Date:");
        pane.add(lblSeatDate,4,2);
        pane.add(dpSeatDate,5,2);
        dpSeatDate.setEditable(false);
        dpSeatDate.setConverter(converter);
        Button btnCreateReservation = new Button("Create Reservation");
        pane.add(btnCreateReservation,5,3);
        btnCreateReservation.setOnAction(e -> createReservation());

        Button btnShowSeats = new Button("Show Seats");
        pane.add(btnShowSeats,5,4);
        btnShowSeats.setOnAction(e -> showSeats());


        pane.add(lblErrorMessage, 2, 5, 4, 1);
        lblErrorMessage.setTextFill(Color.RED);
        GridPane.setHalignment(lblErrorMessage, HPos.CENTER);

   }



    //======================== Actions =====================

    private void createShow() {
        boolean inputIsValid = true;
        LocalDate endDate = dpEndDate.getValue();

        if (endDate == null) {
            lblErrorMessage.setText("Please input a end date");
            inputIsValid = false;
        }

        LocalDate startDate = dpStartDate.getValue();
        if (startDate == null) {
            lblErrorMessage.setText("Please input a starting date");
            inputIsValid = false;

        }
        if (endDate != null && startDate != null) {
            if (startDate.isAfter(endDate)) {
                lblErrorMessage.setText("Please set a valid end date");
                inputIsValid = false;
            }
        }

        String name = txfShowName.getText();
        if (txfShowName.getText().equalsIgnoreCase("")) {
            lblErrorMessage.setText("Please input a show name");
            inputIsValid = false;
        }
        if (inputIsValid) {
            Controller.createShow(name, startDate, endDate);
            updateShowGui();
        }
    }

    private void createCostumer() {
        boolean isValidInput = true;
        String phone = txfCostumerPhone.getText().trim();
        try {
            int phoneInt = Integer.parseInt(txfCostumerPhone.getText().trim());
        } catch (NumberFormatException ex) {
            lblErrorMessage.setText("Please input a valid phone number");
            isValidInput = false;
        }
        if (phone.equalsIgnoreCase("")) {
            lblErrorMessage.setText("Please input a costumer phone number");
            isValidInput = false;
        }
        if (phone.length() < 8 || phone.length() > 8) {
            lblErrorMessage.setText("Please input a valid phone number");
            isValidInput = false;
        }

        String name = txfCostumerName.getText().trim();
        if (name.equalsIgnoreCase("")) {
            lblErrorMessage.setText("Please input a costumer name");
            isValidInput = false;
        }
        if (isValidInput) {
            Controller.createCostumer(name, phone);
            updateCostumerGui();
        }

    }

    public void createReservation(){
        Boolean isValidInput = true;
        Show show = lvwShows.getSelectionModel().getSelectedItem();
        if (show == null) {
            isValidInput = false;
            lblErrorMessage.setText("Please select a show");
        }

        Costumer costumer = lvwCostumers.getSelectionModel().getSelectedItem();
        if (costumer == null) {
            isValidInput = false;
            lblErrorMessage.setText("Please select a costumer");
        }

        LocalDate date = dpSeatDate.getValue();
        if (date == null) {
            isValidInput = false;
            lblErrorMessage.setText("Please input a reservation date");

        }

        if (show != null && date != null){
            if (date.isBefore(show.getStartDate()) || date.isAfter(show.getEndDate())){
                isValidInput = false;
                lblErrorMessage.setText("Please input a valid date");
            }

        }

        ObservableList seatsObservableList = lvwSeats.getSelectionModel().getSelectedItems();
        ArrayList<Seat> seats = new ArrayList<>(seatsObservableList);
        if (seats.isEmpty()){
            isValidInput = false;
            lblErrorMessage.setText("Please select one or more seats");
        }

        if (!seats.isEmpty()){
            for (Seat e : seats){
                if (!Controller.isSeatAvailable(show, e.getRow(),e.getNum(),date)){
                    isValidInput = false;
                    lblErrorMessage.setText("Sorry, seat " + e + " is not available");
                }

            }
        }

        if (isValidInput){
            Reservation reservation = Controller.createReservationWithSeats(show, costumer, date, seats);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reservation Created");
            String string = String.format("%s booked \n %s for %s(%s)",costumer.getName(),seats,show.getName(),date);
            alert.setHeaderText("Booking Created, Total Cost is " + reservation.calcTotalPrice() + "Dkk");
            alert.setContentText(string);
            alert.show();

            updateSeatGui();
            System.out.println(show.getBookedSeatCount(date));
            System.out.println(show.getSucessDate());
            System.out.println(costumer.getBookedSeats(show,date));
        }
    }

    private void showSeats() {
        //createReservationAction();
        boolean isValidInput = true;

        LocalDate date = dpSeatDate.getValue();
        if (date == null) {
            lblErrorMessage.setText("Please input a date");
            isValidInput = false;
        }

        Costumer costumer = lvwCostumers.getSelectionModel().getSelectedItem();
        if (costumer == null) {
            lblErrorMessage.setText("Please select a customer");
            isValidInput = false;
        }

        Show show = lvwShows.getSelectionModel().getSelectedItem();
        if (show == null) {
            lblErrorMessage.setText("Please select a show");
            isValidInput = false;
        }

        if (show != null && date != null){
            if (date.isBefore(show.getStartDate()) || date.isAfter(show.getEndDate())){
                isValidInput = false;
                lblErrorMessage.setText("Please input a valid date");
            }

        }
        if (isValidInput) {
            SeatPickerWindow dialog = new SeatPickerWindow("Pick seat(s)", show, date, costumer);
            dialog.showAndWait();
        }

}
    //============== Helpers ================

    private void updateShowGui() {
        txfShowName.clear();
        dpStartDate.getEditor().clear();
        dpStartDate.setValue(null);
        dpEndDate.getEditor().clear();
        dpEndDate.setValue(null);
        lblErrorMessage.setText("");

        lvwShows.getItems().setAll(Controller.getShows());
    }

    private void updateCostumerGui() {
        txfCostumerName.clear();
        txfCostumerPhone.clear();
        lblErrorMessage.setText("");
        lvwCostumers.getItems().setAll(Controller.getCostumers());
    }


    private void updateSeatGui(){
        lvwShows.getSelectionModel().clearSelection();
        lvwCostumers.getSelectionModel().clearSelection();
        lvwSeats.getSelectionModel().clearSelection();
        dpSeatDate.setValue(null);
        dpSeatDate.getEditor().clear();
        lblErrorMessage.setText("");
    }
}
