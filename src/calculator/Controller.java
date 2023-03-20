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

import math.Parser;

public class Controller implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private Label output;
    @FXML
    private TextField input;

    private Parser parser = new Parser();

    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void submitPressed(ActionEvent event) {
        try {
            output.setText(Double.toString(parser.parse(input.getText())));
        } catch (Exception e) {
            output.setText(e.getMessage());
        }

    }

    @FXML
    private void keyboardPressed(ActionEvent event) {
        Button button = (Button)event.getSource();

        input.setText(input.getText() + button.getText());
    } 

}
