
/**
 * Created by user on 15/05/16.
 */
public class Player implements IPlayer {
    private int age;

    public Player(int age) {
        this.age = age;
    }

    public int getAge() {return age;}
    public void setAge(int age) {
        this.age = age;
    }
}
