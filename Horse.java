package uwf.fxproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Horse implements Runnable{
	private Canvas c;
	private Thread t;
	private boolean hasWon = false;
	private App app;
	private int horseNum;
	
	public Horse(App app, int horseNum) {
		 drawHorse();
		 this.app = app;
		 this.horseNum = horseNum;
	}

	private void drawHorse() {
		c = new Canvas(80, 80);
		GraphicsContext gc = c.getGraphicsContext2D();
		
		// Body
		gc.setFill(Color.BLACK);
		gc.fillRect(15, 15, 40, 20);

		// Head
		gc.fillRect(50, 10, 15, 17);

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
	
	public boolean getHasWon() {
		return hasWon;
	}
	
	public void startHorseThread() {
		t = new Thread(this);
		t.start();
	}

	public void stopHorse() {
		t.interrupt();
	}
	
	
	@Override
    public void run() {
		   Random rand = new Random();
		    while (true) {  // Continuously move the horse until interrupted
		    	app.l.lock();
		        double randomX = 5 + rand.nextInt(30);
		        double currentX = c.getTranslateX();
		        c.setTranslateX(currentX + randomX);

		        System.out.println(currentX);
		        try {
		            if (currentX > 620 && !hasWon) {
		                hasWon = true;
		                app.stopAll(horseNum);
		                System.out.println("Horse has won!" + horseNum);
		                break;
		            }
		        } finally {
		            app.l.unlock();
		        }
		        try {
		            Thread.sleep(50);
		        } catch (InterruptedException e) {
		        	System.out.println("thread interrupted");
		            break; // If the thread is interrupted, exit the loop
		            
		        }
		    }
    }
}