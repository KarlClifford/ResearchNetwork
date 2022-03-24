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

        // Make an array of interests to issue to Profile 1.
        ArrayList<String> profile1ResearchInts = new ArrayList<>();

        profile1ResearchInts.add("Computer Science");
        profile1ResearchInts.add("AI");

        // Make a test profile.
        Profile profile1 = new Profile("John", "Appleseed", 2003, 12, 5, "johnappleseed@gmail.com", profile1ResearchInts);

        // Make an array of interests to issue to Profile 2.
        ArrayList<String> profile2ResearchInts = new ArrayList<>();
        profile2ResearchInts.add("Theoretical Science");
        profile2ResearchInts.add("Computer vision");

        // Make the second test profile.
        Profile profile2 = new Profile("Jane", "Doe", 2002, 6, 3, "janedoe@gmail.com", profile2ResearchInts);

         /*
          * Testing the collaborate feature. This should make profile 2 a collaborator of profile 1
          * and profile 1 a collaborator of profile 2.
          */
        profile1.collaborate(profile2);

        System.out.println(profile1);
        System.out.println(profile2);

        /*
         * A successful test would be indicated if the num of collabs are the same
         * for profile 1 and profile 2.
         */
        System.out.println("PROFILE 1 NUM OF COLLABS: " + profile1.numOfCollabs());
        System.out.println("HAS PROFILE 1 COLLABORATED WITH PROFILE 2? " + profile1.hasCollaboratedWith(profile2));

        System.out.println("PROFILE 2 NUM OF COLLABS: " + profile2.numOfCollabs());
        System.out.println("HAS PROFILE 2 COLLABORATED WITH PROFILE 1? " + profile2.hasCollaboratedWith(profile1));

    }
}
