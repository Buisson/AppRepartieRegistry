
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by colombet on 04/05/16.
 */
public class Main {
    public static void main (String[] args){
        System.out.println("##UNIVERSAL RMI REGISTRY##");

        if (System.getSecurityManager() == null)
            System.setSecurityManager(new RMISecurityManager());

        try {
            LocateRegistry.createRegistry(1099);
            UniversalRegistry ur = new UniversalRegistry();
            Naming.rebind("UniversalRegistry", ur);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        while(true);
    }
}
