package gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.YatzyDice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;

public class YatzyGui extends Application {
    public YatzyGui() throws FileNotFoundException {
    }

    private YatzyDice dice = new YatzyDice();

    // region # AUDIO #
    Media tatsuroMedia = new Media(new File("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\wavFiles\\tatsuro.wav").toURI().toString());
    Media diceRollMedia = new Media(new File("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\wavFiles\\diceRoll.wav").toURI().toString());
    Media diceShakeMedia = new Media(new File("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\wavFiles\\diceShake.wav").toURI().toString());
    Media popMedia = new Media(new File("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\wavFiles\\pop.wav").toURI().toString());
    MediaPlayer tatsuroPlayer = new MediaPlayer(tatsuroMedia);
    MediaPlayer diceRollPlayer = new MediaPlayer(diceRollMedia);
    MediaPlayer diceShakePlayer = new MediaPlayer(diceShakeMedia);
    MediaPlayer popPlayer = new MediaPlayer(popMedia);
    // endregion

    Stage window;
    Scene mainScene, gameScene, settingsScene;

    private final String[] colorSchemes = {"Choose color scheme:", "Dark-mode", "Classic", "Funky"};
    private final ComboBox cbxColorScheme = new ComboBox(FXCollections.observableArrayList(colorSchemes));
    private String currentColorScheme = "Dark-mode";
    private Color currentTextColor = Color.WHITE;
    private String backgroundColor = "-fx-background-color: black ; ";

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;

        // Gridpanes
        GridPane gamePane = new GridPane(); // gameplay pane
        gamePane.setStyle(backgroundColor);
        GridPane dicePane = new GridPane();
        gamePane.add(dicePane, 0, 0);
        GridPane scorePane = new GridPane();
        gamePane.add(scorePane, 0, 1);
        GridPane mainPane = new GridPane(); // main menu pane
        mainPane.setStyle(backgroundColor);
        mainPane.setPadding(new Insets(10));
        GridPane mainInnerPane = new GridPane(); // main menu inner pane
        mainInnerPane.setHgap(10);
        mainInnerPane.setVgap(10);
        mainInnerPane.setPadding(new Insets(10)); // setting padding for fake margin
        mainInnerPane.setStyle(setCustomStyle(currentColorScheme));
        GridPane settingsPane = new GridPane(); // settings pane
        settingsPane.setStyle(backgroundColor);
        settingsPane.setPadding(new Insets(10, 0, 10, 10));
        GridPane settingsInnerPane = new GridPane(); // settings inner pane
        settingsInnerPane.setHgap(10);
        settingsInnerPane.setVgap(10);
        settingsInnerPane.setPadding(new Insets(10));
        settingsInnerPane.setStyle(setCustomStyle(currentColorScheme));

        this.gameContent(gamePane, dicePane, scorePane);

        // all the scenes
        Scene gameScene = new Scene(gamePane);
        Scene mainScene = new Scene(mainPane, 510, 245);
        Scene settingsScene = new Scene(settingsPane, 510, 205);

        // main scene elements
        Label lblWelcome = new Label("Yatzy");
        lblWelcome.setFont(setCustomFont("PublicPixel-z84yD", 91));
        lblWelcome.setTextFill(currentTextColor);
        GridPane.setHalignment(lblWelcome, HPos.RIGHT);

        Button btnPlay = new Button("Play");
        mainInnerPane.add(btnPlay, 0, 1);
        btnPlay.setFont(setCustomFont("PublicPixel-z84yD", 20));
        btnPlay.setFocusTraversable(false);
        GridPane.setHalignment(btnPlay, HPos.CENTER);

        Button btnSettings = new Button("Settings");
        mainInnerPane.add(btnSettings, 0, 2);
        btnSettings.setFont(setCustomFont("PublicPixel-z84yD", 20));
        btnSettings.setFocusTraversable(false);
        GridPane.setHalignment(btnSettings, HPos.CENTER);

