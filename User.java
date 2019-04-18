public class User {
    String userID;
    String firstName;
    String lastName;
    String role;
    String program;

    public User(String newUserID, String newFirstName, String newLastName, String newRole, String newProgram) {
        userID = newUserID;
        firstName = newFirstName;
        lastName = newLastName;
        role = newRole;
        program = newProgram;
    }

    String getUserID() {
        return userID;
    }
    String getFirstName() {
        return firstName;
    }
    String getLastName() {
        return lastName;
    }
    String getRole() {
        return role;
    }
    String getProgram() {
        return program;
    }
}