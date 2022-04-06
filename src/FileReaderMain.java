/**
 * FileReaderMain.
 * @version 1.0
 *
 * Created 26/03/2022.
 *
 * Last Modified 06/04/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This is a test class used to test the FileReader class.
 */

public class FileReaderMain {
    public static void main(String[] args) {
        // Read a file to make a BST throw an error if file reading has failed.
        BST bst = FileReader.readResearcherProfiles("researchers.txt");
    }
}
