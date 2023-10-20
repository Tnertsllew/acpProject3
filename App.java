package uwf.fxproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	
	private Gui gui;

    @Override
    public void start(Stage stage) {
    	 gui = new Gui();
         stage.setScene(gui.buildScene());
         stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}