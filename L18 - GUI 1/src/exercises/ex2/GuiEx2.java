package exercises.ex2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiEx2 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui +-");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfNumber = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblNumber = new Label("Number:");
        pane.add(lblNumber, 0, 0, 1, 2);

        // add a text field to the pane (at col=0, row=1)
        // TextField txfFirstName = new TextField();
        pane.add(txfNumber, 1, 0, 1, 2);
        txfNumber.setEditable(false);
        txfNumber.setMouseTransparent(true);
        txfNumber.setFocusTraversable(false);
        txfNumber.setText("0");
        txfNumber.setPrefWidth(50);

        // add a button to the pane (at col=1, row=1)
        Button btnInc = new Button("Inc");
        pane.add(btnInc, 2, 0);
        GridPane.setMargin(btnInc, new Insets(10, 10, 0, 10));

        btnInc.setOnAction(event -> this.incAction());

        // add a button to the pane (at col=1, row=1)
        Button btnDec = new Button("Dec");
        pane.add(btnDec, 2, 1);
        GridPane.setMargin(btnDec, new Insets(0, 10, 10, 10));

        btnDec.setOnAction(event -> this.decAction());
    }

    private void incAction() {
        int currNum = Integer.parseInt(txfNumber.getText());
        currNum++;
        String newNum = Integer.toString(currNum);
        txfNumber.setText(newNum);
    }

    private void decAction() {
        int currNum = Integer.parseInt(txfNumber.getText());
        currNum--;
        String newNum = Integer.toString(currNum);
        txfNumber.setText(newNum);
    }
}
