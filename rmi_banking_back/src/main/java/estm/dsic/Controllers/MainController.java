package estm.dsic.Controllers;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import estm.dsic.Business.AccountBusiness;
import estm.dsic.Business.ClientBusiness;

public class MainController {

    public static void main(String[] args) {
        int port = 2023;
        try {
            // starts the rmiregistery
            Registry registry = LocateRegistry.createRegistry(port);

            ClientBusiness clBs = new ClientBusiness();
            String url = "rmi://192.168.0.145:" + port + "/login";
            Naming.rebind(url, clBs);

            AccountBusiness accBs = new AccountBusiness();
            String urlOperation = "rmi://192.168.0.145:" + port + "/operation";
            Naming.rebind(urlOperation, accBs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
