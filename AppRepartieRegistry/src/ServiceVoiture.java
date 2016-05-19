import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 10/05/16.
 */
public class ServiceVoiture {

    public  static List<Object> getCarByType(String type,Hashtable<String,Object> universalRegistry){
        List<Object> cars = new ArrayList<>();
        for (Map.Entry<String, Object> entry : universalRegistry.entrySet()) {
            System.out.println(entry.getValue().getClass().getName());
            if(entry.getValue().getClass().it
            getName().equals(type)){
                System.out.println("heheheheh");
                cars.add(entry.getValue());
            }
        }
        return cars;
    }
}
