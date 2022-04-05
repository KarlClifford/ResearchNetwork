import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * BTS.
 * @version 1.0
 *
 * Created 24/03/2022.
 *
 * Last Modified 24/03/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This class repreesnts a binary search tree.
 */


public class BST {

    private BSTNode root;

    public BST() {

    }

    public BSTNode getRoot() {
        return root;
    }

    /**
     * Inserts a researcher into the BST.
     * @param p is the profile to be added to the BST.
     */
    public void insertResearcher(Profile p) {

        // Make new node to add to tree from p parameter
        final BSTNode NEW_NODE = new BSTNode(p);

        // Check if the root of this tree is null and set NEW_NODE to the root if it is.
        if (this.root == null) {
            this.root = NEW_NODE;
        } else {
            // Root isn't null so set this node as a branch of the tree.
            setNext(root, NEW_NODE);
        }
    }

    /**
     * Recursive method to set a child element in the BST depending on whether the child comes alphabetically
     * before or after the parent.
     * @param parent the parent node.
     * @param child the child node to be added as a child of the parent on either the Left or Right side.
     */
    private void setNext(BSTNode parent, BSTNode child) {

        // The integer comparison of the parent node to the child node.
        int comparison = child.getResearcher().getFamilyNames().compareTo(parent.getResearcher().getFamilyNames());

        // Check if the new researcher's name should be ordered left or right to the current node.
        if (comparison <= 0) {
            // newResearcher name is alphabetically before current researcher so go left.
            if (parent.getL() == null) {
                // Left node is empty so store new node here.
                parent.setL(child);
            } else {
                // Node is not empty so get the next node.
                setNext(parent.getL(), child);
            }
        } else {
            // newResearcher name is alphabetically after current researcher so go right.
            if (parent.getR() == null) {
                // Right node is empty so store new node here.
                parent.setR(child);
            } else {
                // Node is not empty so get the next node.
                setNext(parent.getR(), child);
            }
        }


    }

    /**
     * Prints the entire BST in alphabetical order of family names.
     * @return a String of alphabetically ordered profiles.
     */
    public String printAlphabetical() {

        // Set to pass into the getNext() function that will store researchers last name followed by their first name.
        SortedSet<String> profiles = new TreeSet<>();

        // This is the data we will return from this method after profiles have been formatted correctly.
        StringBuilder toOutput = new StringBuilder();

        // Iterate over each profile and make sure that each element will be printed on a new line.
        for (String profile : getNext(root, profiles)) {
            toOutput.append(profile).append("\n");
        }

        return toOutput.toString();
    }

    /**
     * Recursive method that scans the entire tree and returns each researcher it finds in a sorted set.
     * @param node is the node to scan.
     * @param profiles is the set of profiles to add results to.
     * @return a sorted set of researchers names in the format <FamilyName>, <GivenName>
     */
    private SortedSet<String> getNext(BSTNode node, SortedSet<String> profiles) {

        profiles.add(node.getResearcher().getFamilyNames() + ", " + node.getResearcher().getGivenNames());

        // Check the left child of this node, if it's not null get the child node.
        if (node.getL() != null) {
            getNext(node.getL(), profiles);
        }
        // Check the right child of this node, if it's not null get the child node.
        if (node.getR() != null) {
            getNext(node.getR(), profiles);
        }

        return profiles;
    }

    /**
     * This method checks if a specific profile exists in this binary tree.
     * @param familyName the profile to search for.
     * @return true if it exists and false if it does not exist.
     */
    private boolean hasProfile(String familyName){

        ArrayList<Profile> profiles = new ArrayList<>();

        // Iterate over each profile and check if the profile is the one we want to find.
        for (Profile profile : searchTree(root, profiles)) {
            if (profile.getFamilyNames().toLowerCase().contains(familyName.toLowerCase())) {
                return true;
            }
        }

        return false;

    }

    /**
     * Recursive method that scans the entire tree and returns each profile it finds in an array
     * @param node is the node to scan.
     * @param profiles is the set of profiles to add results to.
     * @return an array List of profiles.
     */
    public ArrayList<Profile> searchTree(BSTNode node, ArrayList<Profile> profiles) {

        profiles.add(node.getResearcher());

        // Check the left child of this node, if it's not null get the child node.
        if (node.getL() != null) {
            searchTree(node.getL(), profiles);
        }
        // Check the right child of this node, if it's not null get the child node.
        if (node.getR() != null) {
            searchTree(node.getR(), profiles);
        }

        return profiles;
    }

    /**
     * This method gets a profile from the BST.
     * @return a profile
     */
    public Profile getProfile(String familyName){

        //Check if the profile exists
        if (hasProfile(familyName)) {

            ArrayList<Profile> profiles = new ArrayList<>();

            // Iterate over each profile and retun the one we want to find.
            for (Profile profile : searchTree(root, profiles)) {
                if (profile.getFamilyNames().toLowerCase().contains(familyName.toLowerCase())) {
                    return profile;
                }
            }

        }
        // Profile doesn't exist so display an error message.
        System.out.println("Error profile doesn't exist!");

        //TODO this may cause an error.
        return null;
    }

    /*public void updateTree(Profile p) {
        updateNode(root, p);
    }

    *//**
     * Recursive method that scans the entire tree and updates a node within the BST
     * @param node is the node to scan.
     * @param p the profile to update.
     *//*
    private void updateNode(BSTNode node, Profile p) {

        if (this.root.getResearcher().equals(p)) {
            this.root = new BSTNode(p);
        }

        if (node.getL() == null && node.getR() == null) {
            System.out.println("ERROR!");
        }

        // Check the left child of this node, if it's not null get the child node.
        if (node.getL().getResearcher() == p) {
            BSTNode n = new BSTNode(p);
            n.setL(node.getL().getL());
            node.setL(n);
        } else {
            updateNode(node.getL(), p);
        }
        // Check the right child of this node, if it's not null get the child node.
        if (node.getR().getResearcher() == p) {
            BSTNode n = new BSTNode(p);
            n.setR(node.getR().getR());
            node.setR(n);
        } else {
            updateNode(node.getR(), p);
        }
    }*/

}
