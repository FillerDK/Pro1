package classEx.exercises.ex4f2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        int x = 20; // center: (x,y)
        int y = 100;
        int r = 10; // radius: r

        while (r <= 80) {
            Circle circle = new Circle(x, y, r);
            circle.setFill(null);
            circle.setStroke(Color.BLACK);
            pane.getChildren().add(circle);
            r += 10;
            x += 10;
        }
    }
}
