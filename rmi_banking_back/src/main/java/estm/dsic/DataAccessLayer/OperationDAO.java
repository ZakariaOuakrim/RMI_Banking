package estm.dsic.DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import estm.dsic.Models.Operation;

public class OperationDAO {
    public ArrayList<Operation> getOperations(int accNum) {
        Connection con = Database.getConnection();
        ArrayList<Operation> lstOps = new ArrayList<>();
        ;
        try {
            String qry = "Select * from Operation where Account_Num=" + accNum;
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(qry);
            if (res.isBeforeFirst() || res.getRow() != 0) {
                while (res.next()) {
                    lstOps.add(new Operation(
                            res.getInt("ID"),
                            res.getString("Type_Op"),
                            res.getDouble("Amount"),
                            res.getString("DateOp"),
                            res.getInt("Account_Num")));
                }
                return lstOps;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addOperation(Operation op) {
        Connection con = Database.getConnection();
        try {
            String qry = "INSERT INTO Operation( Type_Op, Amount, DateOp, Account_Num) VALUES ('" + op.getTypeOp()
                    + "','" + op.getAmount() + "','" + op.getDateOpe() + "','" + op.getAccNumber() + "')";
            Statement stmt = con.createStatement();
            return stmt.executeUpdate(qry);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
