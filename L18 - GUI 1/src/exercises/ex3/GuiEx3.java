package exercises.ex3;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class GuiEx3 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Future Investment");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfInvestment = new TextField();
    private final TextField txfYears = new TextField();
    private final TextField txfInterest = new TextField();
    private final TextField txfFutureValue = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblInvestment = new Label("Investment:");
        pane.add(lblInvestment, 0, 0);
        pane.add(txfInvestment, 1, 0);

        Label lblYears = new Label("Years:");
        pane.add(lblYears, 0, 1);
        pane.add(txfYears, 1, 1);

        Label lblInterest = new Label("Interest (%):");
        pane.add(lblInterest, 0, 2);
        pane.add(txfInterest, 1, 2);

        Button btnCalc = new Button("Calculate");
        pane.add(btnCalc, 1, 3);
        GridPane.setHalignment(btnCalc, HPos.CENTER);

        btnCalc.setOnAction(event -> this.calcAction());

        Label lblFutureValue = new Label("Future value:");
        pane.add(lblFutureValue, 0, 4);
        pane.add(txfFutureValue, 1, 4);
    }

    private void calcAction() {
        int investment = Integer.parseInt(txfInvestment.getText().trim());
        int years = Integer.parseInt(txfYears.getText().trim());
        double interestRate = Double.parseDouble(txfInterest.getText().trim());
        double futureValue = investment * Math.pow(1 + interestRate / 100, years);
        String strFutureValue = String.format("%.2f", futureValue);
        txfFutureValue.setText(strFutureValue);
    }
}
