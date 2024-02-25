package classEx.ex1.ex6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
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
        int y1 = 178; // start point: (x,y1)
        int y2 = 182; // end point: (x,y2)
        for (int i = 0; i < 11; i++) {
            int x = 10 + i * 15;
            if (i % 5 == 0) {
                Line line = new Line(x, y1 - 2, x, y2 + 2);
                Text text = new Text(x, y2 + 12, Integer.toString(i));
                pane.getChildren().addAll(line, text);
            } else {
                Line line = new Line(x, y1, x, y2);
                pane.getChildren().add(line);
            }
        }
        int x1 = 177;
        int x2 = 185;
        int y = 180;
        Line line = new Line(2, 180, 185, y); // vertical line
        Line line1 = new Line(x1, y - 3, x2, y); // arrowhead top
        Line line2 = new Line(x1, y + 3, x2, y); // arrowhead bottom
        pane.getChildren().addAll(line, line1, line2);
    }
}
