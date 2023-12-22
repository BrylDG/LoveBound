import java.io.*;
import java.util.Scanner;

public class UserRegistrationSerialization {
    public void main() throws IOException {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        String input;
        System.out.println("Enter username: ");
        input = sc.nextLine();
        if (input.contentEquals(" ")){
            System.out.println("Enter valid username");
            main();
        } else
        user.username = input;
        System.out.println("Enter password: ");
        input = sc.nextLine();
        if (input.contentEquals(" ")){
            System.out.println("Enter valid password");
            main();
        } else
        user.password = input;
        //need ilisdan ang file directory if mag change ug pc
        String filePath = "C:\\Users\\Bryl\\IdeaProjects\\LoveBound\\Users\\" + user.username + ".txt";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(user);
        }

        System.out.println("Success!");
    }
}
