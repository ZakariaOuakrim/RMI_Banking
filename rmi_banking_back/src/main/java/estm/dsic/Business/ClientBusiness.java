package estm.dsic.Business;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import estm.dsic.DataAccessLayer.ClientDAO;
import estm.dsic.Models.Client;

public class ClientBusiness extends UnicastRemoteObject implements IClient {

    public ClientBusiness() throws RemoteException {
    }

    @Override
    public Client login(String email, String password) throws RemoteException {
        ClientDAO clDao = new ClientDAO();
        Client cl = clDao.getClient(email);
        if (cl != null && cl.getPassword().equals(password)) {
            return cl;
        }
        return null;
    }

}
