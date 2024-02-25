package classEx.ex1.ex10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops"); // may be changed
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(200, 200); // may be changed
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Circle circle1 = new Circle(100, 100, 30);
        circle1.setFill(Color.GOLD);
        circle1.setStroke(Color.BLACK);
        Circle circle2 = new Circle(100, 100, 25);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);
        pane.getChildren().addAll(circle1, circle2);

        Ellipse ellipse = new Ellipse(100, 70, 13, 6);
        ellipse.setFill(Color.RED);
        ellipse.setStroke(Color.RED);
        pane.getChildren().add(ellipse);

        /*
        drawRing(pane, 50, 50);
        drawRing(pane, 150, 50);
        drawRing(pane, 50, 150);
        drawRing(pane, 150, 150);
        */
    }

    private void drawRing (Pane pane, int x, int y) {
        Circle circle = new Circle(x, y, 50);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);
    }
}
