module estm.dsic {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.rmi;

    opens estm.dsic.Controller to javafx.fxml;
    opens estm.dsic.Models;

    exports estm.dsic;
}