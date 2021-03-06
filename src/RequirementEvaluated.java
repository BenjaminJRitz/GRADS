import java.util.ArrayList;

class RequirementEvaluated {
    Requirement r;
    boolean passed;
    ArrayList<CourseTaken> applicable = new ArrayList<>();
    String note;
    StudentRecord sr;

    public RequirementEvaluated(Requirement newRequirement, StudentRecord newsr) {
        sr = newsr;
        if (sr == null) {
        	System.out.println("TEST");
        }
        r = newRequirement;
        passed = false;
        switch (r.rule) {
            case GPA_GREATER_THAN_TWO:
                if (sr.getGPA() >= 2.0) 
                    passed = true;
                break;
            case APPLICATION_AREA:
                passed = true;
                //unimplemented
                break;
            case ONE_OF:
                process_X_of(1);
                break;
            case TWO_OF:
                process_X_of(2);
                break;
            case THREE_OF:
                process_X_of(3);
                break;
            case FOUR_OF:
                process_X_of(4);
                break;
            case NINE_OF:
                process_X_of(9);
                break;
            case ALL_OF:
                process_X_of(r.getCourses().length);
                break;
        }
    }

    private void process_X_of(int x) {
        int iflag = 0;
        for (int i = 0; i < r.getCourses().length; i++) {
            for (int j = 0; j < sr.getCoursesTaken().size(); j++) {
                if (r.getCourses()[i].equals(sr.getCoursesTaken().get(j).getCourse().getName())) {
                    iflag++;
                    applicable.add(sr.getCoursesTaken().get(j));
                    if (iflag == x) {
                        passed = true;
                        return;
                    }
                }
            }
        }
    }
}