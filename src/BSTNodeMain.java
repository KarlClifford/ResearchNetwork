import java.util.ArrayList;

/**
 * BTSNodeMain.
 * @version 1.0
 *
 * Created 24/03/2022.
 *
 * Last Modified 24/03/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This is a test class used to test the BSTNode class.
 */

public class BSTNodeMain {
    public static void main(String[] args) {

        // Make an array of interests to issue to Profile 1.
        ArrayList<String> profile1ResearchInts = new ArrayList<>();

        profile1ResearchInts.add("Computer Science");
        profile1ResearchInts.add("AI");

        // Make a test profile.
        Profile profile1 = new Profile("John", "Appleseed",
                2003, 12, 5,
                "johnappleseed@gmail.com", profile1ResearchInts);

        // Make an array of interests to issue to Profile 2.
        ArrayList<String> profile2ResearchInts = new ArrayList<>();
        profile2ResearchInts.add("Theoretical Science");
        profile2ResearchInts.add("Computer vision");

        // Make the second test profile.
        Profile profile2 = new Profile("Jane", "Doe",
                2002, 6, 3,
                "janedoe@gmail.com", profile2ResearchInts);

        // Make an array of interests to issue to Profile 3.
        ArrayList<String> profile3ResearchInts = new ArrayList<>();
        profile3ResearchInts.add("Theoretical Science");
        profile3ResearchInts.add("Computer vision");

        // Make the third test profile.
        Profile profile3 = new Profile("James", "Ash",
                2002, 6, 3,
                "janedoe@gmail.com", profile3ResearchInts);

        // Make nodes for testing.
        BSTNode rootTestNode = new BSTNode(profile1);
        BSTNode TestNodeL = new BSTNode(profile2);
        BSTNode TestNodeR = new BSTNode(profile3);

        rootTestNode.setL(TestNodeL);
        rootTestNode.setR(TestNodeR);

        // Print tree
        System.out.println("ROOT: " + rootTestNode.getResearcher()
                + "\nLEFT: " + rootTestNode.getL().getResearcher()
                + " RIGHT: " + rootTestNode.getR().getResearcher());

        System.out.println("LeftNode: " + rootTestNode.getL().getResearcher()
                + "\nLEFT: " + rootTestNode.getL().getL()
                + " RIGHT: " + rootTestNode.getL().getR());

        System.out.println("RightNode: " + rootTestNode.getR().getResearcher()
                + "\nLEFT: " + rootTestNode.getR().getL()
                + " RIGHT: " + rootTestNode.getR().getR());
    }
}
