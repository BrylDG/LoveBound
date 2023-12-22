import java.io.Serializable;
import java.util.Arrays;

public class User implements Serializable {
    public String[] tags = new String[5];
    String username;
    String password;

    public void sayHello(){
        System.out.println(Arrays.toString(tags));
    }
}
