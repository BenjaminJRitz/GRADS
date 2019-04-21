public class Requirement {
    String title;
    RequirementType rule;
    String[] classes;

    Requirement(String pTitle, RequirementType pRule, String[] pClasses) {
        title = pTitle;
        rule = pRule;
        classes = pClasses;

    }

    String[] getCourses() {
        return classes;
    }
}