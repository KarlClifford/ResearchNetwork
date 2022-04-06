import java.util.ArrayList;

/**
 * BSTMain.
 * @version 1.0
 *
 * Created 24/03/2022.
 *
 * Last Modified 06/04/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This is a test class used to test the BST class.
 */

public class BSTMain {
    public static void main(String[] args) {

        // Make some profiles to add to the BST.

        Profile profile3 = new Profile("Church", "Alonzo",
                2001, 7, 12,
                "marcelle_paxtonjlmj@buy.kw",
                new ArrayList<String>());

        Profile profile2 = new Profile("Astarte", "Troy Kaighin",
                2002, 8, 1,
                "tyeisha_hunte@labeled.rgp",
                new ArrayList<String>());

        Profile profile1 = new Profile("Dijkstra", "Edsger Wybe",
                2003, 5, 12,
                "chasity_swim7mz@lectures.qo",
                new ArrayList<String>());



        // Make tree and add all profiles to tree
        BST tree = new BST();
        tree.insertResearcher(profile1);
        tree.insertResearcher(profile2);
        tree.insertResearcher(profile3);
    }
}
