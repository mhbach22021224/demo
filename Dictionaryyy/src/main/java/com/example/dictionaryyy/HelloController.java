package com.example.dictionaryyy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.io.IOException;

public class HelloController {
    Dictionary dictionary = new Dictionary();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    @FXML
    private TextField Input;

    @FXML
    private TextField Output;
    @FXML
    private TextField add1;
    @FXML
    private TextField add2;

    @FXML
    private TextField up1;
    @FXML
    private TextField up2;
    @FXML
    private TextField inAPI;
    @FXML
    private TextField inRemove;
    @FXML
    private TextField inLookup;

    @FXML
    private Button but1;

    @FXML
    private Button but2;

    @FXML
    private Button but3;
    @FXML
    private Button but4;
    @FXML
    private Button but5;

    @FXML
    private Button searAPI;

    @FXML
    void NhapTuBanPhim(ActionEvent event) {
        String t = Input.getText();
        Output.setText(dictionary.getVie(t));
    }

    @FXML
    void OnKeyT(KeyEvent event) {

    }

    @FXML
    void Press1(ActionEvent event) {
        String t = Input.getText();
        Output.setText(dictionary.getVie(t));
    }



    @FXML
    void Press2(ActionEvent event) throws IOException {
        String t = inRemove.getText();
        dictionary.removeVie(t);
    }

    @FXML
    void Press3(ActionEvent event) throws IOException {
        String a1 = add1.getText();
        String a2 = add2.getText();
        dictionary.addVie(a1,a2);
    }
    @FXML
    void Press4(ActionEvent event) throws IOException {
        String u1 = up1.getText();
        String u2 = up2.getText();
        dictionary.update(u1,u2);
    }
    @FXML
    void Press5(ActionEvent event){
        String inLook = inLookup.getText();
        Output.setText(dictionary.hintedWord(inLook)+"\n");
    }
    @FXML
    void Voice(ActionEvent event){
        String str = inAPI.getText();
        Voice.speak(str);
    }

    @FXML void SearAPI(ActionEvent event) throws IOException {
        String res = inAPI.getText();
            Output.setText(TranslateAPI.googleTranslate("","vi",res));
    }


}