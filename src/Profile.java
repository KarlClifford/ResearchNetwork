import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    // PHD awarded date is split over three variables for day, month and year.
    private int yearPhD;
    private int monthPhD;
    private int dayPhD;

    private String emailAddress;

    private ArrayList<String> researchInts = new ArrayList<>();

    private static HashMap<Profile, ArrayList<Profile>> collaborators = new HashMap<>();

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
        collaborators.put(this, null);
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

            // profiles will store old collaborators and append the new collaborator to the end.
            ArrayList<Profile> profiles = new ArrayList<>();

            // Check if this researcher has collaborated with anyone.
            if (collaborators.get(this) == null) {
                // This researcher has never collaborated so make a new collaboration.
                profiles.add(p);
            } else {
                /*
                 * This researcher has collaborated before so update existing collaborators
                 * as long as p is not already a collaborator.
                 */
                if (!collaborators.get(this).contains(p)) {
                    profiles = collaborators.get(this);
                    profiles.add(p);
                }
            }

            // Replace the old profiles with the new profiles.
            collaborators.put(this, profiles);

            // This researcher has collaborated with p so add this researcher to P's collaborators.
            p.collaborate(this);
        }
    }

    /**
     * Determines whether this research has collaborated with another named researcher.
     * @param p the researcher's profile to be checked.
     * @return true if researcher has collaborated or false if not collaborated with.
     */
    public boolean hasCollaboratedWith(Profile p) {
        // Check this collaborator has any collaborators
        if (collaborators.get(this) != null) {
            // Check if this researcher has collaborated with p
            return collaborators.get(this).contains(p);
        } else {
            // collaborators object is null so this researcher hasn't collaborated with p.
            return false;
        }
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
                + ", emailAddress='" + emailAddress + '\''
                + ", researchInts=" + researchInts
                + '}';
    }
}
