package exercises.ex4;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiEx5 extends Application {

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
    private final TextArea txaNames = new TextArea();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        pane.add(txfInput, 0, 1);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 0, 2);
        GridPane.setHalignment(btnAdd, HPos.CENTER);

        btnAdd.setOnAction(event -> this.addAction());

        pane.add(txaNames, 0, 3);
        txaNames.setPrefWidth(125);
    }

    private void addAction() {
        if (!txfInput.getText().equals("")) {
            if (txaNames.getText().equals("")) {
                txaNames.setText(txfInput.getText());
                txfInput.requestFocus();
            }
            else {
                txaNames.setText(txaNames.getText() + "\n" + txfInput.getText());
                txfInput.requestFocus();
            }
        }
    }
}
