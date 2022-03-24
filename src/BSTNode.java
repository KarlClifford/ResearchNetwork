/**
 * BTSNode.
 * @version 1.0
 *
 * Created 24/03/2022.
 *
 * Last Modified 24/03/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This class repreesnts a node for a binary search tree.
 */


public class BSTNode {

    private final Profile RESEARCHER;
    private BSTNode l;
    private BSTNode r;

    public BSTNode(Profile elm) {
        this.RESEARCHER = elm;
    }

    public Profile getResearcher() {
        return RESEARCHER;
    }

    public BSTNode getL() {
        return l;
    }

    public void setL(BSTNode l) {
        this.l = l;
    }

    public BSTNode getR() {
        return r;
    }

    public void setR(BSTNode r) {
        this.r = r;
    }
}
