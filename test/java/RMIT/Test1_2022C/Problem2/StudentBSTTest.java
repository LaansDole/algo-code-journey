package RMIT.Test1_2022C.Problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentBSTTest {
    StudentBST studentBST = new StudentBST();
    Student s1 = new Student(1, "A", 70.0);  // the first parameter is student id
    Student s2 = new Student(2, "B", 65.0);
    Student s3 = new Student(3, "C", 80.0);
    Student s4 = new Student(4, "D", 78.0);
    Student s5 = new Student(5, "E", 68.0);
    Student s6 = new Student(6, "F", 66.0);
    Student s7 = new Student(7, "G", 50.0);
    Student s8 = new Student(8, "H", 90.0);
    Student s9 = new Student(9, "I", 71.0);
    Student s10 = new Student(10, "J", 69.0);
    Student s11 = new Student(11, "K", 70.0);

    @Test
    void addStudent() {
        studentBST.addStudent(s1);
        studentBST.addStudent(s2);
        studentBST.addStudent(s3);
        studentBST.addStudent(s4);
        studentBST.addStudent(s5);
        studentBST.addStudent(s6);
        studentBST.addStudent(s7);
        studentBST.addStudent(s8);
        studentBST.addStudent(s9);
        studentBST.addStudent(s10);
        studentBST.addStudent(s11);

        studentBST.getTreeSize();
        studentBST.printTree(studentBST.studentRoot, "", true);

        assertEquals(71, studentBST.nextStudentEasy(s1).GPA);
    }
}