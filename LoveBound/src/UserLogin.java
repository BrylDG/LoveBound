import java.io.*;
import java.util.Scanner;

public class UserLogin {
    LoveBoundLogin login = new LoveBoundLogin();
    public void main() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        Tags tags = new Tags();
        String input;

        System.out.println("LOGIN:");
        System.out.print("Enter username: ");
        input = sc.nextLine();
        if (input.contentEquals(" ")){
            System.out.println("Enter valid username");
            main();
        } else {user.username = input;}

        System.out.print("Enter password: ");
        input = sc.nextLine();
        if (input.contentEquals(" ")){
            System.out.println("Enter valid password");
            main();
        } else {user.password = input;}

        if (login(user.username, user.password)) {
            System.out.println("Login successful!");
            tags.TagsCustomization(user);
        } else {
            System.out.println("Invalid username or password. Please try again.");
            LoveBoundLogin.main(null);
        }
        sc.close();
    }

    private static boolean login(String enteredUsername, String enteredPassword) throws IOException {
        //need ilisdan ang file directory if mag change ug pc
        String filePath = "C:\\Users\\Bryl\\IdeaProjects\\LoveBound\\Users\\" + enteredUsername + ".txt";

        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(filePath))) {
            User storedUser = (User) obj.readObject();

            return enteredUsername.equals(storedUser.username) && enteredPassword.equals(storedUser.password);
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
