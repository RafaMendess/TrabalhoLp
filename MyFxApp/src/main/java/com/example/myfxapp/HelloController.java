package com.example.myfxapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Label loginText;
    @FXML
    private Button loginButton;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;


    public void changeScene(String endereco) {
        try {
            root = FXMLLoader.load(getClass().getResource(endereco));
            scene = new Scene(root);
            stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void onLoginButtonClick() {
        validateLogin();
    }

    public void validateLogin() {
        DatabaseHandler connect = new DatabaseHandler();
        Connection conDB = connect.getConnection();
        System.out.println(usernameText.getText() + '\t' + passwordText.getText());

        //String verifyLogin = "select count(1) from user_table where user_name = '" + usernameText.getText() + "' and user_password = '" + passwordText.getText() + "';";
        String verifyLogin = "SELECT * FROM registro_usuarios";

        try {
            Statement stmt = conDB.createStatement();
            ResultSet rs = stmt.executeQuery(verifyLogin);

            while (rs.next()) {
                System.out.println(rs.getCharacterStream(1));
                System.out.println(rs.getCharacterStream(2));
            }
            //if (rs.getInt(1) == 1) {
            changeScene("teste.fxml");
            stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            //}
            //else {
            //    loginText.setText("dados invalidos, digite novamente");
            //    usernameText.setText("");
            //    passwordText.setText("");
            //}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}