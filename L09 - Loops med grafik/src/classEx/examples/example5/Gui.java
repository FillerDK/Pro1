package classEx.examples.example5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
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
        Ellipse ellipse = new Ellipse(100, 100, 80, 25);
        ellipse.setFill(Color.LIGHTSKYBLUE);
        ellipse.setStroke(Color.BLACK);
        pane.getChildren().add(ellipse);

        Circle circle = new Circle(100, 100, 40);
        circle.setFill(null);
        circle.setStroke(Color.RED);
        pane.getChildren().add(circle);
    }
}
