import java.net.MalformedURLException;
import java.rmi.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        if (System.getSecurityManager() == null)
            System.setSecurityManager(new RMISecurityManager());
        try {
            Remote r = Naming.lookup("UniversalRegistry");
            IUniversalRegistry iur = (IUniversalRegistry)r;

            iur.lookup("ve");



            iur.lookup("ve");iur.lookup("ve");
            //iur.lookup("v2");iur.lookup("v2");iur.lookup("v2");
            //iur.lookup("v3");
            //System.out.println(iur.popularKeys(0).size());

            /*for(String s : iur.popularKeys(0))
                System.out.println(s);
              */


            for (Object v : iur.getCarByType("Voiture")){

                System.out.println(((IVoiture) v).getNbRoues());
            }
            for (Object v : iur.getCarByType("VoitureElectrique")){

                System.out.println(((IVoitureElectrique) v).getDurabilite());
            }

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
