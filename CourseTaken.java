public class CourseTaken {
    Course course;
    Term term;
    String grade;

    Course getCourse() {
        return course;
    }  // Ending bracket for method getCourse

    Term getTerm() {
        return term;
    }  // Ending bracket for method getTerm

    Grade getGrade() {
        return Grade.valueOf(grade);
    }  // Ending bracket for method getGrade
}  // Ending bracket for class Courseaken