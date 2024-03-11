package estm.dsic.Business;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

import estm.dsic.DataAccessLayer.AccountDao;
import estm.dsic.DataAccessLayer.OperationDAO;
import estm.dsic.Models.Account;
import estm.dsic.Models.Operation;

public class AccountBusiness extends UnicastRemoteObject implements IAccount {

    public AccountBusiness() throws RemoteException {
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public Account Deposit(int accNum, double amount) throws RemoteException {

        Operation op = new Operation("DEPOSIT", amount, sdf.format(new Date()), accNum);
        OperationDAO opDao = new OperationDAO();
        if (opDao.addOperation(op) != 0) {
            AccountDao accDao = new AccountDao();
            accDao.updateAccount(accNum, amount);
            return accDao.getAccount(-1, accNum);
        }
        return null;
    }

    @Override
    public Account Withdrawal(int accNum, double amount) throws RemoteException {
        Operation op = new Operation("WITHDRAWAL", amount, sdf.format(new Date()), accNum);
        OperationDAO opDao = new OperationDAO();
        if (opDao.addOperation(op) != 0) {
            AccountDao accDao = new AccountDao();
            accDao.updateAccount(accNum, (-amount));
            return accDao.getAccount(-1, accNum);
        }
        return null;

    }

}
