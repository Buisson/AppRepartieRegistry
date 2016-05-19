import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by user on 15/05/16.
 */
public interface IStatsService extends Remote {
    List<IFieldPlayer> goalScorers() throws RemoteException;
    List<IGoalkeeper> bestGoalKeepers() throws RemoteException;

}
