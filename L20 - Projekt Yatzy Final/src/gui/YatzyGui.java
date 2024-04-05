package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.YatzyDice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class YatzyGui extends Application {
    public YatzyGui() throws FileNotFoundException {
    }

    private YatzyDice dice = new YatzyDice();

    // region # AUDIO #
    Media tatsuroMedia = new Media(new File("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\wavFiles\\tatsuro.wav").toURI().toString());
    MediaPlayer tatsuroPlayer = new MediaPlayer(tatsuroMedia);
    Media diceRollMedia = new Media(new File("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\wavFiles\\diceRoll.wav").toURI().toString());
    MediaPlayer diceRollPlayer = new MediaPlayer(diceRollMedia);
    Media diceShakeMedia = new Media(new File("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\wavFiles\\diceShake.wav").toURI().toString());
    MediaPlayer diceShakePlayer = new MediaPlayer(diceShakeMedia);
    Media popMedia = new Media(new File("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\wavFiles\\pop.wav").toURI().toString());
    MediaPlayer popPlayer = new MediaPlayer(popMedia);
    // endregion

    Stage window;
    Scene mainScene, gameScene, settingsScene;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;

        // Gridpanes
        GridPane gamePane = new GridPane(); // gameplay pane
        gamePane.setStyle("-fx-background-color: black ; ");
        GridPane mainPane = new GridPane(); // main menu pane
        mainPane.setStyle("-fx-background-color: black ; ");
        mainPane.setPadding(new Insets(10));
        GridPane mainPane1 = new GridPane(); // main menu pane
        mainPane1.setHgap(10);
        mainPane1.setVgap(10);
        mainPane1.setPadding(new Insets(10));
        mainPane1.setStyle("-fx-border-radius: 10px ; " +
                "-fx-border-width: 5px ; " +
                "-fx-border-color: purple ; " +
                "-fx-border-style: solid ; " +
                "-fx-background-color: black ; ");
        GridPane settingsPane = new GridPane(); // settings pane
        settingsPane.setStyle("-fx-background-color: black ; ");

        this.initContent(gamePane);

        Scene gameScene = new Scene(gamePane);
        Scene mainScene = new Scene(mainPane);
        Scene settingsScene = new Scene(settingsPane);

        Font fontLbl = Font.loadFont(new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\fonts\\PublicPixel-z84yD.ttf"), 100);
        Font fontBtn = Font.loadFont(new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\fonts\\PublicPixel-z84yD.ttf"), 20);

        Label lblWelcome = new Label("Yatzy");
        lblWelcome.setFont(fontLbl);
        lblWelcome.setTextFill(Color.WHITE);
        GridPane.setHalignment(lblWelcome, HPos.RIGHT);

        Button btnPlay = new Button("Play");
        mainPane1.add(btnPlay, 0, 1);
        btnPlay.setFont(fontBtn);
        GridPane.setHalignment(btnPlay, HPos.CENTER);

        Button btnSettings = new Button("Settings");
        mainPane1.add(btnSettings, 0, 2);
        btnSettings.setFont(fontBtn);
        GridPane.setHalignment(btnSettings, HPos.CENTER);

        btnPlay.setOnAction(event -> window.setScene(gameScene));
        btnSettings.setOnAction(event -> window.setScene(settingsScene));

        mainPane1.add(lblWelcome, 0, 0);
        mainPane.add(mainPane1, 0, 0);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Yatzy");
        primaryStage.setResizable(false);
        primaryStage.show();


        tatsuroPlayer.setVolume(0.4);
        tatsuroPlayer.play();
    }

    // -------------------------------------------------------------------------

    private final TextField[] txfValues = new TextField[5];
    private final CheckBox[] cbxHolds = new CheckBox[5];
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    private final String[] strResult = {"One Pair", "Two Pairs", "Three-same", "Four-same", "Full House", "Small str.", "Large str.", "Chance", "Yatzy"};

    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private Label lblThrowCount = new Label("ThrowCount: 0");
    private final Button btnThrow = new Button(" Throw ");

    DiceImage diceImage = new DiceImage();
    ImageView imageViewDice1 = new ImageView(diceImage.y1Image);
    ImageView imageViewDice2 = new ImageView(diceImage.aImage);
    ImageView imageViewDice3 = new ImageView(diceImage.tImage);
    ImageView imageViewDice4 = new ImageView(diceImage.zImage);
    ImageView imageViewDice5 = new ImageView(diceImage.y2Image);

    ArrayList<ImageView> diceImageView = new ArrayList<ImageView>(5);
    ArrayList<Image> diceImages = new ArrayList<Image>(6);
    ArrayList<Image> diceGifs = new ArrayList<Image>(5);
    ArrayList<Image> letterImages = new ArrayList<Image>(5);

    boolean[] holdStatus = new boolean[5];

    private void initContent(GridPane pane) throws FileNotFoundException {

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ======================== U P P E R - P A N E =====================

        Font font = Font.loadFont(new FileInputStream("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\fonts\\PublicPixel-z84yD.ttf"), 10);
        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(20);
        dicePane.setStyle("-fx-border-radius: 10px ; " +
                "-fx-border-width: 5px ; " +
                "-fx-border-color: purple ; " +
                "-fx-border-style: solid ; " +
                "-fx-background-color: black ; ");

        HBox diceBox = new HBox();
        dicePane.add(diceBox, 0, 0);
        diceBox.setSpacing(20);

        // region # ADDING IMAGES TO ARRAYS #

        // CAN SURELY BE OPTIMIZED
        diceImageView.add(imageViewDice1);
        diceImageView.add(imageViewDice2);
        diceImageView.add(imageViewDice3);
        diceImageView.add(imageViewDice4);
        diceImageView.add(imageViewDice5);
        letterImages.add(diceImage.y1Image);
        letterImages.add(diceImage.aImage);
        letterImages.add(diceImage.tImage);
        letterImages.add(diceImage.zImage);
        letterImages.add(diceImage.y2Image);
        diceImages.add(diceImage.imageDice1);
        diceImages.add(diceImage.imageDice2);
        diceImages.add(diceImage.imageDice3);
        diceImages.add(diceImage.imageDice4);
        diceImages.add(diceImage.imageDice5);
        diceImages.add(diceImage.imageDice6);
        diceGifs.add(diceImage.gifImage1);
        diceGifs.add(diceImage.gifImage2);
        diceGifs.add(diceImage.gifImage3);
        diceGifs.add(diceImage.gifImage4);
        diceGifs.add(diceImage.gifImage5);
        diceGifs.add(diceImage.gifImage6);
        // endregion

        for (int i = 0; i < 5; i++) {
            VBox vBox = new VBox();
            txfValues[i] = new TextField();
            txfValues[i].setPrefSize(75, 75);
            cbxHolds[i] = new CheckBox("Hold");
            cbxHolds[i].setDisable(true);
            cbxHolds[i].setFocusTraversable(false);
            cbxHolds[i].setOnAction(event -> cbxHoldsAction());
            cbxHolds[i].setFont(font);
            cbxHolds[i].setTextFill(Color.WHITE);
            vBox.getChildren().addAll(diceImageView.get(i), cbxHolds[i]);
            vBox.setSpacing(10);
            vBox.setAlignment(Pos.CENTER);
            diceBox.getChildren().add(vBox);
        }
        dicePane.add(lblThrowCount, 0, 1);
        lblThrowCount.setFont(font);
        lblThrowCount.setTextFill(Color.WHITE);
        dicePane.add(btnThrow, 0, 1);
        btnThrow.setFocusTraversable(false);
        btnThrow.setFont(font);
        btnThrow.setTextFill(Color.BLACK);
        btnThrow.setOnAction(event -> {
            throwAction();
        });
        GridPane.setHalignment(btnThrow, HPos.RIGHT);


        // ======================== L O W E R - P A N E =====================

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setMinWidth(dicePane.getWidth());
        int txfWidth = 50;
        scorePane.setStyle("-fx-border-radius: 10px ; " +
                "-fx-border-width: 5px ; " +
                "-fx-border-color: purple ; " +
                "-fx-border-style: solid ; " +
                "-fx-background-color: black ; ");

        for (ImageView imageView : diceImageView) {
            imageView.setFitHeight(75);
            imageView.setFitWidth(75);
        }

        for (int i = 0; i < 6; i++) {
            String str = (i + 1) + "-s";
            Label lblNums = new Label(String.format("%-5s", str));
            lblNums.setFont(font);
            lblNums.setTextFill(Color.WHITE);
            txfResults.add(new TextField());
            txfResults.get(i).setPrefWidth(txfWidth);
            txfResults.get(i).setEditable(false);
            txfResults.get(i).setFocusTraversable(false);
            scorePane.add(lblNums, 1, i);
            scorePane.add(txfResults.get(i), 2, i);
        }

        for (int i = 6; i < 15; i++) {
            Label lblNums = new Label(String.format("%-12s", strResult[i - 6]));
            txfResults.add(new TextField());
            lblNums.setFont(font);
            lblNums.setTextFill(Color.WHITE);
            txfResults.get(i).setPrefWidth(txfWidth);
            txfResults.get(i).setEditable(false);
            txfResults.get(i).setFocusTraversable(false);
            scorePane.add(lblNums, 6, i - 6);
            scorePane.add(txfResults.get(i), 5, i - 6);
        }

        // region # STATIC SUM LABELS AND FIELDS #
        Label lblSumSame = new Label("Sum");
        lblSumSame.setFont(font);
        lblSumSame.setTextFill(Color.WHITE);
        scorePane.add(lblSumSame, 1, 12);
        scorePane.add(txfSumSame, 2, 12);
        txfSumSame.setPrefWidth(txfWidth);
        txfSumSame.setFocusTraversable(false);
        txfSumSame.setEditable(false);
        txfSumSame.setMouseTransparent(true);
        Label lblBonus = new Label("Bonus");
        lblBonus.setFont(font);
        lblBonus.setTextFill(Color.WHITE);
        scorePane.add(lblBonus, 1, 11);
        scorePane.add(txfBonus, 2, 11);
        txfBonus.setPrefWidth(txfWidth);
        txfBonus.setFocusTraversable(false);
        txfBonus.setEditable(false);
        txfBonus.setMouseTransparent(true);
        Label lblSumOther = new Label("Sum");
        lblSumOther.setFont(font);
        lblSumOther.setTextFill(Color.WHITE);
        scorePane.add(lblSumOther, 6, 11);
        scorePane.add(txfSumOther, 5, 11);
        txfSumOther.setPrefWidth(txfWidth);
        txfSumOther.setFocusTraversable(false);
        txfSumOther.setEditable(false);
        txfSumOther.setMouseTransparent(true);
        Label lblTotal = new Label("TOTAL");
        lblTotal.setFont(font);
        lblTotal.setTextFill(Color.WHITE);
        scorePane.add(lblTotal, 6, 12);
        scorePane.add(txfTotal, 5, 12);
        txfTotal.setPrefWidth(txfWidth);
        txfTotal.setFocusTraversable(false);
        txfTotal.setEditable(false);
        txfTotal.setMouseTransparent(true);
        // endregion
    }

    // ======================= M E T H O D S ====================================

    public void throwAction() {
        throwDice();
        updateCounter();
        lockCbx();
        playGif();
        txfResultAction();
    }

    public void playGif() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (CheckBox cbx : cbxHolds) {
                    cbx.setDisable(true);
                }

                soundDiceShake();
                for (int i = 0; i < 5; i++) {
                    if (!cbxHolds[i].isSelected()) {
                        diceImageView.get(i).setImage(diceGifs.get(i));
                    }
                }
            }
        });
        t1.start();
    }

    public void throwDice() {
        dice.throwDice(holdStatus);
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                // Wait for GIF to play
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Throw Dice
                int[] values = dice.getValues();
                for (int i = 0; i < 5; i++) {
                    int value = values[i];
                    if (!cbxHolds[i].isSelected()) {
                        diceImageView.get(i).setImage(diceImages.get(value - 1));
                    }
                }
                soundDiceRoll();
                if (dice.getThrowCount() == 1) {
                    setHoldStatus(false);
                }
                if (dice.getThrowCount() == 3) {
                    btnThrow.setDisable(true);
                }
                if (dice.getThrowCount() != 3) {
                    for (CheckBox cbx : cbxHolds) {
                        if (!cbx.isSelected()) {
                            cbx.setDisable(false);
                        }
                    }
                }
                printTextFieldValues();
            }
        });
        t2.start();
    }

    public void printTextFieldValues() {
        for (int i = 0; i < txfResults.size(); i++) {
            if (!txfResults.get(i).isDisabled()) {
                txfResults.get(i).setText(String.valueOf(dice.getResults()[i + 1]));
                if (Integer.parseInt(txfResults.get(i).getText()) != 0) {
                    txfResults.get(i).setStyle("-fx-control-inner-background: #863fa2");
                } else {
                    txfResults.get(i).setStyle("-fx-control-inner-background: white");
                }
            }
        }
    }

    private void txfResultAction() {
        for (TextField txf : txfResults) {
            txf.setOnMouseClicked(event -> {
                TextField result = (TextField) event.getSource();
                if (dice.getThrowCount() > 0) {
                    result.setDisable(true);
                    soundPop();
                }
                resetTextFieldValues();
                saveResults();
                setHoldStatus(true);
                btnThrow.setDisable(false);
                dice.resetThrowCount();
                resetDice();
                resetGame();
            });
        }
    }

    private void resetGame() {
        int resetGame = 0;
        for (TextField txf : txfResults) {
            if (txf.isDisabled()) {
                resetGame++;
            }
        }
        if (resetGame == 15) {
            for (TextField txf : txfResults) {
                txf.setText("");
                txfSumOther.setText("");
                txfSumSame.setText("");
                txfTotal.setText("");
            }
        }
    }

    private void resetDice() {
        for (int i = 0; i < diceImageView.size(); i++) {
            diceImageView.get(i).setImage(letterImages.get(i));
            holdStatus[i] = false;
        }
    }

    private void setHoldStatus(boolean status) {
        for (CheckBox cbx : cbxHolds) {
            cbx.setDisable(status);
            if (status) {
                cbx.setSelected(false);
            }
        }
    }

    private void saveResults() {
        int total = 0;
        int sumSame = 0;
        int sumOther = 0;
        for (int i = 0; i < txfResults.size(); i++) {
            if (txfResults.get(i).isDisabled()) {
                if (i < 6) {
                    sumSame += Integer.parseInt(txfResults.get(i).getText());
                    if (sumSame >= 63) { // Bonus
                        total += 50;
                        txfBonus.setText("50");
                    }
                } else {
                    sumOther += Integer.parseInt(txfResults.get(i).getText());
                }
                total += Integer.parseInt(txfResults.get(i).getText());
            }
        }
        txfSumSame.setText(Integer.toString(sumSame));
        txfSumOther.setText(Integer.toString(sumOther));
        txfTotal.setText(Integer.toString(total));
    }

    private void updateCounter() {
        lblThrowCount.setText("ThrowCount: " + dice.getThrowCount());
    }

    private void resetTextFieldValues() {
        for (TextField txf : txfResults) {
            if (!txf.isDisabled()) {
                txf.setText("");
            }
            txf.setStyle("-fx-control-inner-background: white");
        }
    }

    private void lockCbx() {
        for (CheckBox cbx : cbxHolds) {
            if (cbx.isSelected()) {
                cbx.setDisable(true);
            }
        }
    }

    public void cbxHoldsAction() {
        for (int i = 0; i < cbxHolds.length; i++) {
            if (cbxHolds[i].isSelected()) {
                holdStatus[i] = true;
            }
        }
        int cbxCount = 0;
        for (CheckBox cbx : cbxHolds) {
            if (cbx.isSelected()) {
                cbxCount++;
            }
            if (cbxCount == 5) {
                btnThrow.setDisable(true);
            } else btnThrow.setDisable(false);
        }
    }

    // region # AUDIO PLAY METHODS #
    public void soundDiceShake() {
        diceShakePlayer.play();
        diceShakePlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                diceShakePlayer.stop();
                diceShakePlayer.seek(diceShakePlayer.getStartTime());
            }
        });
    }

    public void soundDiceRoll() {
        diceRollPlayer.play();
        diceRollPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                diceRollPlayer.stop();
                diceRollPlayer.seek(diceRollPlayer.getStartTime());
            }
        });
    }

    public void soundPop() {
        popPlayer.play();
        popPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                popPlayer.stop();
                popPlayer.seek(popPlayer.getStartTime());
            }
        });
    }
    // endregion
}