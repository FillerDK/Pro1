package classEx.ex1.ex1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
        // a.
        // draw an arrowhead at (100, 75)
        int x = 100;
        int y = 75;
        int sizeX = 2;
        Line line1 = new Line(x, y, x + 10 * sizeX, y - 4 * sizeX);
        Line line2 = new Line(x, y, x + 10 * sizeX, y + 4 * sizeX);
        pane.getChildren().addAll(line1, line2);

        // draw an arrowhead at (25, 140)
        x = 100;
        y = 125;
        Line line3 = new Line(x, y, x + 10 * sizeX, y - 4 * sizeX);
        Line line4 = new Line(x, y, x + 10 * sizeX, y + 4 * sizeX);
        pane.getChildren().addAll(line3, line4);

        // b
        // draw an arrowhead at (20, 50)
        x = 20;
        y = 50;
        Line line5 = new Line(x, y, x + 10 * sizeX, y - 4 * sizeX);
        Line line6 = new Line(x, y, x + 10 * sizeX, y + 4 * sizeX);
        pane.getChildren().addAll(line5, line6);
    }
}
