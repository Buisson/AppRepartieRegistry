import java.net.MalformedURLException;
import java.rmi.*;

public class Main {

    public static void main(String[] args) {


        if (System.getSecurityManager() == null)
            System.setSecurityManager(new RMISecurityManager());
        try {
            Remote r = Naming.lookup("UniversalRegistry");
            IUniversalRegistry iur = (IUniversalRegistry)r;

            //iur.getLast(2);
            System.out.println(iur.lookup("ve"));
            //System.out.println(((IVoiture) iur.getLast(5).get(0)).getNbRoues());


        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
