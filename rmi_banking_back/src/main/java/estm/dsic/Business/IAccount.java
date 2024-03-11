package estm.dsic.Business;

import java.rmi.Remote;
import java.rmi.RemoteException;

import estm.dsic.Models.Account;

public interface IAccount extends Remote {

    public Account Deposit(int accNum, double amount) throws RemoteException;

    public Account Withdrawal(int accNum, double amount) throws RemoteException;

    // public Account Refresh(int accNum, double amount) throws RemoteException;

}