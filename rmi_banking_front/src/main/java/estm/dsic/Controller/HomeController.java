package estm.dsic.Controller;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import estm.dsic.MainApp;
import estm.dsic.Models.Account;
import estm.dsic.Models.Client;
import estm.dsic.Models.Operation;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController implements Initializable {
    @FXML
    Label lbl_email;
    @FXML
    Label lbl_owner;
    @FXML
    Label lbl_AccNum;
    @FXML
    Label lbl_balance;
    @FXML
    Button btn_Deposit;
    @FXML
    Button btn_logout;
    @FXML
    Button btn_Withdraw;
    @FXML
    TextField txt_Amount;
    @FXML
    TableView<Operation> tbv_Operations;

    @FXML
    private TableColumn<Operation, Integer> ID;

    @FXML
    private TableColumn<Operation, String> typeOp;

    @FXML
    private TableColumn<Operation, Double> amount;

    @FXML
    private TableColumn<Operation, String> Date;

    Client currentClient = NavigationController.currentClient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lbl_AccNum.setText(String.valueOf(currentClient.getAccount().getAccountNumber()));
        lbl_balance.setText(String.valueOf(currentClient.getAccount().getBalance()));
        lbl_email.setText(currentClient.getEmail());
        lbl_owner.setText(currentClient.getFirstName().toUpperCase() + " " +
                currentClient.getLastName());

        ID.setCellValueFactory(new PropertyValueFactory<Operation, Integer>("id"));
        typeOp.setCellValueFactory(new PropertyValueFactory<Operation, String>("typeOp"));
        amount.setCellValueFactory(new PropertyValueFactory<Operation, Double>("amount"));
        Date.setCellValueFactory(new PropertyValueFactory<Operation, String>("dateOpe"));

        RefreshTableView(currentClient.getAccount().getLstOps());

    }

    public void btn_DepositClicked(ActionEvent event) {
        try {
            double amount = Double.parseDouble(txt_Amount.getText());
            Account acc = MainApp.objAccount.Deposit(currentClient.getAccount().getAccountNumber(), amount);
            if (acc != null) {
                showSuccessAlert(AlertType.INFORMATION, "Success");
                currentClient.setAccount(acc);
                RefreshTableView(acc.getLstOps());
                lbl_balance.setText(String.valueOf(currentClient.getAccount().getBalance()));
            } else {
                showSuccessAlert(AlertType.WARNING, "Something went wroong");

            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void btn_WithdrawClicked(ActionEvent event) {
        try {
            double amount = Double.parseDouble(txt_Amount.getText());
            Account acc = MainApp.objAccount.Withdrawal(currentClient.getAccount().getAccountNumber(), amount);
            if (acc != null) {
                showSuccessAlert(AlertType.INFORMATION, "Success");
                currentClient.setAccount(acc);
                RefreshTableView(acc.getLstOps());
                lbl_balance.setText(String.valueOf(currentClient.getAccount().getBalance()));
            } else {
                showSuccessAlert(AlertType.WARNING, "Something went wroong");
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void btn_logoutClicked(ActionEvent event) {
        try {
            currentClient = null;
            NavigationController.currentClient = null;
            NavigationController.navigateTo("LoginScreen", btn_Deposit, 630, 450);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void RefreshTableView(ArrayList<Operation> lst) {
        if (lst != null) {
            ObservableList data = FXCollections.observableArrayList(lst);
            tbv_Operations.setItems(data);
        }
    }

    public void showSuccessAlert(AlertType alertType, String content) {
        Platform.runLater(() -> {
            Alert a = new Alert(alertType, "", ButtonType.OK);
            a.setTitle("");
            a.setHeaderText(content);
            a.show();

        });
    }
}
