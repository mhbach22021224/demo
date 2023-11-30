package com.example.dictionaryyy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DicController {
    Dictionary dictionary = new Dictionary();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    @FXML
    private TextField Input;

    @FXML
    private TextArea Output;
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
    private TextField inG1;
    @FXML
    private TextField outG1;
    @FXML
    private TextField inG2;
    @FXML
    private TextField outG2;
    @FXML
    private TextField inG3;
    @FXML
    private TextField outG3;
    @FXML
    private TextField inG4;
    @FXML
    private TextField outG4;
    @FXML
    private TextField inG5;
    @FXML
    private TextField outG5;

    @FXML
    private TextField outPCore;
    int core=0;

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
    private Button Next;

    @FXML
    private Button searAPI;
    private Stage stage1;
    private Parent root1;
    private Scene scene1;
    private Stage stage2;
    private Parent root2;
    private Scene scene2;

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
        String t = Input.getText();
        Output.setText(dictionary.hintedWord(t) + '\n');
    }

    @FXML
    void Press1(ActionEvent event) {
        String t = Input.getText();
        if(dictionary.getVie(t)!=null){
            Output.setText(dictionary.getVie(t));
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setContentText("Không tìm thấy từ phù hợp!");
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
    void Voice(ActionEvent event){
        String str = inAPI.getText();
        Voice.speak(str);
    }

    @FXML void SearAPI(ActionEvent event) throws IOException {
        String res = inAPI.getText();
            Output.setText(TranslateAPI.googleTranslate("","vi",res));
    }
    public void switchToGame(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        stage1=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void switchToHome(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage2=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene2 = new Scene(root);
        stage2.setScene(scene2);
        stage2.show();
        dictionaryManagement.inserFromFile(dictionary);
    }
    public void Game1 (ActionEvent event){
        String t = inG1.getText();
        t.trim().toLowerCase();
        if(t.equals("hotdog")){
            outG1.setText("Correct answer!");
        } else {
            outG1.setText("Wrong");
        }
    }
    public void switchToGame2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Game2.fxml"));
        stage1=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void Game2 (ActionEvent event){
        String t = inG2.getText();
        t.trim().toLowerCase();
        if(t.equals("pancake")){
            outG2.setText("Correct answer!");
        } else {
            outG2.setText("Wrong");
        }
    }
    public void switchToGame3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Game3.fxml"));
        stage1=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void Game3 (ActionEvent event){
        String t = inG3.getText();
        t.trim().toLowerCase();
        if(t.equals("firefly")){
            outG3.setText("Correct answer!");

        } else {
            outG3.setText("Wrong");
        }
    }
    public void switchToGame4(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Game4.fxml"));
        stage1=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }

    public void Game4 (ActionEvent event){
        String t = inG4.getText();
        t.trim().toLowerCase();
        if(t.equals("eardrum")){
            outG4.setText("Correct answer!");

        } else {
            outG4.setText("Wrong");
        }
    }
    public void switchToGame5(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Game5.fxml"));
        stage1=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    public void Game5 (ActionEvent event){
        String t = inG5.getText();
        t.trim().toLowerCase();
        if(t.equals("basketball")){
            outG5.setText("Correct answer!");
        } else {
            outG5.setText("Wrong");
        }
    }

}