package estm.dsic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.Naming;

import estm.dsic.Business.IAccount;
import estm.dsic.Business.IClient;

public class MainApp extends Application {
    private static Stage stage;

    public static IClient objClient;
    public static IAccount objAccount;

    public static void main(String[] args) {
        int port = 2023;
        String URL = "//192.168.0.145:" + port + "/login";
        String urlOperation = "//192.168.0.145:" + port + "/operation";
        try {
            objClient = (IClient) Naming.lookup(URL);
            objAccount = (IAccount) Naming.lookup(urlOperation);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        launch(args);
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage = s;
        setRoot("LoginScreen", "");
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml, stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
