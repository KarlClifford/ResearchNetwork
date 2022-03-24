import java.util.ArrayList;

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

    private String emailAddress;

    private ArrayList<String> researchInts = new ArrayList<>();

    //private static HashMap<Profile, ArrayList<Profile>> collaborators = new HashMap<>();
    private ArrayList<Profile> collaborators = new ArrayList<>();

    public Profile(String familyNames, String givenNames, int yearPhD,
                   int monthPhD, int dayPhD, String emailAddress,
                   ArrayList<String> researchInts) {
        setFamilyNames(familyNames);
        setGivenNames(givenNames);
        setYearPhD(yearPhD);
        setMonthPhD(monthPhD);
        setDayPhD(dayPhD);
        setEmailAddress(emailAddress);
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
        return getYearPhD() + "-" + getMonthPhD() + "-" + getDayPhD();
    }

    /**
     * Adds a collaborator profile to the collaborators data structure.
     * @param p the researcher's profile to be added.
     */
    void collaborate(Profile p) {
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
                + ", PhDIssueDate=" + getDateOfPhD()
                + ", emailAddress='" + emailAddress + '\''
                + ", researchInts=" + researchInts
                + '}';
    }
}
