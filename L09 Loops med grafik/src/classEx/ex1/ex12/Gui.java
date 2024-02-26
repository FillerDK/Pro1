package classEx.ex1.ex12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
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
        int x = 20;
        int y = 100;
        int h = 81;

        drawTriangle(pane, x, y, h);
        drawInnerTriangle(pane, x, y, h);
    }
    private void drawTriangle(Pane pane, int x, int y, int h) {
        Polygon polygon = new Polygon(x, y, x + 2 * h, y, x + h, y - h);
        polygon.setStroke(Color.BLACK);
        polygon.setFill(null);
        pane.getChildren().add(polygon);
    }

    private void drawInnerTriangle(Pane pane, int x, int y, int h) {
        Polygon polygon = new Polygon(x, y, x, y);
        polygon.setStroke(Color. BLACK);
        polygon.setFill(null);
        pane.getChildren().addAll(polygon);
    }
}
