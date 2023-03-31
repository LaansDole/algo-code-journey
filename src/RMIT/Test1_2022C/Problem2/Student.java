package RMIT.Test1_2022C.Problem2;

public class Student {
    int id;
    String name;
    double GPA;
    public Student(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    public boolean hasHigherGPA(Student student) {
        return this.GPA > student.GPA;
    }

    public StudentNode<Student> getNode() {
        return new StudentNode<>(this);
    }
}
