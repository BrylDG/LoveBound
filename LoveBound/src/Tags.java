import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Tags {
    public void TagsCustomization(User user) throws IOException, ClassNotFoundException {
        tagCompare compare = new tagCompare();
        Scanner sc = new Scanner(System.in);
        String[] choice1 = {"Urban","Cafe","Vintage","Seafood"};
        String[] choice2 = {"Seaside","Museum","Vegetarian","Dust"};
        String[] choice3 = {"Cityscape","FineDining","Cultural","Pollen"};
        String[] choice4 = {"Rural","Library","Foreign","Dairy"};
        String[] choice5 = {"Historical","Casual","Unique","Asthma"};
        String[] title = {"Place:","Style:","Theme:","Allergies"};
        //need ilisdan ang directory if mag change pc
        String filePath = "C:\\Users\\Bryl\\IdeaProjects\\LoveBound\\UsersTags\\" + user.username + "Tags.txt";
        System.out.println("Customize Tags:" + "\n1.Enter Tags \n2.Skip");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                for (int i = 0, j = 0; i < user.tags.length; i++, j++) {
                    if (i == 0) {
                        user.tags[i] = user.username;
                        j--;
                    } else {
                        System.out.println("\n" + title[j] + "\n1." + choice1[j] + "\n2." + choice2[j] + "\n3." + choice3[j] + "\n4." + choice4[j] + "\n5." + choice5[j]);
                        int num = sc.nextInt();
                        String chosenTag = null;
                        switch(num){
                            case 1:
                                chosenTag = choice1[j];
                                break;
                            case 2:
                                chosenTag = choice2[j];
                                break;
                            case 3:
                                chosenTag = choice3[j];
                                break;
                            case 4:
                                chosenTag = choice4[j];
                                break;
                            case 5:
                                chosenTag = choice5[j];
                                break;
                        }
                        user.tags[i] = chosenTag;
                    }
                }
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
                    out.writeObject(user);
                }
                System.out.println("Success!");
                compare.compare(user);
                break;
            case 2:
                compare.compare(user);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
