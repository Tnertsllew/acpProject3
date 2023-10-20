package uwf.fxproject;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Gui {
	
	private Horse[] horses;
	
	public Scene buildScene() {
		horses = new Horse[6];
		for(int i = 0; i < 6; i++) {
			horses[i] = new Horse();
		}
		BorderPane root = new BorderPane();
		HBox buttonBox = new HBox(10);
		buttonBox.getChildren().addAll(createRunButton(), createResetButton(), createQuitButton());
		root.setTop(buttonBox);
		VBox horseBox = new VBox();
		for(int i = 0; i < 6; i++) {
			horseBox.getChildren().add(horses[i].getCanvas());
		}
		root.setLeft(horseBox);
		Scene scene = new Scene(root, 800, 500);
		return scene;
	}
	
	private Button createQuitButton() {
		Button quit = new Button("Quit");
		quit.setOnAction(event -> {
			System.exit(0);
        });
		return quit;
	}
	
	private Button createResetButton() {
		Button reset = new Button("Reset");
		reset.setOnAction(event -> {
        	
        });
		return reset;
	}

	private Button createRunButton() {
		Button run = new Button("Run");
		run.setOnAction(event -> {
        	
        });
		return run;
	}

}
