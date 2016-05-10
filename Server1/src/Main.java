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

            VoitureElectrique ve = new VoitureElectrique(4,0);
            iur.bind("ve",ve);
            VoitureElectrique ve1 = new VoitureElectrique(4,1);
            iur.bind("ve1",ve1);
            VoitureElectrique ve2 = new VoitureElectrique(4,2);
            iur.bind("ve2",ve2);
            VoitureElectrique ve3 = new VoitureElectrique(4,3);
            iur.bind("ve3",ve3);
        }

        catch(Exception e){
            e.printStackTrace();
        }



    }
}
