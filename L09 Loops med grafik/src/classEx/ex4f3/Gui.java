package classEx.ex4f3;

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
        int x = 100; // center: (x,y)
        int y = 100;
        int h = 40;
        int w = 20;

        while (w <= 90) {
            Ellipse ellipse = new Ellipse(x, y, w, h);
            ellipse.setFill(null);
            ellipse.setStroke(Color.GREEN);
            pane.getChildren().add(ellipse);
            w += 10;
        }
    }
}