        // main scene actions
        btnPlay.setOnAction(event -> {
            window.setScene(gameScene);
            window.setTitle("Yatzy");
            tatsuroPlayer.setVolume(0.4);
            tatsuroPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            tatsuroPlayer.play();
            if (!cbxColorScheme.getValue().toString().equals("Choose color scheme:")) {
                gamePane.setStyle(backgroundColor);
                dicePane.setStyle(setCustomStyle(currentColorScheme));
                scorePane.setStyle(setCustomStyle(currentColorScheme));
                lblThrowCount.setTextFill(currentTextColor);
                for (int i = 0; i < 5; i++)
                    cbxHolds[i].setTextFill(currentTextColor);
                for (int i = 0; i < 15; i++)
                    numLabels.get(i).setTextFill(currentTextColor);
                lblSumSame.setTextFill(currentTextColor);
                lblBonus.setTextFill(currentTextColor);
                lblSumOther.setTextFill(currentTextColor);
                lblTotal.setTextFill(currentTextColor);

            }
        });
        btnSettings.setOnAction(event -> {
            window.setScene(settingsScene);
            window.setTitle("Settings");
        });

        // innner pane in pane to create margin effect
        mainInnerPane.add(lblWelcome, 0, 0);
        mainPane.add(mainInnerPane, 0, 0);

        // settings elements
        Label lblTitle = new Label("Settings");
        lblTitle.setFont(setCustomFont("PublicPixel-z84yD", 56));
        lblTitle.setTextFill(currentTextColor);
        lblTitle.setUnderline(true);
        lblTitle.setPadding(new Insets(0, 0, 10, 0));
        GridPane.setHalignment(lblTitle, HPos.CENTER);

        Button btnBack = new Button("Back");
        btnBack.setFont(setCustomFont("PublicPixel-z84yD", 20));
        btnBack.setTextFill(Color.BLACK);
        btnBack.setFocusTraversable(false);
        btnBack.setUnderline(true);
        GridPane.setHalignment(btnBack, HPos.LEFT);

        cbxColorScheme.getSelectionModel().selectFirst();
        GridPane.setHalignment(cbxColorScheme, HPos.CENTER);
        cbxColorScheme.setFocusTraversable(false);
        settingsInnerPane.add(lblTitle, 0, 0);
        settingsInnerPane.add(cbxColorScheme, 0, 1);

        settingsInnerPane.add(btnBack, 0, 2);
        btnBack.setOnAction(event -> {
            window.setScene(mainScene);
            window.setTitle("Main Menu");
            if (!cbxColorScheme.getValue().toString().equals("Choose color scheme:")) {
                lblWelcome.setTextFill(currentTextColor);
                mainPane.setStyle(backgroundColor);
                mainInnerPane.setStyle(setCustomStyle(currentColorScheme));
            }
        });

        Button btnApply = new Button("Apply");
        btnApply.setFont(setCustomFont("PublicPixel-z84yD", 20));
        btnApply.setTextFill(Color.BLACK);
        btnApply.setFocusTraversable(false);
        GridPane.setHalignment(btnApply, HPos.RIGHT);

        settingsInnerPane.add(btnApply, 0, 2);
        btnApply.setOnAction(event -> {
            if (!cbxColorScheme.getValue().toString().equals("Choose color scheme:")) {
                settingsInnerPane.setStyle(setCustomStyle(currentColorScheme));
                currentTextColor = setCustomColor();
                backgroundColor = setCustomBackgroundColor();
                currentColorScheme = cbxColorScheme.getValue().toString();
                lblTitle.setTextFill(currentTextColor);
                settingsPane.setStyle(backgroundColor);
            }
        });

        btnMainMenu.setOnAction(event -> {
            window.setScene(mainScene);
            window.setTitle("Main Menu");
        });

        // inner pane in pane to create margin effect
        settingsPane.add(settingsInnerPane, 0, 0);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Main Menu");
        primaryStage.setResizable(false);
        primaryStage.show();
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

