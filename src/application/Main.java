package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	

	
	@Override
	public void start(Stage ps) {
		ps.setTitle("Animation example");
		Group rout = new Group();
		Scene theScene =new Scene(rout);
		ps.setScene(theScene);
		
		Canvas canvas = new Canvas(512,512);
		rout.getChildren().add(canvas);
		
		Image earth =new Image("earth.png");
		Image sun =new Image("sun.png");
		Image space =new Image("space.png");
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		final long startNanoTime = System.nanoTime();
	//	System.out.println(startNanoTime);
		
	AnimatedImage ufo = new AnimatedImage();
	Image[] imageArray = new Image[6];
	for(int i=0;i<6;i++) {
		imageArray [i] = new Image ("ufo_"+i+".png");
	}
	ufo.frames =imageArray;
	ufo.duration = 1;

		new AnimationTimer() {

			@Override
			public void handle(long t) {
				double diff = (t- startNanoTime)/1000000000.0;
				double x = 230 + 128*Math.cos(diff);
				double y = 230 + 128*Math.sin(diff);
				gc.drawImage(space, 0, 0);
				gc.drawImage(earth, x, y);
				gc.drawImage(sun,196,196);
				gc.drawImage(ufo.getFrame(diff), 450, 40);
				
				
			}
	
		}.start();
	// gc.drawImage(sun, 196, 196);
		ps.show();
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
