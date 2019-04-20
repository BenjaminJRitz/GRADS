public class ProgressSummary {
    StudentRecord studentRecord;
    Double percentageComplete;

    ProgressSummary(StudentRecord record) {
        this.studentRecord = record;
    }

    /** 
     * This method will have to compute the GPA for the passed in student record.
     * This can get the grade for each class taken from the coursesTaken array.
    */
    double getGPA() {
        return 0;
    }

    String getStudentName() {
        return studentRecord.getStudent().getFirstName() +
         " " + studentRecord.getStudent().getLastName();
    }  // Ending bracket for method getStudentName

    String getAdvisorName() {
        return studentRecord.getAdvisor().getFirstName() +
         " " + studentRecord.getAdvisor().getLastName();
    }  // Ending bracket for method getAdvisorName

    String getSemesterBegan() {
        return studentRecord.getTermBegan().getSemesterBegan() +
         " " + studentRecord.getTermBegan().getYearBegan();
    }  // Ending bracket for method getSemesterBegan


}