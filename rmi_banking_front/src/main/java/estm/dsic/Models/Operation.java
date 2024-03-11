package estm.dsic.Models;

import java.io.Serializable;

public class Operation implements Serializable {
    private int id;
    private String typeOp;
    private double amount;
    private String dateOpe;

    public String getDateOpe() {
        return dateOpe;
    }

    public void setDateOpe(String dateOpe) {
        this.dateOpe = dateOpe;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private int accNumber;

    public Operation(int id, String typeOp, double amount, String dateOpe, int accNumber) {
        this.id = id;
        this.typeOp = typeOp;
        this.amount = amount;
        this.accNumber = accNumber;
        this.dateOpe = dateOpe;
    }public Operation(String typeOp, double amount, String dateOpe, int accNumber) {
        this.typeOp = typeOp;
        this.amount = amount;
        this.accNumber = accNumber;
        this.dateOpe = dateOpe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOp() {
        return typeOp;
    }

    public void setTypeOp(String typeOp) {
        this.typeOp = typeOp;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

}
