package gui;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminScene {

    public static void adminScene(GridPane pane) {
        Gui.gPaneDefault(pane);

        initContent(pane);

    }

    private static void initContent(GridPane pane) {
        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        pane.add(tabPane, 0, 0);
    }

    private static void initTabPane(TabPane tabPane) {

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabLister = new Tab("Lister");
        tabPane.getTabs().add(tabLister);

        ListerPane listerPane = new ListerPane();
        tabLister.setContent(listerPane);


    }


}
