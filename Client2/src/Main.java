import java.net.MalformedURLException;
import java.rmi.*;

public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        if (System.getSecurityManager() == null)
            System.setSecurityManager(new RMISecurityManager());

        Remote r = Naming.lookup("UniversalRegistry");
        IUniversalRegistry iur = (IUniversalRegistry)r;

        IStatsService iStatsService = (IStatsService)iur.lookup("statsService");
        System.out.println(iStatsService.goalScorers().size());


    }
}
