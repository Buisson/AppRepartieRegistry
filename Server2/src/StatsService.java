import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15/05/16.
 */
public class StatsService  extends UnicastRemoteObject implements  IStatsService{
    private List <FieldPlayer> goalScorers = new ArrayList<>();
    private List <Goalkeeper> goalKeepers = new ArrayList<>();
    protected StatsService() throws RemoteException {
        super();
    }

    @Override
    public List<Player> bestGoalKeepers()  {
        return null;
    }
    @Override
    public List<Player> goalScorers()  {
        System.out.println("here");
        List<Player> players = new ArrayList<>();
        int max = goalScorers.get(0).getScoredGoals();
        for( FieldPlayer fieldplayer : goalScorers){
            if(fieldplayer.getScoredGoals() > max){
                players.clear();
                players.add(fieldplayer);
                max = fieldplayer.getScoredGoals();
            }else if(fieldplayer.getScoredGoals() == max){
                max = fieldplayer.getScoredGoals();
                players.add(fieldplayer);
            }
        }
        return players;
    }


    public List<Goalkeeper> getGoalKeepers() throws RemoteException {
        return goalKeepers;
    }

    public List<FieldPlayer> getGoalScorers() throws RemoteException {
        return goalScorers;
    }
}
