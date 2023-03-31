package RMIT.Test1_2022C.Problem2;

public class StudentBST {
    StudentNode<Student> studentRoot;
    int N; // Tree size
    public StudentBST() {
        studentRoot = null;
        N = 0;
    }

    // For testing
    public void printTree(StudentNode<Student> node, String prefix, boolean right) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (right ? "├── " : "└── ") + node.student.GPA);

        printTree(node.leftNode, prefix + (right ? "│   " : "    "), false);
        printTree(node.rightNode, prefix + (right ? "│   " : "    "), true);
    }

    public void getTreeSize() {
        System.out.println("Tree size: "+N);
    }

    public void addStudent(Student student) {
        if(studentRoot == null) {
            studentRoot = new StudentNode<>(student);
            N++;
        } else {
            int index = 0;
            StudentNode<Student> currentStudentNode = studentRoot;
            StudentNode<Student> newStudentNode = new StudentNode<>(student);
            boolean right = true;

            while(index < N && currentStudentNode.student != student) {
                if(student.hasHigherGPA(currentStudentNode.student)) { // right side
                    currentStudentNode = setNext(currentStudentNode, newStudentNode, right);
                } else { // left side
                    currentStudentNode = setNext(currentStudentNode, newStudentNode, !right);
                }
                index++;
            }
        }
    }

    private StudentNode<Student> setNext(StudentNode<Student> currentNode , StudentNode<Student> newNode , boolean right) {
        if(currentNode.hasNext(right)) {
            if(right) {
                return currentNode.goToNext(currentNode.rightNode, true);
            }
            return currentNode.goToNext(currentNode.leftNode, false);
        } else {
            N++;
            return currentNode.goToNext(newNode, right);
        }
    }

    public StudentNode<Student> searchNodePreRecursive(StudentNode<Student> node, Student student) {
        if(node.student.GPA == student.GPA) {
            return node;
        }

        if(node.student.hasHigherGPA(student)) {
            node = node.leftNode;
            return searchNodePreRecursive(node, student);
        }

        node = node.rightNode;
        return searchNodePreRecursive(node, student);
    }

    // Assume the given student node has not-null left and right nodes
    public Student nextStudentEasy(Student student) {
        StudentNode<Student> currentNode = searchNodePreRecursive(studentRoot, student);
        boolean right = true;

        StudentNode<Student> secondLowestStudent = currentNode.rightNode;

        while(secondLowestStudent != null
                && secondLowestStudent.student.hasHigherGPA(student)
                && secondLowestStudent.hasNext(!right)) {

           secondLowestStudent = secondLowestStudent.leftNode;
        }
        return secondLowestStudent.student;
    }

    private StudentNode<Student> findParent(StudentNode<Student> root, StudentNode<Student> node) {
        if (root == null || root == node) {
            return null; // Root node has no parent
        }

        boolean right = true;

        if ((root.hasNext(!right) && root.leftNode == node)
                || (root.hasNext(right) && root.rightNode == node)) {
            return root;
        }

        if (root.student.GPA > node.student.GPA) {
            return findParent(root.leftNode, node);
        }

        return findParent(root.rightNode, node);
    }

    public Student nextStudentGeneral(Student student) {
        StudentNode<Student> currentNode = searchNodePreRecursive(studentRoot, student);
        boolean right = true;

        if(currentNode.hasNext(right)) {
            return nextStudentEasy(student);
        }

        StudentNode<Student> parentNode = findParent(studentRoot, currentNode);

        if(student.hasHigherGPA(parentNode.student) &&
                student.hasHigherGPA(studentRoot.student)) {
            return student; // Case 1:  There is no student that has more GPA than the right-most student

        } else if(student.hasHigherGPA(parentNode.student) &&
                studentRoot.student.hasHigherGPA(student)) {
            return studentRoot.student; // Case 2:
        }

        return parentNode.student;
    }

    public static void main(String[] args) {
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

        studentBST.printTree(studentBST.studentRoot, "", true);

    }
}
