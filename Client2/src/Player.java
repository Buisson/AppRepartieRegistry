import java.io.Serializable;

/**
 * Created by user on 15/05/16.
 */
public class Player implements Serializable {
    private int age;

    public Player(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
