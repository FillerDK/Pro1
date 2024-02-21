package classEx.ex7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
        substring(pane);
    }

    public static void substring (Pane pane) {
        String str = "Datamatiker";
        for (int i = 0, x = 10, y = 10; i <= str.length(); i++, y +=10) {
            Text text = new Text(x, y, str.substring(0,i));
            pane.getChildren().add(text);
        }
    }
}