    private final Button btnResetGame = new Button("Reset\nGame");
    private final Button btnMute = new Button("Mute");
    private final Button btnMainMenu = new Button("Main\nMenu");

    private final Label lblSumSame = new Label("Sum");
    private final Label lblBonus = new Label("Bonus");
    private final Label lblSumOther = new Label("Sum");
    private final Label lblTotal = new Label("TOTAL");

    DiceImage diceImage = new DiceImage();
    ImageView imageViewDice1 = new ImageView(diceImage.y1Image);
    ImageView imageViewDice2 = new ImageView(diceImage.aImage);
    ImageView imageViewDice3 = new ImageView(diceImage.tImage);
    ImageView imageViewDice4 = new ImageView(diceImage.zImage);
    ImageView imageViewDice5 = new ImageView(diceImage.y2Image);

    ArrayList<ImageView> diceImageView = new ArrayList<ImageView>(5);
    ArrayList<Image> diceImagesDark = new ArrayList<Image>(6);
    ArrayList<Image> diceImagesClassic = new ArrayList<Image>(6);
    ArrayList<Image> diceImagesFunky = new ArrayList<Image>(6);
    ArrayList<Image> diceGifsDark = new ArrayList<Image>(5);
    ArrayList<Image> diceGifsClassic = new ArrayList<Image>(5);
    ArrayList<Image> diceGifsFunky = new ArrayList<Image>(5);
    ArrayList<Image> letterImages = new ArrayList<Image>(5);
    ArrayList<Label> numLabels = new ArrayList<>(5);

    boolean[] holdStatus = new boolean[5];
    private boolean canChoose;

