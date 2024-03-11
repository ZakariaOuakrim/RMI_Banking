package estm.dsic.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import estm.dsic.MainApp;
import estm.dsic.Models.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
    @FXML
    TextField txtEmail;
    @FXML
    PasswordField txtPass;
    @FXML
    Button btnLogin;

    public void btnLoginClick(ActionEvent event) {
        try {

            Client cl = MainApp.objClient.login(txtEmail.getText(), txtPass.getText());
            if (cl != null) {
                NavigationController.currentClient = cl;
                NavigationController.navigateTo("HomeScreen", btnLogin,1050,560);
            } else {
                System.out.println("bad email/password");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
}
