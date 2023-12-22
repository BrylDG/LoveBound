import java.io.IOException;
import java.util.*;
public class LoveBoundLogin {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserRegistrationSerialization registration = new UserRegistrationSerialization();
        UserLogin login = new UserLogin();
        Tags tags = new Tags();
        int choice;
        do {
            System.out.println("Welcome to LoveBound, where dates matter.");
            System.out.println("\n1.Login" + "\n2.Register" + "\n3.Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    login.main();
                    choice = 3;
                    break;
                case 2:
                    registration.main();
                    break;
                case 3:
                    System.out.print("Exiting program!");
                    break;
                default:
                    System.out.print("Enter valid choice");
            }
        }
        while (choice != 3) ;
    }
}
