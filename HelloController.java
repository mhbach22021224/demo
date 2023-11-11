package com.example.dictionaryyy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {

    Dictionary dictionary = new Dictionary();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    @FXML
    private TextField input;
    @FXML
    private TextField output;
    @FXML
    private Button sub;

    @FXML
    private Button but1;
    @FXML
    private Button bt1;

    @FXML
    private Button but2;

    @FXML
    private Button but3;

    @FXML
    private Button but4;

    @FXML
    private Label but5;

    public void LoadFile(ActionEvent event) throws IOException {
        if(event.getSource()==bt1){
            dictionaryManagement.inserFromFile (dictionary);
        }
    }

    @FXML
    public void suKienBanPhim(ActionEvent event) {

        if (event.getSource() == but1) {

            but5.setText("Add Word )");
            String tudungnguoinhan = input.getText();
            if (event.getSource() == sub) {
                output.setText(dictionary.getVie(tudungnguoinhan));
            }
        } else if (event.getSource() == but2) {
            but5.setText("Update Word )");
        } else if (event.getSource() == but3) {
            but5.setText("Remove Word )");
        } else if (event.getSource() == but4) {
            but5.setText("Search Word )");
        }
        String tudungnguoinhan = input.getText();
        if (event.getSource() == sub) {
            output.setText(dictionary.getVie(tudungnguoinhan));
        }
    }
}
