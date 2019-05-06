import java.util.ArrayList;
import java.util.Arrays;

public class ProgressSummary {
    StudentRecord record;

    ProgressSummary(StudentRecord pRecord) {
        this.record = pRecord;
    }  // Ending bracket for constructor

    /** 
     * This method will have to compute the GPA for the passed in student record.
     * This can get the grade for each class taken from the coursesTaken array.
    */
    double getGPA() {
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

    ArrayList<RequirementEvaluated> getRequirements() {
        if (record == null) {
        	System.out.println("TEST2");
        }
        var rv = new ArrayList<>(Arrays.asList(GradReqs.evaluate(record)));
        switch (record.getMajor()) {
            case "COMPUTER_INFORMATION_SYSTEMS":
                rv.addAll(Arrays.asList(CompInfo.evaluate(record)));
                break;
            case "COMPUTER_SCIENCE":
                rv.addAll(Arrays.asList(CompSci.evaluate(record)));
                break;
            case "COMPUTER_ENGINEERING":
                rv.addAll(Arrays.asList(CompEng.evaluate(record)));
                break;
        }
        return rv;
    }  // Ending bracket for method getRequirements

    Double getCompletionPercentage() {
        var allMileStones = this.getRequirements();
        double completionPoints = 0.0;
        for (var c : allMileStones) {
            if (c.passed) {
                completionPoints += 1;
            }
        }
        return completionPoints/allMileStones.size();
    }
}