import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by user on 15/05/16.
 */
public class Main {
    public  static void populate(StatsService statsService) throws RemoteException {
        FieldPlayer player1 = new FieldPlayer(20);
        player1.score(20);
        FieldPlayer player2 = new FieldPlayer(20);
        player1.score(5);
        FieldPlayer player3 = new FieldPlayer(20);
        player1.score(23);
        FieldPlayer player4 = new FieldPlayer(20);
        player1.score(15);
        FieldPlayer player5 = new FieldPlayer(20);
        player1.score(23);
        statsService.getGoalScorers().add(player1);
        statsService.getGoalScorers().add(player2);
        statsService.getGoalScorers().add(player3);
        statsService.getGoalScorers().add(player4);
        statsService.getGoalScorers().add(player5);



    }
    public static void main(String[] args) {


        try {

            Registry registry = LocateRegistry.createRegistry(1098);
            StatsService statsService = new StatsService();
            populate(statsService);
            registry.rebind("statsService", statsService);
            Remote r = Naming.lookup("UniversalRegistry");
            IUniversalRegistry iur = (IUniversalRegistry)r;
            Remote remoteStats = registry.lookup("statsService");
            iur.bind("statsService",remoteStats );
            System.out.println("done ! ");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
