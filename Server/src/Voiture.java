import java.io.Serializable;

/**
 * Created by colombet on 04/05/16.
 */
public class Voiture implements Serializable{

    int nbRoues;

    public Voiture(int nbRoues){
        this.nbRoues=nbRoues;
    }
}
