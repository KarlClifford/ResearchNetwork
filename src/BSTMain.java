import java.util.ArrayList;

/**
 * BTSMain.
 * @version 1.0
 *
 * Created 24/03/2022.
 *
 * Last Modified 24/03/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This is a test class used to test the BST class.
 */

public class BSTMain {
    public static void main(String[] args) {

        // Make some profiles to add to the tree.
        Profile profile1 = new Profile("Aureliano", "Gittel Kilgore",
                2001, 7, 12,
                "marcelle_paxtonjlmj@buy.kw",
                new ArrayList<String>());

        Profile profile2 = new Profile("Banene", "Christiana Boothe",
                2002, 8, 1,
                "tyeisha_hunte@labeled.rgp",
                new ArrayList<String>());

        Profile profile3 = new Profile("Byishia", "Ronnell Bishop",
                2003, 5, 12,
                "chasity_swim7mz@lectures.qo",
                new ArrayList<String>());

        Profile profile4 = new Profile("Catisia", "Shandee Albrecht",
                2004, 7, 22,
                "micholas_ringerfakv@picks.eh",
                new ArrayList<String>());

        Profile profile5 = new Profile("Dhamara", "Makia Waldman",
                2004, 12, 19,
                "jiles_janssenib@status.ktc",
                new ArrayList<String>());

        // Make tree and add all profiles to tree
        BST tree = new BST();
        tree.insertResearcher(profile1);
        tree.insertResearcher(profile2);
        tree.insertResearcher(profile3);
        tree.insertResearcher(profile4);
        tree.insertResearcher(profile5);


    }

}
