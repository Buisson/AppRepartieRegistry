/**
 * Created by user on 15/05/16.
 */
public class FieldPlayer extends Player implements IFieldPlayer {
    private  int scoredGoals;
    public FieldPlayer(int age) {
        super(age);
        scoredGoals=0;
    }

    public FieldPlayer() {
        super(0);
    }


    public void score(int goals){
        this.scoredGoals=goals;
    }
    public int getScoredGoals() {
        return scoredGoals;
    }
    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }
}
