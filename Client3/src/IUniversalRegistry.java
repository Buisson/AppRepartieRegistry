import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by colombet on 04/05/16.
 */
public interface IUniversalRegistry extends java.rmi.Remote{
     void bind(String key,Object o) throws RemoteException;
     Object lookup(String key) throws RemoteException;
     List<Object> getLast(int x)throws RemoteException;
     List<String> lastKeys(int x)throws RemoteException;
     List<String> popularKeys(int x)throws RemoteException;
     List<Object> exactSearch(String type)throws RemoteException;
     List<Object> deepSearch(String type)throws RemoteException;



     javax.jms.Queue getQueueServiceQueue()throws RemoteException;
}
