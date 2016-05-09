import java.io.Serializable;

/**
 * Created by colombet on 04/05/16.
 */
public class Voiture implements Serializable ,IVoiture{

    int nbRoues;

    public Voiture(int nbRoues){this.nbRoues=nbRoues;}
    public Voiture() {}
    public int getNbRoues() {return nbRoues;}
    public void setNbRoues(int nbRoues) {this.nbRoues = nbRoues;}
}
