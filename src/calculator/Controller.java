package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javax.swing.Action;
import javafx.event.ActionEvent;

public class Controller implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private Label output;
    @FXML
    private TextField input;

    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void submitPressed(ActionEvent event) {
        output.setText(input.getText());
    }

}
