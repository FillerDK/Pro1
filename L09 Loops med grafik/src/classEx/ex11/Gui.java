package classEx.ex11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        int x = 50; // center: (x,y)
        int y = 100;
        int r = 40; // radius: r

        while (x <= 150) {
            Circle circle = new Circle(x, y, r);
            circle.setFill(null);
            circle.setStroke(Color.BLACK);
            Line line1 = new Line(x - 5, y, x + 5, y);
            Line line2 = new Line(x, y - 5, x, y + 5);
            pane.getChildren().addAll(circle, line1, line2);
            x += 25;
        }
    }
}
