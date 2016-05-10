
/**
 * Created by user on 09/05/16.
 */
public class Enregistrement implements Comparable {
    private int  date ;
    private String key;
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
