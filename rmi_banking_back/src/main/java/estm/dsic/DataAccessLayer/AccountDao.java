package estm.dsic.DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import estm.dsic.Models.Account;

public class AccountDao {

    public Account getAccount(int idClient, int accNum) {
        Connection con = Database.getConnection();
        Account account = null;
        try {
            String qry = "Select * from Account where "
                    + (idClient == -1 ? "ID=" + accNum : "Account_Holder=" + idClient);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(qry);
            if (res.isBeforeFirst() || res.getRow() != 0) {
                while (res.next()) {
                    account = new Account(
                            res.getInt("ID"),
                            res.getInt("Account_Holder"),
                            res.getDouble("Balance"),
                            new OperationDAO().getOperations(res.getInt("ID")));
                }
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateAccount(int accNum, double amount) {
        Connection con = Database.getConnection();
        try {
            String qry = "UPDATE Account SET Balance= Balance +" + amount + " WHERE ID=" + accNum;

            Statement stmt = con.createStatement();
            stmt.executeUpdate(qry);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // return null;
    }

}
