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
    public List<IGoalkeeper> bestGoalKeepers()  {
        List<IGoalkeeper> players = new ArrayList<>();
        int min = goalKeepers.get(0).getConcededGoals();
        for( Goalkeeper goalkeeper: goalKeepers){
            if(goalkeeper.getConcededGoals() > min){
                players.clear();
                players.add(goalkeeper);
                min = goalkeeper.getConcededGoals();
            }else if(goalkeeper.getConcededGoals()== min){
                min = goalkeeper.getConcededGoals();
                players.add(goalkeeper);
            }
        }
        return players;
    }
    @Override
    public List<IFieldPlayer> goalScorers()  {
        List<IFieldPlayer> players = new ArrayList<>();
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
