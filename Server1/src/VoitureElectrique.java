/**
 * Created by user on 10/05/16.
 */
public class VoitureElectrique extends Voiture implements IVoitureElectrique {
    private int durabilite;



    public VoitureElectrique() {}

    public VoitureElectrique(int nbRoues, int durabilite) {
        super(nbRoues);
        this.durabilite = durabilite;
    }

    public int getDurabilite() {
        return durabilite;
    }

    public void setDurabilite(int durabilite) {
        this.durabilite = durabilite;
    }
}
