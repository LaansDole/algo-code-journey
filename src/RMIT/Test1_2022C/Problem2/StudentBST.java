package RMIT.Test1_2022C.Problem2;

import RMIT.Week4.BinaryTree.BinaryTreeNode;

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
            while(index < N && currentStudent != student) {
                if(currentStudent.hasHigherGPA(student)) { // right side
                    currentStudent = addStudentHelper(currentStudent, student, true);
                } else { // left side
                    currentStudent = addStudentHelper(currentStudent, student, false);
                }
                index++;
            }
        }
    }

    private Student addStudentHelper(Student currentStudent , Student addingStudent , boolean isRight) {
        if(currentStudent.hasNext(isRight)) {
            if(isRight) {
                return currentStudent.setNext(currentStudent.rightNode, true);
            } else {
                return currentStudent.setNext(currentStudent.leftNode, false);
            }
        } else {
            N++;
            return currentStudent.setNext(addingStudent, isRight);
        }
    }

//    public Student nextStudentEasy(Student student) {
//
//    }
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
