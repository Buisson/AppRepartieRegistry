import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;

public class Main {
    public static void main(String[] args) {
        System.out.println("Begin Server...");



        try {
            Remote r = Naming.lookup("UniversalRegistry");
            IUniversalRegistry iur = (IUniversalRegistry)r;
            Voiture v1 = new Voiture(1);
            iur.bind("v1",v1);
            Voiture v2 = new Voiture(2);
            iur.bind("v2",v2);
            Voiture v3 = new Voiture(3);
            iur.bind("v3",v3);
            VoitureElectrique ve = new VoitureElectrique(4,2);
            iur.bind("ve",ve);

        }
        catch(Exception e){
            e.printStackTrace();
        }



    }
}
