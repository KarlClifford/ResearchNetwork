import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Graph.
 * @version 1.0
 *
 * Created 05/04/2022.
 *
 * Last Modified 06/04/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This class repreesnts a Graph with a binary search tree.
 */

public class Graph {

    protected BST tree;

    public Graph(String filename, BST tree) {
        this.tree = tree;
        readCollaborators(filename);
    }

    /**
     * reads collaborators from a given file.
     * @param filename the file to read.
     */
    private void readCollaborators(String filename) {
        // Read the file and throw an error if the filename is incorrect.
        try {
            File file = new File(filename);
            Scanner in = new Scanner(file);

            // Read each line and make a new collaborator pair from this.
            while (in.hasNextLine()) {
                String[] collaborators = in.nextLine().split(",");
                addCollaborator(collaborators);
            }
        } catch (FileNotFoundException e) {
            // File name is incorrect or file is missing, exit the program gracefully.
            System.out.println("File not found");
            System.exit(1);
        }
    }

    /**
     * Adds collaborators to profiles in the BST.
     * @param collaborators collaborators to add to the given profiles.
     */
    private void addCollaborator(String[] collaborators) {
        // Find profiles from the collaborators that were passed into this method.
        Profile p1 = tree.getProfile(collaborators[0]);
        Profile p2 = tree.getProfile(collaborators[1]);

        // Ensure both profiles have a value and that we haven't fetched the same two profiles.
        if ((p1 != null && p2 != null) && (!p1.equals(p2))) {
            // Add these profiles as collaborators
            p1.collaborate(p2);
        }
    }

    /**
     * Finds an influencer profile.
     * This is any profile that meets the following criteria:
     * 1. Has collaborated with the most people.
     * 2. Is not already collaborating with the given profile.
     * @param familyNames profile that we will find an influencer for.
     * @return an influencer.
     */
    private Profile getInfluencer(String familyNames) {
        // Get the profile from input. We will compare this to the profiles in the BST.
        Profile p1 = tree.getProfile(familyNames);
        Profile p2;

        // Pass an ArrayList into the searchTree() method to populate it with all the profiles in the BST.
        ArrayList<Profile> profiles = new ArrayList<>();
        tree.searchTree(tree.getRoot(), profiles);

        // Queue to store ordered profiles in.
        PriorityQueue<Profile> queue = new PriorityQueue<>(profiles);

        /*
         * Look at every top element in the queue, it is likely that we will have a successful hit within the first
         * few elements as the queue is already ordered.
         */
        while (!queue.isEmpty()) {

            // Remove the top element of the queue and store it for comparison.
            p2 = queue.poll();

            // Check that p2 isn't a duplicate of p1 and that these profiles are not already collaborating.
            if (!p1.equals(p2) && !p1.hasCollaboratedWith(p2)) {
                // This profile is a valid influencer so return it.
                return p2;
            }
        }

        // No profile in our BST meets the criteria to be an influencer so return our initial p1 profile.
        return p1;
    }

    /**
     * Use to find an influencer from outside this class.
     * @param familyName profile that we will find an influencer for.
     * @return an influencer.
     */
    public Profile findInfluencer(String familyName) {
        return getInfluencer(familyName);
    }
}
