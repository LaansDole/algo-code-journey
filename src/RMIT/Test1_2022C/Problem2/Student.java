package RMIT.Test1_2022C.Problem2;

public class Student {
    int id;
    String name;
    double GPA;
    Student leftNode;
    Student rightNode;
    public Student(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
        this.leftNode = null;
        this.rightNode = null;
    }

    public boolean hasHigherGPA(Student student) {
       return this.GPA > student.GPA;
    }

    public boolean hasNext(boolean isRight) {
        if(isRight) {
            return rightNode!=null;
        } else {
            return leftNode!=null;
        }
    }

    public Student setNext(Student student, boolean isRight) {
       if(isRight) {
           this.rightNode = student;
           return rightNode;
       } else {
           this.leftNode = student;
           return leftNode;
       }
    }
}
