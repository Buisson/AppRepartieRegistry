import java.net.MalformedURLException;
import java.rmi.*;
import java.util.List;

public class Main {

    /*
    * Client1 :
    * Recuperation d'un Objet depuis le Serveur et application d'une méthode dessus.
    *
    *
    *
    * */
    public static void main(String[] args) {


        if (System.getSecurityManager() == null)
            System.setSecurityManager(new RMISecurityManager());
        try {
            Remote r = Naming.lookup("UniversalRegistry");
            IUniversalRegistry iur = (IUniversalRegistry)r;



            //On récupère le nombre de roues de l'objet voiture v1.
            System.out.println("Nombres de roues de v1: "+((IVoiture)iur.lookup("v1")).getNbRoues());



            //On récupere un Objet selon nom de la classe Voiture.
            for (Object v : iur.getCarByType("Voiture")){
                System.out.println("Nombres de roues de la voiture : "+((IVoiture) v).getNbRoues());
            }

            //On récupere un Objet selon nom de la classe VoitureElectrique.
            for (Object v : iur.getCarByType("VoitureElectrique")){
                System.out.println("Durabilite de Voiture electrique : "+((IVoitureElectrique) v).getDurabilite());
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
