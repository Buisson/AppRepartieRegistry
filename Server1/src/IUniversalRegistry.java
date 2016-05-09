import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * Created by colombet on 04/05/16.
 */
public interface IUniversalRegistry extends java.rmi.Remote{
    public void bind(String key,Object o) throws RemoteException;
    public Object lookup(String key) throws RemoteException;

}
