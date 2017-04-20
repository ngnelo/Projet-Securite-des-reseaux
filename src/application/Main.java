package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			//set title of the main window
			primaryStage.setTitle("HASH CALCULATOR");
			// set the icon for the application 
	        primaryStage.getIcons().add(new Image("/ressources/icon.jpg"));
			//load the fxml file containing the windows (PANE, BUTTON, LABEL etc...) and it's component
			Parent root = FXMLLoader.load(getClass().getResource("/application/MyView.fxml"));
			Scene scene = new Scene(root);
			//Ad the css file for style effects on windows elements
			scene.getStylesheets().add
			 (Main.class.getResource("/application/application.css").toExternalForm());
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
