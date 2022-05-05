package classes;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button authButton;

    @FXML
    private Button loginButton;

    @FXML
    void initialize() {
    authButton.setOnAction(actionEvent -> {
        String loginText = loginField.getText().trim();
        String passwordText = passField.getText().trim();

        if(!loginText.equals("") && !passField.equals("")) {
            try {
                loginUser(loginText,passwordText);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
            else
                System.out.println("Login and password is empty");
    });

    loginButton.setOnAction(actionEvent -> {
       openNewScene("/javaFX/signUp.fxml");
    });
    }

    private void loginUser(String loginText, String passwordText) throws SQLException, ClassNotFoundException {
        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(passwordText);
        dbHandler.getUser(user);
        ResultSet resultSet = dbHandler.getUser(user);

        int counter = 0;

        while(resultSet.next()){
            counter++;
        }

        if(counter >= 1 && passwordText.equals(user.getPassword())) {
            System.out.println("Success!");
            loginButton.getScene().getWindow().hide();
            openNewScene("/javaFX/app.fxml");
        }
        else {
            Shake userLoginAnim = new Shake(loginField);
            Shake userPassAnim = new Shake(passField);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }

    public void openNewScene(String window) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        root.setFocusTraversable(true);
        stage.showAndWait();
    }
}
