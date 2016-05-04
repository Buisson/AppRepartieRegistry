import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

/**
 * Created by colombet on 04/05/16.
 */
public class UniversalRegistry extends UnicastRemoteObject implements IUniversalRegistry{

    private Hashtable<String,Serializable> universalRegistry;

    public UniversalRegistry() throws RemoteException {
        super();
        universalRegistry = new Hashtable<String,Serializable>();
    }

    @Override
    public void bind(String key,Serializable o){
        System.out.println("BIIIINNNDDIIIIINNG!");
        universalRegistry.put(key,o);
    }

    @Override
    public Serializable lookup(String key){
        System.out.println("LOOOKKKKUPPPP!");
        return universalRegistry.get(key);
    }
}
