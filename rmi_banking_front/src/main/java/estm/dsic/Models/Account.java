package estm.dsic.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private int accountNumber;
    private int accountOwner;
    private double balance;
    private Client client;
    private ArrayList<Operation> lstOps;

    public ArrayList<Operation> getLstOps() {
        return lstOps;
    }

    public void setLstOps(ArrayList<Operation> lstOps) {
        this.lstOps = lstOps;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Account(int accountNumber, int accountOwner, double balance, Client Clt) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.client = Clt;
    }

    public Account(int accountNumber, int accountOwner, double balance, ArrayList<Operation> lstOps) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.lstOps = lstOps;
    }

    public Account(int accountNumber, int accountOwner, double balance) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(int accountOwner) {
        this.accountOwner = accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
