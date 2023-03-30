package RMIT.Test1_2022C.Problem2;

public class StudentBST {
    Student studentRoot;
    int N; // Tree size
    public StudentBST() {
        studentRoot = null;
        N = 0;
    }

    // For testing
    public void printTree(Student node, String prefix, boolean isRight) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isRight ? "├── " : "└── ") + node.GPA);

        printTree(node.leftNode, prefix + (isRight ? "│   " : "    "), false);
        printTree(node.rightNode, prefix + (isRight ? "│   " : "    "), true);
    }

    public void getTreeSize() {
        System.out.println("Tree size: "+N);
    }

    public void addStudent(Student student) {
        if(studentRoot == null) {
            studentRoot = student;
            N++;
        } else {
            int index = 0;
            Student currentStudent = studentRoot;
            boolean isRight = true;
            while(index < N && currentStudent != student) {
                if(student.hasHigherGPA(currentStudent)) { // right side
                    currentStudent = setNext(currentStudent, student, isRight);
                } else { // left side
                    currentStudent = setNext(currentStudent, student, !isRight);
                }
                index++;
            }
        }
    }

    private Student setNext(Student currentStudent , Student addingStudent , boolean isRight) {
        if(currentStudent.hasNext(isRight)) {
            if(isRight) {
                return currentStudent.goToNext(currentStudent.rightNode, true);
            }
            return currentStudent.goToNext(currentStudent.leftNode, false);
        } else {
            N++;
            return currentStudent.goToNext(addingStudent, isRight);
        }
    }

    public Student nextStudentEasy(Student student) {
        boolean isRight = true;
        Student secondLowestStudent = student.rightNode;
        while(secondLowestStudent != null
                && secondLowestStudent.hasHigherGPA(student)
                && secondLowestStudent.hasNext(!isRight)) {

           secondLowestStudent = secondLowestStudent.leftNode;
        }
        return secondLowestStudent;
    }
//
//    public Student nextStudentGeneral(Student student) {
//
//    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "A", 70.0);  // the first parameter is student id
        Student s2 = new Student(2, "B", 65.0);
        Student s3 = new Student(3, "C", 80.0);
        Student s4 = new Student(4, "D", 78.0);
        Student s5 = new Student(5, "E", 68.0);
    }
}
