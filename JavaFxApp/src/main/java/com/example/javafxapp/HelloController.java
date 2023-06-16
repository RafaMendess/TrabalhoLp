package com.example.javafxapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button loginButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void newScene(String endereco) {
        try { root = FXMLLoader.load(getClass().getResource(endereco)); }
        catch (Exception e) { System.out.println(e.getMessage()); }
        stage = (Stage) loginButton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onLoginButton() {
        newScene("test.fxml");
        Stage stage_ = (Stage) loginButton.getScene().getWindow();
        stage_.close();
    }
}