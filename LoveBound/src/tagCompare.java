import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tagCompare {
    private ArrayList<Item> items;
    String[] allergies;
    String[] Seafood = {"Seaside","Coastal"};
    String[] Asthma = {"Outdoor", "Adventure"};
    String[] Dairy = {"Dairy", "Pastries"};
    String[] Pollen = {"Garden"};
    String[] Dust = {"Garden", "Outdoor"};


    public tagCompare() {
        items = new ArrayList<>();
        items.add(new Item("10,000 Roses Café ", "Cafe", "Seaside", "Romantic", "Outdoor", "Vegan", "Coffee"));
        items.add(new Item("10 Dove Street Confectionary", "Cafe", "Casual", "Cozy", "Aesthetic", "Coffee", "Pastries", "SugarFree"));
        items.add(new Item("Lighthouse Restaurant", "FineDining", "Vintage", "Indoor", "Vegan", "Seafood"));
        items.add(new Item("Buwakan ni Alejandra", "Scenic", "Rural", "Casual", "Scenic", "Cozy", "Cold", "Garden"));
        items.add(new Item("Abaseria Deli & Café", "Local", "Cultural", "Cafe", "Unique", "Vegan", "Souvenirs"));
        items.add(new Item("Mr. A Bar & Restaurant", "Bar", "FineDining", "Scenic", "Outdoor", "Cityscape"));
        items.add(new Item("Anzani Restaurant", "FineDining", "Foreign", "Outdoor", "Indoor"));
        items.add(new Item("Lakeview Le Jardin", "Scenic", "Outdoor", "Casual", "Cold", "Garden", "Adventure", "Vegetarian", "Dairy"));
        items.add(new Item("Circa 1900", "Cultural", "Historical", "Vintage", "Outdoor", "Indoor", "Vegetarian", "Dairy"));
        items.add(new Item("Sirao Garden – Little Amsterdam", "Scenic", "Outdoor", "Casual", "Cold", "Garden", "Adventure"));
        items.add(new Item("Top of Cebu", "Scenic", "Outdoor", "Casual", "Cold", "Cityscape", "Cozy", "Vegetarian"));
        items.add(new Item("Fort San Pedro", "Historical", "Museum", "Outdoors"));
        items.add(new Item("Cebu Ocean Park", "Aquarium", "Adventure", "ThemePark"));
        items.add(new Item("Lantaw Floating Native Restaurant", "ShoreSide", "Outdoor", "Seafood"));
        items.add(new Item("Zero-X Café", "Cafe", "Casual", "Aesthetic", "Foreign"));
        items.add(new Item("Café Talk Library", "Cafe", "Casual", "Aesthetic", "Cozy", "Books"));
        items.add(new Item("Casa Gorordo Museum", "Historical", "Vintage", "Museum", "Arts"));
        items.add(new Item("Sachiko’s Little Kyoto", "Foreign", "Outdoor", "Cold", "Cozy"));
        items.add(new Item("The Pig & Palm", "FineDining", "Outdoor", "Indoor", "Cozy", "Scenic"));
    }
    public void compare(User user) throws IOException, ClassNotFoundException {
        LoveBoundLogin login = new LoveBoundLogin();
        Tags tags = new Tags();
        Scanner sc = new Scanner(System.in);
        //need ilisdan ang directory if mag change pc
        String filePath = "C:\\Users\\Bryl\\IdeaProjects\\LoveBound\\UsersTags\\" + user.username + "Tags.txt";
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream(filePath));
        User storedTags = (User) obj.readObject();
        String[] fileTags = storedTags.tags;

        if (storedTags.tags[4].equalsIgnoreCase("seafood")){allergies = Seafood;}
        else if (storedTags.tags[4].equalsIgnoreCase("dairy")){allergies = Dairy;}
        else if (storedTags.tags[4].equalsIgnoreCase("asthma")){allergies = Asthma;}
        else if (storedTags.tags[4].equalsIgnoreCase("pollen")){allergies = Pollen;}
        else allergies = Dust;

        boolean a = true;
        while(a) {
            System.out.println("User tags: " + fileTags[1] + " , " + fileTags[2] + " , " + fileTags[3] + " , " + fileTags[4] + fileTags[0]);
            System.out.println("MENU: \n1.Generate Venues \n2.Change Tags \n3.Sign Out");
            switch (sc.nextInt()) {
                case 1:
                    displayMatchingItems(fileTags);
                    break;
                case 2:
                    tags.TagsCustomization(user);
                    break;
                case 3:
                    login.main(null);
                    break;
            }
        }
    }

    private void displayMatchingItems(String[] fileTags) {
        System.out.println("Venues matching the provided tags:");

        boolean foundMatchingItem = false;

        for (Item item : items) {
            if (item.hasTags(fileTags) && !hasCommonTag(item.taggs, allergies)) {
                System.out.println(item);
                foundMatchingItem = true;
            }
        }

        if (!foundMatchingItem) {
            System.out.println("No venues found with the provided.");
        }
    }

    private boolean hasCommonTag(String[] itemTags, String[] excludedTags) {
        for (String tag : itemTags) {
            for (String excludedTag : excludedTags) {
                if (tag.trim().equalsIgnoreCase(excludedTag.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class Item {
        private String name;
        private String[] taggs;

        public Item(String name, String... taggs) {
            this.name = name;
            this.taggs = taggs;
        }

        public boolean hasTags(String[] userTags) {
            for (String tag : userTags) {
                for (String itemTag : this.taggs) {
                    if (itemTag.trim().equalsIgnoreCase(tag.trim())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return "Venue: " + name + ", Tags: " + String.join(", ", taggs);
        }
    }
}
