package application;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The Main Class of the application
 *
 */
public class Main extends Application {

    /**
     * This will be used as a splash screen for the application It will display some important data to the user and then disappear
     */
    SplashScreenController spashScreen = new SplashScreenController();

    @Override
    public void start(Stage primaryStage) {
	
	//Scene
	Scene scene = new Scene(new BorderPane(), 1024, 768);
	//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm())

	//Primary Stage
	primaryStage.setTitle("Example App");
	//primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon64.png")))
	primaryStage.setScene(scene);

	//Show the SplashScreen
	spashScreen.showWindow();

	//I am using the code below so the Primary Stage of the application 
	//doesn't appear for 2 seconds , so the splash screen is displayed
	PauseTransition splashScreenDelay = new PauseTransition(Duration.seconds(3));
	splashScreenDelay.setOnFinished(f -> {
	    primaryStage.show();
	    spashScreen.hideWindow();
	});
	splashScreenDelay.playFromStart();
    }

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
	launch(args);
    }

}
