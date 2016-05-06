import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;

//-Djava.rmi.server.useCodebaseOnly=false
public class Main {
    public static void main(String[] args) {
        System.out.println("Begin Server...");



        try {
            Remote r = Naming.lookup("UniversalRegistry");
            IUniversalRegistry iur = (IUniversalRegistry)r;
            Voiture v = new Voiture(3);
            iur.bind("hahaha",v);
            System.out.println(((Voiture)iur.lookup("hahaha")).getNbRoues());



        }
        catch(Exception e){
            e.printStackTrace();
        }



    }
}
