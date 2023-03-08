package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;

import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Button testButton1;
    private Label testLabel1;

    public Controller() {
    };

    @FXML
    private void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void pressed(ActionEvent event) {
        testLabel1.setText("asdg");
    }

}
