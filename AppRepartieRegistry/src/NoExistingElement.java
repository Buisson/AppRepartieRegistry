import java.rmi.RemoteException;

/**
 * Created by colombet on 20/05/16.
 */
public class NoExistingElement extends RuntimeException {


    public String toString(){
          return "L'objet que vous essayez de lookup n'existe pas";
    }
}
