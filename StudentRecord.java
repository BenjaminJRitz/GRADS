public class StudentRecord {
    Student student;
    String major;
    TermBegan termBegan;
    Advisor advisor;
    CourseTaken[] coursesTaken = null;
    String[] notes = null;

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

    CourseTaken[] getCoursesTaken() {
        return coursesTaken;
    }  // Ending bracket for method getCoursesTaken

    String[] getNotes() {
        return notes;
    }  // Ending bracket for method getNotes
}  // Ending bracket for class StudentRecord