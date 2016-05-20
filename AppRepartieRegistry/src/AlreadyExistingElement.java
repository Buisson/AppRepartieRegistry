/**
 * Created by user on 09/05/16.
 */
public class AlreadyExistingElement extends RuntimeException  {

    public String toString(){
        return "L'objet que vous essayez de bind est déja bind.";
    }
}
