public class Course {
    String name;
    String id;
    String numCredits;

    String getName() {
        return name;
    }  // Ending bracket for method getName

    String getId() {
        return id;
    }  // Ending bracket for method getId

    double getNumCredits() {
        return Double.parseDouble(numCredits);
    }  // Ending bracket for method getNumCredits
    
}  // Ending bracket for class Course