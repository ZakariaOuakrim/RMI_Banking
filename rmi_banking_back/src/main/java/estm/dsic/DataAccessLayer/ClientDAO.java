package estm.dsic.DataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import estm.dsic.Models.Client;

public class ClientDAO {

    public Client getClient(String email) {
        Connection con = Database.getConnection();
        Client client = null;
        try {
            String qry = "Select * from Holder where email='" + email + "'";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(qry);
            if (res.isBeforeFirst() || res.getRow() != 0) {
                while (res.next()) {
                    client = new Client(
                            res.getInt("ID"),
                            res.getString("NOM"),
                            res.getString("PRENOM"),
                            res.getString("EMAIL"),
                            res.getString("MDP"),
                            new AccountDao().getAccount(res.getInt("ID"), -1));
                }
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
