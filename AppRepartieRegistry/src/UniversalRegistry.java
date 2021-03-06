import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 * Created by colombet on 04/05/16.
 */
public class UniversalRegistry extends UnicastRemoteObject implements IUniversalRegistry{

    private Hashtable<String,Object> universalRegistry;
    private Set<Enregistrement> history;
    private int Time = 0;

    private ServiceQueue sq;

    public UniversalRegistry() throws RemoteException {
        super();
        universalRegistry = new Hashtable<>();
        history = new TreeSet<>();

        sq=new ServiceQueue();
    }

    @Override
    public void bind(String key,Object o)  {
        if(universalRegistry.containsKey(key)){
            throw new AlreadyExistingElement();
        }

        universalRegistry.put(key, o);
        history.add(new Enregistrement(Time,key));
        Time++;
    }

    @Override
    public Object lookup(String key) {
        // TODO : deal with non existent keys
        for(Enregistrement e : history){
            if(e.getKey().equals(key))
                e.increment();
        }
        if(universalRegistry.isEmpty()){
            throw new NoExistingElement();
        }
        if(universalRegistry.get(key) == null){
            throw new NoExistingElement();
        }
        return universalRegistry.get(key);
    }

    @Override
    public List<Object> getLast(int x) throws RemoteException {
        if(x > universalRegistry.size())
            x = universalRegistry.size();
        List<Object> lasts = new ArrayList<>();
        for(Enregistrement e : history){
            if(e.getDate() >= x)
                lasts.add(universalRegistry.get(e.getKey()));
        }
        return lasts;
    }

    @Override
    public List<String> lastKeys(int x) throws RemoteException {
        if(x > universalRegistry.size())
            x = universalRegistry.size();
        List<String> lasts = new ArrayList<>();

        for(Enregistrement e : history){
            System.out.println(e.getDate());
            if(e.getDate() >= x)
                lasts.add(e.getKey());
        }

        return lasts;
    }

    @Override
    public List<String> popularKeys(int x) throws RemoteException {
        int max = 0;
        List<String> popular = new ArrayList<>();
        for (Enregistrement e : history) {
            if (e.getDemands() == max) {
                popular.add(e.getKey());
            }
            if (e.getDemands() > max) {
                max = e.getDemands();
                popular.clear();
                popular.add(e.getKey());
            }
        }
        return popular;
    }

    @Override
    public List<Object> exactSearch(String type)throws RemoteException {
        List<Object> objects = new ArrayList<>();
        for (Map.Entry<String, Object> entry : universalRegistry.entrySet()) {
            if(entry.getValue().getClass().getName().equals(type)){
                objects.add(entry.getValue());
            }
        }
        return objects;

    }

    @Override
    public List<Object> deepSearch(String type) throws RemoteException {
        List<Object> objects = new ArrayList<>();
        for (Map.Entry<String, Object> entry : universalRegistry.entrySet()) {
            boolean father = entry.getValue().getClass().getName().equals(type);
            boolean son  = entry.getValue().getClass().getSuperclass().getName().equals(type);
            if(father || son){
                objects.add(entry.getValue());
            }
        }
        return objects;

    }

    @Override
    public javax.jms.Queue getQueueServiceQueue()throws RemoteException {
        sq.createQueue();
        return sq.subscribeQueue();
    }

}
