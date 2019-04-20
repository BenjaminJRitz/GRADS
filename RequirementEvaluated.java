import java.util.ArrayList;

class RequirementEvaluated {
    Requirement r;
    boolean passed;
    ArrayList<CourseTaken> applicable = new ArrayList<>();
    String note;

    public RequirementEvaluated(Requirement newRequirement, StudentRecord sr) {
        boolean bflag;
        int iflag = 0;
        switch (r.rule) {
            case GPA_GREATER_THAN_TWO:
                passed = true;
                break;
            case ONE_OF:
                passed = false;
                for (int i = 0; i < r.getCourses().length; i++) {
                    for (int j = 0; j < sr.getCoursesTaken().length; j++) {
                        if (r.getCourses()[i].equals(sr.getCoursesTaken()[j].getCourse().getName())) {
                            passed = true;
                            applicable.add(sr.getCoursesTaken()[j]);
                            return;
                        }
                    }
                }
                break;
            case ALL_OF:
                passed = true;
                for (int i = 0; i < r.getCourses().length; i++) {
                    bflag = false;
                    for (int j = 0; j < sr.getCoursesTaken().length; j++) {
                        if (r.getCourses()[i].equals(sr.getCoursesTaken()[j].getCourse().getName())) {
                            bflag = true;
                            applicable.add(sr.getCoursesTaken()[j]);
                            break;
                        }
                    }
                    if (bflag ==  false) {
                        passed = false;
                    }
                }
                break;
            case TWO_OF:
                passed = false;
                for (int i = 0; i < r.getCourses().length; i++) {
                    for (int j = 0; j < sr.getCoursesTaken().length; j++) {
                        if (r.getCourses()[i].equals(sr.getCoursesTaken()[j].getCourse().getName())) {
                            iflag++;
                            if (iflag < 2) {
                                applicable.add(sr.getCoursesTaken()[j]);
                            } else {
                                passed = true;
                                return;
                            }
                        }
                    }
                }
                break;
            case THREE_OF:
                passed = false;
                for (int i = 0; i < r.getCourses().length; i++) {
                    for (int j = 0; j < sr.getCoursesTaken().length; j++) {
                        if (r.getCourses()[i].equals(sr.getCoursesTaken()[j].getCourse().getName())) {
                            iflag++;
                            if (iflag < 3) {
                                applicable.add(sr.getCoursesTaken()[j]);
                            } else {
                                passed = true;
                                return;
                            }
                        }
                    }
                }
                break;
            default:
                passed = true;
        }
    }
}