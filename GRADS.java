import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GRADS {
    HashMap<String, User> users;

    public static void main(String[] args) throws Exception {
        System.out.println("Printing users names.");
        loadUsers("SS");
        System.out.println("Printing course names");
        loadCourses("TEST");
        System.out.println("HELLO");
    }
    /**
     * Loads the list of system usernames and permissions.
     * @param usersFile the filename of the users file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
    public static void loadUsers(String usersFile) throws Exception {
        try (FileReader reader = new FileReader("users.json")) {
            Gson gson = new Gson();
            User[] u = gson.fromJson(reader, User[].class);
            for (int i = 0; i < u.length; i++) {
                System.out.println(u[i].getNetworkID());
            }
        }
    }

    /**
     * Loads the list of courses.
     * @param coursesFile the filename of the users file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
    public static void loadCourses(String coursesFile) throws Exception {
        try (FileReader reader = new FileReader("courses.json")) {
            Gson gson = new Gson();
            Course[] u = gson.fromJson(reader, Course[].class);
            for (int i = 0; i < u.length; i++) {
                System.out.println(u[i].getName());
            }  // Ending bracket for for loop
        }  // Ending bracket for try
    }  // Ending bracket for method loadCourses

    /**
     * Loads the list of system transcripts.
     * @param recordsFile the filename of the transcripts file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
    public void loadRecords(String recordsFile) throws Exception {

    }

    /**
     * Sets the user id (X500) of the user currently using the system.
     * @param userId  the X500 id of the user generating progress summaries.
     * @throws Exception  if the user id is invalid.  SEE NOTE IN CLASS HEADER.
     */
    public void setUser(String userId) throws Exception {

    }
    
    /**
     * Gets the user id of the user currently using the system.
     * @return  the X500 user id of the user currently using the system.
     */
    public String getUser() {
        return "";
    }
    
    /**
     * Gets a list of the userIds of the students that a GPC can view.
     * @return a list containing the userId of for each student in the
     *      system belonging to the current user 
     * @throws Exception is the current user is not a GPC.
     */
    public List<String> getStudentIDs() throws Exception {
        return null;
    }
    
    /**
     * Gets the raw student record data for a given userId.
     * @param userId  the identifier of the student.
     * @return  the student record data.
     * @throws Exception  if the form data could not be retrieved.  SEE NOTE IN 
     *      CLASS HEADER.
     */
    public StudentRecord getTranscript(String userId) throws Exception {
        return null;
    }
    
    /**
     * Saves a new set of student data to the records data.  
     * @param userId the student ID to overwrite.
     * @param transcript  the new student record
     * @throws Exception  if the transcript data could not be saved, failed
     * a validity check, or a non-GPC tries to call.  SEE NOTE IN CLASS HEADER.
     */
    public void updateTranscript(String userId, StudentRecord transcript) throws Exception {

    }

    /**
     * Appends a note to a student record.  
     * @param userId the student ID to add a note to.
     * @param note  the note to append
     * @throws Exception  if the note could not be saved or a non-GPC tries to call. 
     * SEE NOTE IN CLASS HEADER.
     */
    public void addNote(String userId, String note) throws Exception {

    }

    /**
     * Generates progress summary
     * @param userId the student to generate the record for.
     * @returns the student's progress summary in a data class matching the I/O file.
     * @throws Exception  if the progress summary could not be generated.  
     * SEE NOTE IN CLASS HEADER.
     */
    public ProgressSummary generateProgressSummary(String userId) throws Exception {
        return null;
    }

    /**
     * Generates a new progress summary, assuming that the student passes the
     * provided set of prospective courses.
     * @param userId the student to generate the record for.
     * @param courses a list of the prospective courses.
     * @returns the student's hypothetical progress summary
     * @throws Exception  if the progress summary could not be generated or the courses  
     * are invalid. SEE NOTE IN CLASS HEADER.
     */
    public ProgressSummary simulateCourses(String userId, List<CourseTaken> courses) throws Exception {
        return null;
    }
}