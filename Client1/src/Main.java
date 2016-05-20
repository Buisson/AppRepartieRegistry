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
            // ça doit afficher 5
            System.out.println("Nombres de roues de v1: "+((IVoiture)iur.lookup("v1")).getNbRoues());

            // le nombre de classes enregister qui sont de type Voiture ou héritent de voiture
            System.out.println(iur.deepSearch("Voiture").size());

            // on récupere un goalkeeper pour tester l'échange de fichiers entre les projets
            IGoalkeeper goalkeeper =(IGoalkeeper ) iur.lookup("exchange");
            System.out.println(goalkeeper.getConcededGoals());

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