    private void gameContent(GridPane pane, GridPane dicePane, GridPane scorePane) throws FileNotFoundException {

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ======================== U P P E R - P A N E =====================
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(20);
        dicePane.setStyle(setCustomStyle(currentColorScheme));

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

        // Dark-mode images
        for (int i = 0; i < 6; i++) {
            diceImagesDark.add(diceImage.getImageDiceDark(i));
        }
        for (int i = 0; i < 6; i++) {
            diceGifsDark.add(diceImage.getGifImageDark(i));
        }

        // Classic images
        for (int i = 0; i < 6; i++) {
            diceImagesClassic.add(diceImage.getImageDiceClassic(i));
        }
        for (int i = 0; i < 6; i++) {
            diceGifsClassic.add(diceImage.getGifImageClassic(i));
        }

        // Funky images
        for (int i = 0; i < 6; i++) {
            diceImagesFunky.add(diceImage.getImageDiceFunky(i));
        }
        for (int i = 0; i < 6; i++) {
            diceGifsFunky.add(diceImage.getGifImageFunky(i));
        }

        // endregion

        for (int i = 0; i < 5; i++) {
            VBox vBox = new VBox();
            txfValues[i] = new TextField();
            txfValues[i].setPrefSize(75, 75);
            cbxHolds[i] = new CheckBox("Hold");
            cbxHolds[i].setDisable(true);
            cbxHolds[i].setFocusTraversable(false);
            cbxHolds[i].setOnAction(event -> cbxHoldsAction());
            cbxHolds[i].setFont(setCustomFont("PublicPixel-z84yD", 10));
            cbxHolds[i].setTextFill(currentTextColor);
            vBox.getChildren().addAll(diceImageView.get(i), cbxHolds[i]);
            vBox.setSpacing(10);
            vBox.setAlignment(Pos.CENTER);
            diceBox.getChildren().add(vBox);
        }
        dicePane.add(lblThrowCount, 0, 1);
        lblThrowCount.setFont(setCustomFont("PublicPixel-z84yD", 10));
        lblThrowCount.setTextFill(currentTextColor);
        dicePane.add(btnThrow, 0, 1);
        btnThrow.setFocusTraversable(false);
        btnThrow.setFont(setCustomFont("PublicPixel-z84yD", 10));
        btnThrow.setTextFill(Color.BLACK);
        btnThrow.setOnAction(event -> {
            throwAction();
        });
        GridPane.setHalignment(btnThrow, HPos.RIGHT);


        // ======================== L O W E R - P A N E =====================

        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setMinWidth(dicePane.getWidth());
        int txfWidth = 50;
        scorePane.setStyle(setCustomStyle(currentColorScheme));

        for (ImageView imageView : diceImageView) {
            imageView.setFitHeight(75);
            imageView.setFitWidth(75);
        }

        for (int i = 0; i < 6; i++) {
            String str = (i + 1) + "-s";
            numLabels.add(new Label(String.format("%-5s", str)));
            numLabels.get(i).setFont(setCustomFont("PublicPixel-z84yD", 10));
            numLabels.get(i).setTextFill(currentTextColor);
            txfResults.add(new TextField());
            txfResults.get(i).setPrefWidth(txfWidth);
            txfResults.get(i).setEditable(false);
            txfResults.get(i).setFocusTraversable(false);
            scorePane.add(numLabels.get(i), 1, i);
            scorePane.add(txfResults.get(i), 2, i);
        }

        for (int i = 6; i < 15; i++) {
            numLabels.add(new Label(String.format("%-12s", strResult[i - 6])));
            txfResults.add(new TextField());
            numLabels.get(i).setFont(setCustomFont("PublicPixel-z84yD", 10));
            numLabels.get(i).setTextFill(currentTextColor);
            txfResults.get(i).setPrefWidth(txfWidth);
            txfResults.get(i).setEditable(false);
            txfResults.get(i).setFocusTraversable(false);
            scorePane.add(numLabels.get(i), 6, i - 6);
            scorePane.add(txfResults.get(i), 5, i - 6);
        }

        // region # STATIC SUM LABELS AND FIELDS #
        lblSumSame.setFont(setCustomFont("PublicPixel-z84yD", 10));
        lblSumSame.setTextFill(currentTextColor);
        txfSumSame.setPrefWidth(txfWidth);
        txfSumSame.setFocusTraversable(false);
        txfSumSame.setEditable(false);
        txfSumSame.setMouseTransparent(true);
        scorePane.add(lblSumSame, 1, 12);
        scorePane.add(txfSumSame, 2, 12);

        lblBonus.setFont(setCustomFont("PublicPixel-z84yD", 10));
        lblBonus.setTextFill(currentTextColor);
        txfBonus.setPrefWidth(txfWidth);
        txfBonus.setFocusTraversable(false);
        txfBonus.setEditable(false);
        txfBonus.setMouseTransparent(true);
        scorePane.add(lblBonus, 1, 11);
        scorePane.add(txfBonus, 2, 11);

        lblSumOther.setFont(setCustomFont("PublicPixel-z84yD", 10));
        lblSumOther.setTextFill(currentTextColor);
        txfSumOther.setPrefWidth(txfWidth);
        txfSumOther.setFocusTraversable(false);
        txfSumOther.setEditable(false);
        txfSumOther.setMouseTransparent(true);
        scorePane.add(lblSumOther, 6, 11);
        scorePane.add(txfSumOther, 5, 11);

        lblTotal.setFont(setCustomFont("PublicPixel-z84yD", 10));
        lblTotal.setTextFill(currentTextColor);
        txfTotal.setPrefWidth(txfWidth);
        txfTotal.setFocusTraversable(false);
        txfTotal.setEditable(false);
        txfTotal.setMouseTransparent(true);
        scorePane.add(lblTotal, 6, 12);
        scorePane.add(txfTotal, 5, 12);

        btnResetGame.setFont(setCustomFont("PublicPixel-z84yD", 15));
        btnResetGame.setTextAlignment(TextAlignment.CENTER);
        btnResetGame.setPrefWidth(115);
        btnResetGame.setFocusTraversable(false);
        btnResetGame.setTextFill(Color.BLACK);
        GridPane.setValignment(btnResetGame, VPos.CENTER);

        btnMute.setFont(setCustomFont("PublicPixel-z84yD", 15));
        btnMute.setPrefWidth(115);
        btnMute.setFocusTraversable(false);
        btnMute.setTextFill(Color.BLACK);
        GridPane.setValignment(btnMute, VPos.CENTER);

        btnMainMenu.setFont(setCustomFont("PublicPixel-z84yD", 15));
        btnMainMenu.setPrefWidth(115);
        btnMainMenu.setFocusTraversable(false);
        btnMainMenu.setTextFill(Color.BLACK);
        GridPane.setValignment(btnMainMenu, VPos.CENTER);

        scorePane.add(btnResetGame, 7, 0, 1, 2);
        scorePane.add(btnMute, 7, 2);
        scorePane.add(btnMainMenu, 7, 11, 1, 2);

        btnResetGame.setOnAction(event -> {
            resetGame();
            btnResetGame.setText("Reset\nGame");
        });

        btnMute.setOnAction(event -> {
            if (btnMute.getText().equals("Unmute")) tatsuroPlayer.setVolume(0.4);
            else tatsuroPlayer.setVolume(0);

            if (btnMute.getText().equals("Mute")) btnMute.setText("Unmute");
            else btnMute.setText("Mute");
        });
        // endregion
    }

