import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Profile.
 * @version 1.0
 *
 * Created 23/03/2022.
 *
 * Last Modified 23/03/2022.
 * @author Karl Clifford.
 *
 * No Copyright.
 *
 * This class repreesnts a user profile for a researcher in the research network.
 */

public class Profile {

    private String familyNames;
    private String givenNames;

    // PhD awarded date is split over three variables for day, month and year.
    private int yearPhD;
    private int monthPhD;
    private int dayPhD;

    private String email;

    private ArrayList<String> researchInts = new ArrayList<>();

    //private static HashMap<Profile, ArrayList<Profile>> collaborators = new HashMap<>();
    private ArrayList<Profile> collaborators = new ArrayList<>();

    public Profile(String familyNames, String givenNames, int yearPhD,
                   int monthPhD, int dayPhD, String email,
                   ArrayList<String> researchInts) {
        setFamilyNames(familyNames);
        setGivenNames(givenNames);
        setYearPhD(yearPhD);
        setMonthPhD(monthPhD);
        setDayPhD(dayPhD);
        setEmail(email);
        setResearchInts(researchInts);
    }

    public String getFamilyNames() {
        return familyNames;
    }

    public void setFamilyNames(String familyNames) {
        this.familyNames = familyNames;
    }

    public String getGivenNames() {
        return givenNames;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    public String getName() {
        return getGivenNames() + ", " + getFamilyNames();
    }

    public int getYearPhD() {
        return yearPhD;
    }

    public void setYearPhD(int yearPhD) {
        this.yearPhD = yearPhD;
    }

    public int getMonthPhD() {
        return monthPhD;
    }

    public void setMonthPhD(int monthPhD) {
        this.monthPhD = monthPhD;
    }

    public int getDayPhD() {
        return dayPhD;
    }

    public void setDayPhD(int dayPhD) {
        this.dayPhD = dayPhD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getResearchInts() {
        return researchInts;
    }

    public void setResearchInts(ArrayList<String> researchInts) {
        this.researchInts = researchInts;
    }

    /**
     * Gets the full date that the PhD was received.
     * @return date in format YYYY-MM-DD.
     */
    public String getDateOfPhD() {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        return decimalFormat.format(getYearPhD())
                + "-"
                + decimalFormat.format(getMonthPhD())
                + "-"
                + decimalFormat.format(getDayPhD());
    }

    /**
     * Adds a collaborator profile to the collaborators data structure.
     * @param p the researcher's profile to be added.
     */
    public void collaborate(Profile p) {
        // Check this researcher hasn't already collaborated
        if (!hasCollaboratedWith(p)) {

            // Add p as a collaborator
            collaborators.add(p);

            // This researcher has collaborated with p so add this researcher to P's collaborators.
            p.collaborate(this);
        }
    }

    /**
     * Determines whether this researcher has collaborated with another named researcher.
     * @param p the researcher's profile to be checked.
     * @return true if researcher has collaborated or false if not collaborated with.
     */
    public boolean hasCollaboratedWith(Profile p) {
        // Check if this researcher has collaborated with p
        return collaborators.contains(p);
    }

    /**
     * Find the number of other researchers this researcher has collaborated with.
     * @return the number of researchers this user has collaborated with.
     */
    public int numOfCollabs() {
        return collaborators.size();
    }

    @Override
    public String toString() {
        return "Profile{"
                + "familyNames=" + familyNames
                + ", givenNames=" + givenNames
                + ", yearPhD=" + yearPhD
                + ", monthPhD=" + monthPhD
                + ", dayPhD=" + dayPhD
                + ", DatePhD=" + getDateOfPhD()
                + ", email='" + email + '\''
                + ", researchInts=" + researchInts
                + ", collaborators=" + collaborators
                                            .stream()
                                            .map(Profile::getName)
                                            .collect(Collectors.toCollection(ArrayList::new))
                + '}';
    }
}
