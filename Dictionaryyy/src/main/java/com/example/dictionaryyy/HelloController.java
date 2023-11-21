package com.example.dictionaryyy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        if(dictionary.getVie(t)!=null){
            Output.setText(dictionary.getVie(t));
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setContentText("Không tìm thấy nghĩa phù hợp!");
            alert.showAndWait();
        }

    }

    @FXML
    void OnKeyT(KeyEvent event) {

    }

    @FXML
    void Press1(ActionEvent event) {
        String t = Input.getText();
        if(dictionary.getVie(t)!=null){
            Output.setText(dictionary.getVie(t));
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setContentText("Không tìm thấy nghĩa phù hợp!");
            alert.showAndWait();
        }
    }



    @FXML
    void Press2(ActionEvent event) throws IOException {
        String t = inRemove.getText();
        dictionary.removeVie(t);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Thông báo!");
        alert.setContentText("Xoá từ thành công!");
        alert.showAndWait();
    }

    @FXML
    void Press3(ActionEvent event) throws IOException {
        String a1 = add1.getText();
        String a2 = add2.getText();
        dictionary.addVie(a1,a2);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Thông báo!");
        alert.setContentText("Thêm từ thành công!");
        alert.showAndWait();
    }
    @FXML
    void Press4(ActionEvent event) throws IOException {
        String u1 = up1.getText();
        String u2 = up2.getText();
        if(dictionary.getVie(u1) == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo!");
            alert.setContentText("Không tìm thấy từ cần cập nhật! \n Mời nhập lại");
            alert.showAndWait();
        } else {
            dictionary.update(u1,u2);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Thông báo!");
            alert.setContentText("Cập nhật thành công!");
            alert.showAndWait();
        }
    }
    @FXML
    void Press5(ActionEvent event){
        String inLook = inLookup.getText();
        if(dictionary.hintedWord(inLook) != null){
            Output.setText(dictionary.hintedWord(inLook)+'\n');
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo!");
            alert.setContentText("Không tìm thấy từ nào !");
            alert.showAndWait();
        }
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
