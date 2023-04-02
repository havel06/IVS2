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

import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

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

    private void submit() {
        try {
            output.setText(Double.toString(parser.parse(input.getText())));
        } catch (Exception e) {
            output.setText(e.getMessage());
        }
    }

    @FXML
    private void submitPressed(ActionEvent event) {
        submit();
    }

    @FXML
    private void keyboardPressed(ActionEvent event) {
        Button button = (Button)event.getSource();

        input.setText(input.getText() + button.getText());
    } 

    private void backspace() {
        String inputText = input.getText();

        if (inputText.length() > 0) {
            input.setText(inputText.substring(0, inputText.length() - 1));
        }
    }

    @FXML
    private void backspacePressed(ActionEvent event) {
        backspace();
    }

    @FXML
    private void clear(ActionEvent event) {
        input.setText("");
    }

    @FXML
    private void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            submit();
        }

        /* 
        // nefunguje správně - mažou se dva znaky
        if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
            backspace();
        }
        */
        //keyEvent.consume();
    }
}
