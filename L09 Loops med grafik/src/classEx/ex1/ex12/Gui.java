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
        drawInnerTriangle(pane, x, y, x + (2 * h/3), y - (2 * h/3), x, y - (h/3), h);

    }
    private void drawTriangle(Pane pane, int x, int y, int h) {
        Polygon polygon = new Polygon(x, y, x + 2 * h, y, x + h, y - h);
        polygon.setStroke(Color.BLACK);
        polygon.setFill(null);
        pane.getChildren().add(polygon);
    }

    // x + (2 * h / 3)

    private void drawInnerTriangle(Pane pane, int x1, int y1, int x2, int y2, int x3, int y3, int h) {
        Polygon polygon = new Polygon(x1, y1, x2, y1, x1 + (h/3), y1 - (h/3));
        polygon.setStroke(Color. BLACK);
        polygon.setFill(null);

        Polygon polygon2 = new Polygon(x2 + (2 * h/3), y1, x1 + 2 * h, y1, x2 + h, y3);
        polygon2.setStroke(Color. BLACK);
        polygon2.setFill(null);

        Polygon polygon3 = new Polygon(x2, y2, x2 + (2 * h/3), y2, x3 + h, y1 - h);
        polygon3.setStroke(Color. BLACK);
        polygon3.setFill(null);
        pane.getChildren().addAll(polygon, polygon2, polygon3);
    }
}
