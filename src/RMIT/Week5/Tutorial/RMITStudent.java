package RMIT.Week5.Tutorial;

public class RMITStudent {
    String studentID;
    String fullName;
    String major;
    double GPA;

    public RMITStudent(String studentID, String fullName, String major, double GPA) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.major = major;
        this.GPA = GPA;
    }

    public static int hash(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        } else if (c >= '0' && c <= '9') {
            return c - '0' + 26;
        } else {
            throw new IllegalArgumentException("Invalid character: " + c);
        }
    }
}
