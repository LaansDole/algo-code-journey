package RMIT.Test1_2022C.Problem2;

public class StudentNode<Student> {
    Student student;
    StudentNode<Student> leftNode;
    StudentNode<Student> rightNode;
    public StudentNode(Student stu) {
        student = stu;
        this.leftNode = null;
        this.rightNode = null;
    }

    public boolean hasNext(boolean right) {
        if(right) {
            return rightNode!=null;
        } else {
            return leftNode!=null;
        }
    }

    public StudentNode<Student> goToNext(StudentNode<Student> node, boolean right) {
        if(right) {
            this.rightNode = node;
            return rightNode;
        } else {
            this.leftNode = node;
            return leftNode;
        }
    }
}
