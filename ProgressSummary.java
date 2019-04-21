public class ProgressSummary {
    StudentRecord record;

    ProgressSummary(StudentRecord pRecord) {
        this.record = pRecord;
    }  // Ending bracket for constructor

    /** 
     * This method will have to compute the GPA for the passed in student record.
     * This can get the grade for each class taken from the coursesTaken array.
    */
    float getGPA() {
        return record.getGPA();
    }  // Ending bracket for method getGPA

    Student getStudent() {
        return record.getStudent();
    }  // Ending bracket for method getStudentName

    String getMajor() {
        return record.getMajor();
    }  // Ending bracket for method getMajor

    Advisor getAdvisor() {
        return record.getAdvisor();
    }  // Ending bracket for method getAdvisorName

    TermBegan getTermBegan() {
        return record.getTermBegan();
    }  // Ending bracket for method getSemesterBegan

    RequirementEvaluated[] getRequirements() {
        return null;
    }  // Ending bracket for method getRequirements


}