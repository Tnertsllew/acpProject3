package uwf.fxproject;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */

//critical section is who wins the race
public class App extends Application {
	
	private Horse[] horses;
	private BorderPane root;
	Lock l = new ReentrantLock();

    @Override
    public void start(Stage stage) {
         stage.setScene(buildScene());
         stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public void runRace() {
    	//loop to start the horses
    	for(int i = 0; i < 6; i++) {
    		horses[i].startHorseThread();
    	}
    }
    
    
    private Scene buildScene() {
		horses = new Horse[6];
		for(int i = 0; i < 6; i++) {
			horses[i] = new Horse(this, i);
		}
		root = new BorderPane();
		HBox buttonBox = new HBox(10);
		buttonBox.getChildren().addAll(createRunButton(), createResetButton(), createQuitButton());
		root.setBottom(buttonBox);
		VBox horseBox = new VBox();
		for(int i = 0; i < 6; i++) {
			horseBox.getChildren().add(horses[i].getCanvas());
		}
		root.getChildren().add(horseBox);
		root.getChildren().add(createFinishLine());
		Scene scene = new Scene(root, 800, 500);
		return scene;
	}
    
    public void stopAll(int winner)
    {
      for(int i = 0; i < 6; i++)
      {
    	  if(i != winner) {
    		  horses[i].stopHorse();
    	  }
      }
    }
    
    private Line createFinishLine() {
        Line finishLine = new Line();
        finishLine.setStartX(700);
        finishLine.setStartY(0);
        finishLine.setEndX(700);
        finishLine.setEndY(500);
        return finishLine;
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
		     for(int i = 0; i < 6 ; i++) {
		            horses[i].stopHorse();
		            horses[i].getCanvas().setTranslateX(0);  // reset position
		        }
        });
		return reset;
	}

	private Button createRunButton() {
		Button run = new Button("Run");
		run.setOnAction(event -> {
			runRace();
        });
		return run;
	}

}