public class StudentRecord {
    //student:
        String studentID;
        String networkId;
        String firstName;
        String lastName;
        
        //perhaps major should be its own class
        String major;
            String termBegan;
            String semester;
            String year;
        //perhaps advisor should be its own class
        Advisor advisor;
            //String program;
            //String firstName;
            //String lastName;
        CourseTaken[] coursesTaken;
        String[] notes;

}