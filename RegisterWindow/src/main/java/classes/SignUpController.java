package classes;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpLogin;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private Button signUpAuth;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpSurname;

    @FXML
    private TextField signUpCity;

    @FXML
    private RadioButton signUpMale;

    @FXML
    private RadioButton signUpFemale;

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        signUpMale.setToggleGroup(group);
        signUpFemale.setToggleGroup(group);

        signUpAuth.setOnAction(actionEvent -> {

            signUpNewUser();

        });
    }

    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        String firstName = signUpName.getText();
        String lastName = signUpSurname.getText();
        String userName = signUpLogin.getText();
        String password = signUpPassword.getText();
        String city = signUpCity.getText();
        String gender = "";
        if(signUpMale.isSelected()) {
            gender = "Мужской";
        }
            else {
                gender = "Женский";
            }
        User user = new User(firstName, lastName, userName, password,
                city,gender);
        try {
            dbHandler.signUpUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
