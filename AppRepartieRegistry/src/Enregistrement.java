
/**
 * Une classe qui permet de garder des informations concernant un enregistrement
 * pour pouvoir rendre des service, ex : les clef les plus utilisée
 */
public class Enregistrement implements Comparable {
    // pour simplifier on modélise le temps avec un entier
    private int  date ;
    private String key;
    // le nombre le lookup sur l'objet associé a cet enregistrement
    private int demands;

    public Enregistrement(int date, String key) {
        this.date = date;
        this.key = key;
        this.demands=0;
    }

    public int getDemands() {
        return demands;
    }
    public int getDate() {return date;}
    public String getKey() {return key;}
    public void increment(){this.demands++;}



    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        Enregistrement that = (Enregistrement) o;
        return that.getDate()-this.getDate();
        }
}