    // ======================= M E T H O D S ====================================

    public String getCurrentColorScheme() {
        return currentColorScheme;
    }

    private void setImageTheme(int i, int value) {
        if (currentColorScheme.equals("Dark-mode")) {
            diceImageView.get(i).setImage(diceImagesDark.get(value - 1));
        } else if (currentColorScheme.equals("Classic")) {
            diceImageView.get(i).setImage(diceImagesClassic.get(value - 1));
        } else if (currentColorScheme.equals("Funky")) {
            diceImageView.get(i).setImage(diceImagesFunky.get(value - 1));
        }
    }

    private void setGifTheme(int i) {
        if (currentColorScheme.equals("Dark-mode")) {
            diceImageView.get(i).setImage(diceGifsDark.get(i));
        } else if (currentColorScheme.equals("Classic")) {
            diceImageView.get(i).setImage(diceGifsClassic.get(i));
        } else if (currentColorScheme.equals("Funky")) {
            diceImageView.get(i).setImage(diceGifsFunky.get(i));
        }
    }

    private Color setCustomColor() {
        Color newColor = Color.BLACK;
        if (currentColorScheme.equals("Dark-mode")) {
            newColor = Color.WHITE;
        } else if (currentColorScheme.equals("Classic")) {
            newColor = Color.BLACK;
        } else if (currentColorScheme.equals("Funky")) {
            newColor = Color.rgb(255,178,0);
        }
        return newColor;
    }

    private String setCustomBackgroundColor() {
        String newBackgroundColor = "";
        if (currentColorScheme.equals("Dark-mode")) {
            newBackgroundColor = "-fx-background-color: black ; ";
        } else if (currentColorScheme.equals("Classic")) {
            newBackgroundColor = "-fx-background-color: beige ; ";
        } else if (currentColorScheme.equals("Funky")) {
            newBackgroundColor = "-fx-background-color: pink ; ";
        }
        return newBackgroundColor;
    }

    private Font setCustomFont(String name, int size) throws FileNotFoundException {
        Font font = Font.loadFont(new FileInputStream(String.format("C:\\Users\\phili\\Desktop\\Datamatiker\\1. semester\\Pro-1\\Pro1\\L20 - Projekt Yatzy Final\\src\\resources\\fonts\\%s.ttf", name)), size);
        return font;
    }

