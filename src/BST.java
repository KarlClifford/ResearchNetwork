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

    public void insertResearcher(Profile p) {
        //System.out.println("INSERTING + " + p.getFamilyNames() + " " + p.getGivenNames());
        //System.out.println(p);

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

    private void setNext(BSTNode parent, BSTNode child) {

        // The integer representation of the first letter of the parent researcher's name.
        //int currentResearcher = parent
                //.getResearcher()
                //.getFamilyNames()
                //.toLowerCase()
                //.toCharArray()[0];

        // The integer representation of the first letter of the child researcher's name.
        //int newResearcher = child
                //.getResearcher()
                //.getFamilyNames()
                //.toLowerCase()
                //.toCharArray()[0];

        //System.out.println("RUNNING SET NEXT!");
        //System.out.println("PARENT: " + parent.getResearcher().getFamilyNames());
        //System.out.println("CHILD: "+ child.getResearcher().getFamilyNames());

        // The integer comparison of the parent node to the child node.
        int comparison = child.getResearcher().getFamilyNames().compareTo(parent.getResearcher().getFamilyNames());
        //System.out.println(comparison);

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
}
