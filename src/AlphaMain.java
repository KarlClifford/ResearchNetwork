import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * BTS.
 * @version 1.0
 *
 * Created 05/04/2022.
 *
 * Last Modified 05/04/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This is a test class used to test the BST printAlpahbetical() traveral algorithim
 */

public class AlphaMain {
    public static void main(String[] args) {

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

        SortedSet<String> profiles = new TreeSet<>();

        System.out.println(tree.printAlphabetical());


    }
}
