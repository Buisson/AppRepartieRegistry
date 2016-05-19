/**
 * Created by user on 15/05/16.
 */
public class Goalkeeper extends Player implements IGoalkeeper{
    private  int concededGoals ;
    public Goalkeeper(int age) {
        super(age);
        concededGoals=0;
    }

    public void concede(int goals){
        this.concededGoals=goals;
    }

    public int getConcededGoals() {
        return concededGoals;
    }
}
