import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GRADS {
    static HashMap<String, User> users;
    static HashMap<String, StudentRecord> records;
    static HashMap<String, Course> courses;
    User currentUser;

    public static void main(String[] args) throws Exception {
        users = new HashMap<>();
        courses = new HashMap<>();
        records = new HashMap<>();
        System.out.println("Printing users names.");
        loadUsers("users.json");
        System.out.println("Printing course names");
        loadCourses("courses.json");
        System.out.println("Printing student id's from student records.");
        loadRecords("students.json");
        System.out.println("HELLO");
    }
    /**
     * Loads the list of system usernames and permissions.
     * @param usersFile the filename of the users file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
    public static void loadUsers(String usersFile) throws Exception {
        try (FileReader reader = new FileReader(usersFile)) {
            Gson gson = new Gson();
            User[] u = gson.fromJson(reader, User[].class);
            for (int i = 0; i < u.length; i++) {
                users.put(u[i].getNetworkID(), u[i]);
            }
        }
    }

    /**
     * Loads the list of courses.
     * @param coursesFile the filename of the users file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
    public static void loadCourses(String coursesFile) throws Exception {
        try (FileReader reader = new FileReader(coursesFile)) {
            Gson gson = new Gson();
            Course[] u = gson.fromJson(reader, Course[].class);
            for (int i = 0; i < u.length; i++) {
                //System.out.println(u[i].getName());
                courses.put(u[i].getName(), u[i]);
            }
        }  // Ending bracket for try
    }  // Ending bracket for method loadCourses

    /**
     * Loads the list of system transcripts.
     * @param recordsFile the filename of the transcripts file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
    public static void loadRecords(String recordsFile) throws Exception {
        try (FileReader reader = new FileReader(recordsFile)) {
            Gson gson = new Gson();
            StudentRecord[] u = gson.fromJson(reader, StudentRecord[].class);
            for (int i = 0; i < u.length; i++) {
                records.put(u[i].getStudent().getNetworkID(), u[i]);
            }
            for (int i = 0; i < u.length; i++) {
                System.out.println(u[i].getStudent().getStudentId());
                System.out.println(u[i].getMajor());
                System.out.println(u[i].getAdvisor().getFirstName());
                System.out.println(u[i].getTermBegan().getYearBegan());
                if (u[i].getNotes().get(0) != null) {
                    System.out.println(u[i].getNotes().get(0));
                }  // Ending bracket for if statement
                if (u[i].getCoursesTaken() != null) {
                    for (int j = 0; j < u[i].getCoursesTaken().size(); j++) {
                        System.out.println(u[i].getCoursesTaken().get(j).getGrade());
                    }  // Ending bracket for inner for loop
                } else {
                    System.out.println("This student has no Grades");
                }  // Ending bracket for if else
            }  // Ending bracket for for loop
        }  // Ending bracket for try
    }  // Ending bracket for method loadCourses

    /**
     * Sets the user id (X500) of the user currently using the system.
     * @param userId  the X500 id of the user generating progress summaries.
     * @throws Exception  if the user id is invalid.  SEE NOTE IN CLASS HEADER.
     * @throws UserNotFoundException 
     */
    public void setUser(String userId) throws UserNotFoundException {
        if (users.containsKey(userId)) {
            currentUser = users.get(userId);
        } else {
            //throw some error
        	throw new UserNotFoundException(userId + " not found in user file");
        }
    }
    

    
    /**
     * Gets the user id of the user currently using the system.
     * @return  the X500 user id of the user currently using the system.
     */
    public String getUser() {
        return currentUser.getNetworkID();
    }
    
    /**
     * Gets a list of the userIds of the students that a GPC can view.
     * @return a list containing the userId of for each student in the
     *      system belonging to the current user 
     * @throws Exception is the current user is not a GPC.
     */
    public List<String> getStudentIDs() throws Exception {
        ArrayList<String> rv = new ArrayList<>();
        if (currentUser.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")) {
            for (StudentRecord sr : records.values()) {
                if (sr.getMajor().equals(currentUser.getProgram())) {
                    rv.add(sr.getStudent().getNetworkID());
                }
            }
        } else {
            //throw some error
        }
        return rv;
    }
    
    /**
     * Gets the raw student record data for a given userId.
     * @param userId  the identifier of the student.
     * @return  the student record data.
     * @throws Exception  if the form data could not be retrieved.  SEE NOTE IN 
     *      CLASS HEADER.
     */
    public StudentRecord getTranscript(String userId) throws Exception {
        StudentRecord rv = null;
        if (records.containsKey(userId)) {
            rv = records.get(userId);
        } else {
            //throw some error
        }
        return rv;
    }
    
    /**
     * Saves a new set of student data to the records data.  
     * @param userId the student ID to overwrite.
     * @param transcript  the new student record
     * @throws Exception  if the transcript data could not be saved, failed
     * a validity check, or a non-GPC tries to call.  SEE NOTE IN CLASS HEADER.
     */
    public void updateTranscript(String userId, StudentRecord transcript) throws Exception {
        if (currentUser.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")) {
            records.put(userId, transcript);
        } else {
            //throw some error
        }
    }

    /**
     * Appends a note to a student record.  
     * @param userId the student ID to add a note to.
     * @param note  the note to append
     * @throws Exception  if the note could not be saved or a non-GPC tries to call. 
     * SEE NOTE IN CLASS HEADER.
     */
    public void addNote(String userId, String note) throws Exception {
        if (currentUser.getRole().equals("GRADUATE_PROGRAM_COORDINATOR")) {
            records.get(userId).addNote(note);
        } else {
            //throw some error
        }
    }

    /**
     * Generates progress summary
     * @param userId the student to generate the record for.
     * @returns the student's progress summary in a data class matching the I/O file.
     * @throws Exception  if the progress summary could not be generated.  
     * SEE NOTE IN CLASS HEADER.
     */
    public ProgressSummary generateProgressSummary(String userId) throws Exception {
        return new ProgressSummary(this.getTranscript(userId));
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
        StudentRecord sr = getTranscript(userId);
        for (CourseTaken c : courses) {
            sr.addCourse(c);
        }
        return new ProgressSummary(sr);
    }
}