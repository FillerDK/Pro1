package exercises.ex3;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage {

    public PersonInputWindow(String title, Stage owner) {
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

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox cbxSenior = new CheckBox("Senior");

    private Person actualPerson = null;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);

        pane.add(txfName, 1, 0, 2, 1);

        pane.add(txfTitle, 1, 1, 2, 1);

        pane.add(cbxSenior, 1, 2);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 3);
        btnCancel.setPrefWidth(60);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOk = new Button("OK");
        pane.add(btnOk, 2, 3);
        btnOk.setPrefWidth(60);
        btnOk.setOnAction(event -> this.okAction());
    }

    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfTitle.clear();
        actualPerson = null;
        PersonInputWindow.this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        boolean senior = cbxSenior.isSelected();

        if (name.length() > 0 && title.length() > 0) {
            actualPerson = new Person(name, title, senior);
            txfName.clear();
            txfTitle.clear();
            cbxSenior.setSelected(false);
            PersonInputWindow.this.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add person");
            alert.setHeaderText("Missing input");
            alert.setContentText("Type name and title!");
            alert.show();
        }
    }

    public Person getActualPerson() {
        return actualPerson;
    }
}
