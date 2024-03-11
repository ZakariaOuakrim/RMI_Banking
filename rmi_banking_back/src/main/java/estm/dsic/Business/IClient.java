package estm.dsic.Business;

import java.rmi.Remote;
import java.rmi.RemoteException;

import estm.dsic.Models.Client;

public interface IClient extends Remote {
    public Client login(String email, String password) throws RemoteException;

}
