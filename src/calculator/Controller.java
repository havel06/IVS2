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

    /** předá text ze vstupního pole parseru, a jeho výstup vypíše do výstupního pole */
    private void submit() {
        try {
            output.setText(Double.toString(parser.parse(input.getText())));
        } catch (Exception e) {
            output.setText(e.getMessage());
        }
    }

    @FXML
    /** Stisknutí tlačítka submit v GUI.
     * @param event Událost stisknutí.
     */
    private void submitPressed(ActionEvent event) {
        submit();
    }

    @FXML
    /** Stistknutí jednoho z tlačítek (mimo submit, basckspace a clear) v GUI.
     * @param event Událost stisknutí.
     */
    private void virtualKeyboard(ActionEvent event) {
        Button button = (Button)event.getSource();
		int insert_pos = last_caret_pos;
        int caret_offset = 1;
        String button_text;

        if (button.getText().equals("√")) {
            button_text = "root(,)";
            caret_offset = 5;
        } else {
            button_text = button.getText();
        }

		input.insertText(last_caret_pos, button_text);
		input.requestFocus();
		input.positionCaret(insert_pos + caret_offset);
    }

    /** Smaže poslední znak. */
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
    /** Stisknutí tlačítka backspace v GUI.
     * @param event Událost stisknutí.
     */
    private void backspacePressed(ActionEvent event) {
        backspace();
    }

    @FXML
    /** Stisknutí tlačítka clear v GUI.
     * @param event Událost stisknutí.
     */
    private void clear(ActionEvent event) {
        input.setText("");
    }

    @FXML
    /** Stisk tlačítka Enter uživatelem.
     * @param event Událost stisknutí.
     */
    private void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            submit();
        }
    }
}
