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
	private int last_caret_pos = 0;

    public void initialize(URL location, ResourceBundle resources) {
		input.textProperty().addListener((observable, prev_val, new_val) -> {
			last_caret_pos = input.getCaretPosition();
		});
		input.focusedProperty().addListener((observable, prev_val, new_val) -> {
			last_caret_pos = input.getCaretPosition();
		});
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
    private void virtualKeyboard(ActionEvent event) {
        Button button = (Button)event.getSource();
		int insert_pos = last_caret_pos;
		input.insertText(last_caret_pos, button.getText());
		input.requestFocus();
		input.positionCaret(insert_pos + 1);
    }

    private void backspace() {
        String inputText = input.getText();

		if (inputText.length() == 0) {
			return;
		}
		int delete_pos = last_caret_pos - 1;
		StringBuilder builder = new StringBuilder(input.getText());
		builder.deleteCharAt(delete_pos);
		input.setText(builder.toString());
		input.requestFocus();
		input.positionCaret(delete_pos);
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
