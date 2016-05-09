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

    private Hashtable<String,Object> universalRegistry;

    public UniversalRegistry() throws RemoteException {
        super();
        universalRegistry = new Hashtable<String,Object>();
    }

    @Override
    public void bind(String key,Object o){
        System.out.println(o.getClass().getName());
        universalRegistry.put(key, o);
    }

    @Override
    public Object lookup(String key){
        System.out.println("searching for : "+universalRegistry.get(key));
        return universalRegistry.get(key);
    }


}
