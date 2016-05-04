import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by colombet on 04/05/16.
 */
public class Main {
    public static void main (String[] args){
        System.out.println("##UNIVERSAL RMI REGISTRY##");

        try {
            LocateRegistry.createRegistry(1099);
            UniversalRegistry ur = new UniversalRegistry();
            Naming.rebind("UniversalRegistry",ur);
            System.out.println("DONE!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        while(true);


    }
}
