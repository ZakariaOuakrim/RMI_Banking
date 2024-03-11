package estm.dsic.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

import estm.dsic.Models.Client;

public class NavigationController {

    private static Stage stage;
    public static Client currentClient;

    public static void navigateTo(String pathFXML, Node node, double width, double height) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    NavigationController.class.getResource("/fxml/" + pathFXML + ".fxml"));

            stage = (Stage) node.getScene().getWindow();
            stage.getScene().setRoot(fxmlLoader.load());
            stage.setWidth(width);
            stage.setHeight(height);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