    private String setCustomStyle(String colorScheme) {
        String customStyle = "";
        if (colorScheme.equals("Dark-mode")) {
            customStyle = String.format("-fx-border-radius: 10px ; " +
                    "-fx-border-width: 5px ; " +
                    "-fx-border-color: purple ; " +
                    "-fx-border-style: solid ; " +
                    "-fx-background-color: black ; ");
        } else if (colorScheme.equals("Classic")) {
            customStyle = String.format("-fx-border-radius: 10px ; " +
                    "-fx-border-width: 5px ; " +
                    "-fx-border-color: black ; " +
                    "-fx-border-style: solid ; " +
                    "-fx-background-color: beige ; ");
        } else if (colorScheme.equals("Funky")) {
            customStyle = String.format("-fx-border-radius: 10px ; " +
                    "-fx-border-width: 5px ; " +
                    "-fx-border-color: blue ; " +
                    "-fx-border-style: solid ; " +
                    "-fx-background-color: pink ; ");
        }
        return customStyle;
    }

    private void throwAction() {
        throwDice();
        updateCounter();
        lockCbx();
        playGif();
    }

    private void playGif() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (CheckBox cbx : cbxHolds) {
                    cbx.setDisable(true);
                }

                soundDiceShake();
                for (int i = 0; i < 5; i++) {
                    if (!cbxHolds[i].isSelected()) {
                        setGifTheme(i);
                    }
                }
            }
        });
        t1.start();
    }

    private void throwDice() {
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
                        setImageTheme(i, value);
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
                txfResultAction();
            }
        });
        t2.start();
    }

    private void printTextFieldValues() {
        for (int i = 0; i < txfResults.size(); i++) {
            if (!txfResults.get(i).isDisabled()) {
                txfResults.get(i).setText(String.valueOf(dice.getResults()[i + 1]));
                if (Integer.parseInt(txfResults.get(i).getText()) != 0) {
                    if (currentColorScheme.equals("Dark-mode")) {
                        txfResults.get(i).setStyle("-fx-control-inner-background: #863fa2");
                    } else if (currentColorScheme.equals("Classic")) {
                        txfResults.get(i).setStyle("-fx-control-inner-background: grey ; ");
                    } else if (currentColorScheme.equals("Funky")) {
                        txfResults.get(i).setStyle("-fx-control-inner-background: blue ; ");
                    }
                } else {
                    txfResults.get(i).setStyle("-fx-control-inner-background: white");
                }
            }
        }
        canChoose = true;
    }

    private void txfResultAction() {
        for (TextField txf : txfResults) {
            txf.setOnMouseClicked(event -> {
                if (!canChoose) {
                    return;
                } else {
                    TextField result = (TextField) event.getSource();
                    if (dice.getThrowCount() > 0) {
                        result.setDisable(true);
                        soundPop();
                    }
                    resetTextFieldValues();
                    saveResults();
                    setHoldStatus(true);
                    canChoose = false;
                    btnThrow.setDisable(false);
                    dice.resetThrowCount();
                    resetDice();
                    newGame();
                }
            });
        }
    }

    private void newGame() {
        int newGame = 0;
        for (TextField txf : txfResults) {
            if (txf.isDisabled()) {
                newGame++;
            }
        }
        if (newGame == 15) {
            btnResetGame.setText("New\nGame");
        }
    }

    private void resetGame() {
        for (TextField txf : txfResults) {
            txf.setText("");
            txf.setDisable(false);
            txfSumOther.setText("");
            txfSumSame.setText("");
            txfBonus.setText("");
            txfTotal.setText("");
        }
        for (int i = 0; i < txfResults.size(); i++) {
            txfResults.get(i).setStyle("-fx-control-inner-background: white");
        }
        for (int i = 0; i < 5; i++) {
            cbxHolds[i].setDisable(true);
        }
        resetDice();
        btnThrow.setDisable(false);
        dice.resetThrowCount();
        lblThrowCount.setText("ThrowCount: 0");
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

    private void cbxHoldsAction() {
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
    private void soundDiceShake() {
        diceShakePlayer.play();
        diceShakePlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                diceShakePlayer.stop();
                diceShakePlayer.seek(diceShakePlayer.getStartTime());
            }
        });
    }

    private void soundDiceRoll() {
        diceRollPlayer.play();
        diceRollPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                diceRollPlayer.stop();
                diceRollPlayer.seek(diceRollPlayer.getStartTime());
            }
        });
    }

    private void soundPop() {
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