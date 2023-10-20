package uwf.fxproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Horse implements Runnable{
	private Canvas c;
	
	public Horse() {
		draw();
	}

	private void draw() {
		c = new Canvas(80, 80);
		GraphicsContext gc = c.getGraphicsContext2D();
		
		// Body
		gc.setFill(Color.BLACK);
		gc.fillOval(15, 15, 40, 20);

		// Head
		gc.fillOval(50, 10, 15, 17);

		// Legs
		gc.fillRect(20, 32, 3, 15);  // Front left leg
		gc.fillRect(26, 32, 3, 15); // Front right leg
		gc.fillRect(40, 32, 3, 15); // Rear left leg
		gc.fillRect(46, 32, 3, 15); // Rear right leg

		// Tail
		gc.fillRect(8, 22, 10, 3);
	}
	
	public Canvas getCanvas() {
		return c;
	}
	
	@Override
    public void run() {
        
    }
}
