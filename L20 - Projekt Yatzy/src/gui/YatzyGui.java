package gui;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.YatzyDice;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    Stage window;
    Scene mainScene, gameScene;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;

        // Gridpanes
        GridPane gamePane = new GridPane();
        gamePane.setStyle("-fx-background-color: black ; ");
        GridPane mainPane = new GridPane();
        mainPane.setStyle("-fx-background-color: black ; ");
        mainPane.setPadding(new Insets(10));
        GridPane mainPane1 = new GridPane();
        mainPane1.setHgap(10);
        mainPane1.setVgap(10);
        mainPane1.setPadding(new Insets(10));
        mainPane1.setStyle("-fx-border-radius: 10px ; " +
                "-fx-border-width: 5px ; " +
                "-fx-border-color: white ; " +
                "-fx-border-style: solid ; " +
                "-fx-background-color: black ; ");

        this.initContent(gamePane);

        Scene gameScene = new Scene(gamePane);
        Scene mainScene = new Scene(mainPane);

        Font fontLbl = Font.loadFont(new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy\\src\\resources\\fonts\\PublicPixel-z84yD.ttf"), 100);
        Font fontBtn = Font.loadFont(new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy\\src\\resources\\fonts\\PublicPixel-z84yD.ttf"), 20);

        Label lblWelcome = new Label("Yatzy");
        lblWelcome.setFont(fontLbl);
        lblWelcome.setTextFill(Color.WHITE);
        GridPane.setHalignment(lblWelcome, HPos.RIGHT);

        Button btnSceneSwitch = new Button("Play");
        mainPane1.add(btnSceneSwitch, 0, 1);
        btnSceneSwitch.setFont(fontBtn);
        GridPane.setHalignment(btnSceneSwitch, HPos.CENTER);

        btnSceneSwitch.setOnAction(event -> window.setScene(gameScene));

        mainPane1.add(lblWelcome, 0, 0);
        mainPane.add(mainPane1, 0, 0);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Yatzy");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private final Label lblThrowCount = new Label("Throw count:");
    private final Button btnThrow = new Button(" Throw ");

    private final String[] throwStrings = { "One Pair", "Two Pairs", "Three-same", "Four-same", "Full House", "Small Str.", "Large Str.", "Chance", "Yatzy" };

    private void initContent(GridPane pane) throws FileNotFoundException {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------


        Font font = Font.loadFont(new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy\\src\\resources\\fonts\\PublicPixel-z84yD.ttf"), 8);


        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-radius: 10px ; " +
                "-fx-border-width: 5px ; " +
                "-fx-border-color: white ; " +
                "-fx-border-style: solid ; " +
                "-fx-background-color: black ; ");

        // add txfValues, chbHolds
        HBox valuesBox = new HBox();
        valuesBox.setSpacing(10);
        dicePane.add(valuesBox, 0, 0);

        for (int i = 0; i < 5; i++) {
            VBox holdsBox = new VBox();
            holdsBox.setSpacing(5);
            holdsBox.setAlignment(Pos.CENTER);
            txfValues[i] = new TextField("1");
            txfValues[i].setAlignment(Pos.CENTER);
            txfValues[i].setPrefSize(75, 75);
            txfValues[i].setMouseTransparent(true);
            txfValues[i].setEditable(false);
            txfValues[i].setFocusTraversable(false);
            txfValues[i].setFont(font);

            cbxHolds[i] = new CheckBox("Hold");
            cbxHolds[i].setDisable(true);
            cbxHolds[i].setFont(font);
            cbxHolds[i].setTextFill(Color.WHITE);
            holdsBox.getChildren().addAll(txfValues[i], cbxHolds[i]);

            valuesBox.getChildren().add(holdsBox);
        }
        // add lblThrowCount and btnThrow
        dicePane.add(lblThrowCount, 0, 1);
        lblThrowCount.setFont(font);
        lblThrowCount.setTextFill(Color.WHITE);
        dicePane.add(btnThrow, 0, 1);
        btnThrow.setFont(font);
        /*btnThrow.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), " +
                "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%) ; " +
                "-fx-background-insets: 0,1,2 ; " +
                "-fx-background-radius: 3,2,1 ; " +
                "-fx-padding: 3 30 3 30 ; " +
                "-fx-text-fill: black ; " +
                "-fx-font-size: 14px ; ");*/
        btnThrow.setOnAction(event -> this.throwAction());
        GridPane.setHalignment(btnThrow, HPos.RIGHT);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-radius: 10px ; " +
                "-fx-border-width: 5px ; " +
                "-fx-border-color: white ; " +
                "-fx-border-style: solid ; " +
                "-fx-background-color: black ; ");
        int width = 50; // width of the text fields

        // add labels for results
        // add txfResults.
        for (int i = 0; i < 6; i++) {
            Label lblNums = new Label(i+1 + "-s");
            txfResults.add(i, new TextField());
            txfResults.get(i).setPrefWidth(width);
            txfResults.get(i).setEditable(false);
            txfResults.get(i).setMouseTransparent(true);
            lblNums.setFont(font);
            lblNums.setTextFill(Color.WHITE);
            scorePane.add(lblNums, 0, i);
            scorePane.add(txfResults.get(i), 1, i);
        }

        for (int i = 6; i < 15; i++) {
            HBox numsHBox = new HBox();
            numsHBox.setSpacing(10);
            Label lblNums = new Label(String.format("%-10s", throwStrings[i-6]));
            lblNums.setFont(font);
            lblNums.setTextFill(Color.WHITE);
            txfResults.add(i, new TextField());
            txfResults.get(i).setPrefWidth(width);
            txfResults.get(i).setEditable(false);
            scorePane.add(lblNums, 0, i+1);
            scorePane.add(txfResults.get(i), 1, i+1);
            GridPane.setHalignment(lblNums, HPos.LEFT);
        }
        // add labels and text fields for sums, bonus and total.
        Label lblSumSame = new Label("Sum");
        lblSumSame.setFont(font);
        lblSumSame.setTextFill(Color.WHITE);
        scorePane.add(lblSumSame, 2, 5);
        scorePane.add(txfSumSame, 3, 5);
        txfSumSame.setPrefWidth(width);
        Label lblBonus = new Label("Bonus");
        lblBonus.setFont(font);
        lblBonus.setTextFill(Color.WHITE);
        scorePane.add(lblBonus, 2, 6);
        scorePane.add(txfBonus, 3, 6);
        txfBonus.setPrefWidth(width);
        Label lblSumOther = new Label("Sum");
        lblSumOther.setFont(font);
        lblSumOther.setTextFill(Color.WHITE);
        scorePane.add(lblSumOther, 2, 15);
        scorePane.add(txfSumOther, 3, 15);
        txfSumOther.setPrefWidth(width);
        Label lblTotal = new Label("Total");
        lblTotal.setFont(font);
        lblTotal.setTextFill(Color.WHITE);
        scorePane.add(lblTotal, 2, 16);
        scorePane.add(txfTotal, 3, 16);
        txfTotal.setPrefWidth(width);
    }

    // -------------------------------------------------------------------------

    // Create an action method for btnThrow's action.
    // Hint: Create small helper methods to be used in the action method.
    private void throwAction() {
        dice.throwDice();
        lblThrowCount.setText("Throw count: " + dice.getThrowCount());
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    private void mouseClicked(MouseEvent event) {
        TextField txf = (TextField) event.getSource();
        if (txf == txfResults.get(1)) {
            txf.setStyle("-fx-control-inner-background: yellow");
        }
    }

}
