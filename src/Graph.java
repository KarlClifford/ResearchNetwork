import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Graph.
 * @version 1.0
 *
 * Created 05/04/2022.
 *
 * Last Modified 24/03/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This class repreesnts a Graph with a binary search tree.
 */

public class Graph {

    BST tree;

    public Graph(String filename, BST tree) {
        this.tree = tree;
        readCollaborators(filename);
    }

    private void readCollaborators(String filename) {
        // Read the file and add each collaborator pair.
        try {
            File file = new File(filename);

            Scanner in = new Scanner(file);

            //
            while (in.hasNextLine()) {
                String[] collaborators = in.nextLine().split(",");
                addCollaborator(collaborators);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
    }

    private void addCollaborator(String[] collaborators) {
        // Find profiles.
        Profile p1 = tree.getProfile(collaborators[0]);
        Profile p2 = tree.getProfile(collaborators[1]);

        // Ensure both profiles have a value and that we haven't fetched the same two profiles.
        if((p1 != null && p2 != null) && (!p1.equals(p2))) {
            // Add these profiles as collaborators
            p1.collaborate(p2);
        }

        //TODO: Place collaborators back into the BST?
        //this.tree.updateTree(p1);
        //this.tree.updateTree(p2);


    }

    private Profile getInfluencer(String familyNames) {
        //Get the profile in question.
        Profile p1 = tree.getProfile(familyNames);
        Profile p2 = null;

        //Search through the BST for a suitable influencer.
        //ArrayList<Profile> profiles = new ArrayList<>();
        //tree.searchTree(tree.getRoot(), profiles);

        /*int profileIndex = 0;
        Profile profileOne = null;
        Profile profileTwo = null;

        while(profileIndex < profiles.size()) {
            profileOne = profiles.get(profileIndex);
            if(profileIndex + 1 > profiles.size()) {
                profileTwo = profiles.get(profileIndex + 1);
            } else {
                // Increment profileIndex to exit loop
                profileIndex ++;
            }

            if (profileTwo != null && (profileOne.equals(thisProfile)
                    || profileOne.hasCollaboratedWith(thisProfile)
                    || (profileOne.numOfCollabs() < profileTwo.numOfCollabs()))) {
                // Get the next profile
                profileIndex++;
            }
        }

        return profileOne;*/

        ArrayList<Profile> profiles = new ArrayList<>();
        tree.searchTree(tree.getRoot(), profiles);
        Comparator<Profile> comparator = new ProfileComparator();
        PriorityQueue<Profile> prio = new PriorityQueue<>(comparator);
        prio.addAll(profiles);

        while (!prio.isEmpty()) {
            p2 = prio.poll();
            if (!p1.equals(p2) && !p1.hasCollaboratedWith(p2)) {
                return p2;
            }
        }

        //No suituble profile found!
        return p1;
    }

    public Profile findInfluencer(String familyName) {
        return getInfluencer(familyName);
    }
}

class ProfileComparator implements Comparator<Profile> {
    public int compare(Profile p1, Profile p2) {
        return Integer.compare(p2.numOfCollabs(), p1.numOfCollabs());
    }
}
