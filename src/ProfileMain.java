import java.util.ArrayList;

/**
 * ProfileMain.
 * @version 1.0
 *
 * Created 23/03/2022.
 *
 * Last Modified 23/03/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This is a test class used to test the Profile class.
 */

public class ProfileMain {
    public static void main(String[] args) {

        ArrayList<String> profile1ResearchInts = new ArrayList<>();
        profile1ResearchInts.add("Computer Science");
        profile1ResearchInts.add("AI");
        Profile profile1 = new Profile("John", "Appleseed", 2003, 12, 5, "johnappleseed@gmail.com", profile1ResearchInts);

        ArrayList<String> profile2ResearchInts = new ArrayList<>();
        profile2ResearchInts.add("Theoretical Science");
        profile2ResearchInts.add("Computer vision");
        Profile profile2 = new Profile("Jane", "Doe", 2002, 6, 3, "janedoe@gmail.com", profile2ResearchInts);

        profile1.collaborate(profile2);

        System.out.println(profile1);
        System.out.println(profile2);

        System.out.println("PROFILE 1 NUM OF COLLABS: " + profile1.numOfCollabs());
        System.out.println("HAS PROFILE 1 COLLABORATED WITH PROFILE 2? " + profile1.hasCollaboratedWith(profile2));

        System.out.println("PROFILE 2 NUM OF COLLABS: " + profile2.numOfCollabs());
        System.out.println("HAS PROFILE 2 COLLABORATED WITH PROFILE 1? " + profile2.hasCollaboratedWith(profile1));

    }
}
