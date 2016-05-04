import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.registry.Registry;
//-Djava.rmi.server.useCodebaseOnly=false
public class Main {
    public static void main(String[] args) {
        System.out.println("Begin Server...");
        System.setSecurityManager(new RMISecurityManager());

        try {
            Remote r = Naming.lookup("UniversalRegistry");
            System.out.println(r.toString());
            //IUniversalRegistry iur = (IUniversalRegistry)r;
            //System.out.println(iur.lookup("test"));


        }
        catch(Exception e){

        }



    }
}
