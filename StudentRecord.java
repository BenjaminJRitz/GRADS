import java.util.ArrayList;

public class StudentRecord {
    Student student;
    String major;
    TermBegan termBegan;
    Advisor advisor;
    ArrayList<CourseTaken> coursesTaken = new ArrayList<>();
    ArrayList<String> notes = new ArrayList<>();

    Student getStudent() {
        return student;
    }  // Ending bracket for method getStudent
    
    String getMajor() {
        return major;
    }  // Ending bracket for method getMajor

    TermBegan getTermBegan() {
        return termBegan;
    }  // Ending bracket for method getTermBegan

    Advisor getAdvisor() {
        return advisor;
    }  // Ending bracket for method getAdvisor

    ArrayList<CourseTaken> getCoursesTaken() {
        return coursesTaken;
    }  // Ending bracket for method getCoursesTaken

    ArrayList<String> getNotes() {
        return notes;
    }  // Ending bracket for method getNotes

    void addCourse(CourseTaken c) {
        coursesTaken.add(c);
    }

    void addNote(String n) {
        notes.add(n);
    }

    double getGPA() {
        double gradePoints = 0;
        double units = 0;
        for (CourseTaken c : coursesTaken) {
            if (c.getGrade() != Grade.INVALID) {
                units += c.getCourse().getNumCredits();
                gradePoints += c.getGrade().value() * c.getCourse().getNumCredits();
            }
        }
        return gradePoints / units;
    }
}  // Ending bracket for class StudentRecord