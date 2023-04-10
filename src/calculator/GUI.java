package calculator;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Window;

public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CalQl8r");
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("calculator.fxml"));
            Scene scene = new Scene(root, 306, 400);

            primaryStage.setResizable(false);
            primaryStage.setScene(scene);

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            // System.exit(1);
        }

        primaryStage.show();
    }

    public static void run(String[] args) {
        launch();
    }
}
