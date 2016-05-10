import org.joda.time.DateTime;

/**
 * Created by user on 09/05/16.
 */
public class Enregistrement implements Comparable {
    private int  date ;
    private String key;

    public Enregistrement(int date, String key) {
        this.date = date;
        this.key = key;
    }

    public int getDate() {return date;}

    public void setDate(int date) {this.date = date;}

    public String getKey() {return key;}

    public void setKey(String key) {this.key = key;}



    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        Enregistrement that = (Enregistrement) o;
        return that.getDate()-this.getDate();
        }
}
