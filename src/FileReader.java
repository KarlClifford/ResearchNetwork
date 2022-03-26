import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * FileReader.
 * @version 1.0
 *
 * Created 26/03/2022.
 *
 * Last Modified 26/03/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This class is used to read data from a file and create profiles based on the attributes of that data
 */

public class FileReader {

    public static BST readResearcherProfiles(String filename) {

        // BST to be returned.
        BST bst = new BST();

        // profiles to be added to the tree.
        Queue<Profile> profiles = new LinkedList<>();

        // Read the file and pass each line into createProfile method.
        try {
            File file = new File(filename);

            Scanner in = new Scanner(file);

            // Iterate over the file and creates a new profile for each line read in.
            while (in.hasNextLine()) {
                profiles.add(createProfile(in.nextLine()));
            }

            // Create the tree from the profiles.
            bst = createTree(profiles);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        return bst;
    }

    private static Profile createProfile(String input) {

        Scanner read = new Scanner(input);
        read.useDelimiter(",");

        // Store profile attributes from scanner.
        final String GIVEN_NAME = read.next();
        final String FAMILY_NAMES = read.next();

        //TODO: The format of the test data and the description conflicts. Test to find out if this is right.
        final String[] DATE = read.next().split("-");

        final int YEAR_PHD = Integer.parseInt(DATE[0]);
        final int MONTH_PHD = Integer.parseInt(DATE[1]);
        final int DAY_PHD = Integer.parseInt(DATE[2]);

        final String EMAIL = read.next();

        final String[] RESEARCH_INTS = read.next().split("/");

        ArrayList<String> researchInts = new ArrayList<>(Arrays.asList(RESEARCH_INTS));


        return new Profile(FAMILY_NAMES, GIVEN_NAME, YEAR_PHD, MONTH_PHD, DAY_PHD, EMAIL, researchInts);

    }

    private static BST createTree(Queue<Profile> profiles) {
        // Create an empty tree. We will store profiles in this tree that were read from the file.
        BST bst = new BST();

        // Iterate over queue and add every profile to the tree.
        for (Profile profile : profiles) {
            bst.insertResearcher(profile);
        }
        return bst;
    }
}
