package exercises.ex4;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GuiEx4 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Celsius to Fahrenheit");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfInput = new TextField();
    private final TextField txfConverted = new TextField();
    private final Label lblInput = new Label();
    private final Label lblOutput = new Label();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblFrom = new Label("From:");
        pane.add(lblFrom, 0, 0);
        GridPane.setHalignment(lblFrom, HPos.RIGHT);
        pane.add(txfInput, 1, 0);

        Label lblTo = new Label("To:");
        pane.add(lblTo, 0, 1);
        GridPane.setHalignment(lblTo, HPos.RIGHT);
        pane.add(txfConverted, 1, 1);
        txfConverted.setEditable(false);
        txfConverted.setMouseTransparent(true);
        txfConverted.setFocusTraversable(false);

        lblInput.setText("Celsius");
        pane.add(lblInput, 2, 0);

        Button btnConvert = new Button("Convert");
        pane.add(btnConvert, 1, 2);
        GridPane.setHalignment(btnConvert, HPos.CENTER);
        btnConvert.setOnAction(event -> this.convertAction());

        Button btnSwitch = new Button("↕");
        pane.add(btnSwitch, 3, 0, 1, 2);
        GridPane.setHalignment(btnSwitch, HPos.CENTER);

        btnSwitch.setOnAction(event -> this.switchAction());

        lblOutput.setText("Fahrenheit");
        pane.add(lblOutput, 2, 1);
    }

    private void convertAction() {
        double converted = 0;
        if (lblInput.getText().equals("Celsius")) {
            double toFahrenheit = 9.0/ 5 * Double.parseDouble(txfInput.getText().trim()) + 32;
            converted = toFahrenheit;
        } else {
            double toCelsius = (Double.parseDouble(txfInput.getText().trim()) - 32) / 1.8;
            converted = toCelsius;
        }
        String strConverted = String.format("%.2f", converted);
        txfConverted.setText(strConverted);
    }

    private void switchAction() {
        if (lblInput.getText().equals("Celsius")) {
            lblInput.setText("Fahrenheit");
            lblOutput.setText("Celsius");
            txfInput.clear();
            txfConverted.clear();
        } else {
            lblInput.setText("Celsius");
            lblOutput.setText("Fahrenheit");
            txfInput.clear();
            txfConverted.clear();
        }
    }
}
