/**
 * GraphMain.
 * @version 1.0
 *
 * Created 05/04/2022.
 *
 * Last Modified 06/04/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This is a test class used to test the Graph class.
 */

public class GraphMain {
    public static void main(String[] args) {

        // Make tree and add all profiles to tree.
        BST tree = FileReader.readResearcherProfiles("researchers.txt");

        // Make the graph and pass in this tree.
        Graph graph = new Graph("edges.txt", tree);

        // Get influencers.
        System.out.println("Candidate for Astarte: " + graph.findInfluencer("Astarte").getFamilyNames());
        System.out.println("Candidate for van Wijngaarden: " + graph.findInfluencer("van Wijngaarden").getFamilyNames());
    }
}
