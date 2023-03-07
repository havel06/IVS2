package calculator;

import javafx.stage.Stage;
import javafx.application.Application;

public class GUI extends Application
{
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
    }

	public static void run(String[] args) {
        launch(GUI.class, args);
    }
}

