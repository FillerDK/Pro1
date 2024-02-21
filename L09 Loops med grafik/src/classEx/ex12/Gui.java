package classEx.ex12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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
        int x1 = 18; // left point
        int y1 = 131;
        int x2 = 99; // top point
        int y2 = 50;
        int x3 = 180; // right point
        int y3 = 131;
        for (int i = 0; i < 1; i++) {
            Polygon polygon = new Polygon(x1, y1, x2, y2, x3, y3);
            polygon.setStroke(Color.BLACK);
            polygon.setFill(null);
            pane.getChildren().add(polygon);

        }
    }

    private void drawInnerTriangle(int x, int y, int h) {

    }
}
