package RMIT.Test1_2022C.Problem2;

public class StudentBST {
    StudentNode<Student> studentRoot;
    int N; // Tree size
    private final static boolean right = true;
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

    private void insert(StudentNode<Student> studentNode, StudentNode<Student> root) {
        if(studentNode.student.hasHigherGPA(root.student)) { // right subtree
            if(root.hasNext(right)) {
                insert(studentNode, root.rightNode);
            } else {
                root.rightNode = studentNode;
            }
        } else {  // left subtree
            if(root.hasNext(!right)) {
                insert(studentNode, root.leftNode);
            } else {
                root.leftNode = studentNode;
            }
        }
    }

    private void insert(StudentNode<Student> studentNode) {
        insert(studentNode, studentRoot);
    }

    public void addStudent(Student student) {
        StudentNode<Student> newStudentNode = new StudentNode<>(student);

        if(studentRoot == null) {
            studentRoot = newStudentNode;

        } else {
            insert(newStudentNode);
        }
        N++;
    }

    public StudentNode<Student> getNodePreRecursive(Student student, StudentNode<Student> root) {
        if(root.student.GPA == student.GPA) {
            return root;
        }

        if(root.student.hasHigherGPA(student)) {
            root = root.leftNode;
            return getNodePreRecursive(student, root);
        }

        root = root.rightNode;
        return getNodePreRecursive(student, root);
    }

    private StudentNode<Student> getNodePreRecursive(Student student) {
        return getNodePreRecursive(student, studentRoot);
    }

    public Student nextStudentEasy(Student student) {
        StudentNode<Student> currentNode = getNodePreRecursive(student);

        // Assuming that given student node always have two not-null child node
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

        if ((root.hasNext(!right) && root.leftNode == node)
                || (root.hasNext(right) && root.rightNode == node)) {
            return root;
        }

        if (root.student.hasHigherGPA(node.student)) {
            return findParent(root.leftNode, node);
        }

        return findParent(root.rightNode, node);
    }

    private StudentNode<Student> findParent(StudentNode<Student> node) {
        return findParent(studentRoot, node);
    }

    public Student nextStudentGeneral(Student student) {
        StudentNode<Student> currentNode = getNodePreRecursive(student);

        if(currentNode.hasNext(right)) {
            return nextStudentEasy(student);
        }

        StudentNode<Student> parentNode = findParent(currentNode);

        if(student.hasHigherGPA(parentNode.student) &&
                student.hasHigherGPA(studentRoot.student)) {
            return student; // Case 1:  There is no student that has more GPA than the right-most student

        } else if(student.hasHigherGPA(parentNode.student) &&
                studentRoot.student.hasHigherGPA(student)) {
            return studentRoot.student; // Case 2:
        }

        return parentNode.student;
    }

    /*
    Remove a student node from the tree collection
    There are 3 cases:

    - Case 1: No child - detach that leaf from its parent

    - Case 2: 1 child
        10
       /  \
      9    11
     /
    8

    Say you want to remove 9, update its child node reference to its parent node

    - Case 3: 2 children
        11
       /  \
      9    13
     / \
    8   10

    find the largest node in the left subtree = 10
    find the smallest node in the right subtree = 13
     */
    public void removeStudent(Student student) {
        StudentNode<Student> studentNode = getNodePreRecursive(student);
        StudentNode<Student> parentNode = findParent(studentNode);

        StudentNode<Student> nodeToSet = studentNode.hasNext(right) ? studentNode.rightNode :
                studentNode.hasNext(!right) ? studentNode.leftNode : null;
        // Case 3
        if (studentNode.hasNext(right) && studentNode.hasNext(!right)) {
            StudentNode<Student> leftMostSubRightTree = findLeftMostFrom(studentNode.rightNode);
            StudentNode<Student> rightMostSubLeftTree = findRightMostFrom(studentNode.leftNode);

            StudentNode<Student> nodeToSetCase1;
            if (getHeight(leftMostSubRightTree) > getHeight(rightMostSubLeftTree)) {
                nodeToSetCase1 = leftMostSubRightTree;
            } else if (getHeight(rightMostSubLeftTree) > getHeight(leftMostSubRightTree)) {
                nodeToSetCase1 = rightMostSubLeftTree;
            } else {
                nodeToSetCase1 = leftMostSubRightTree.hasNext(right) ? leftMostSubRightTree : rightMostSubLeftTree;
            }

            StudentNode<Student> parentNodeToSet = findParent(studentNode, nodeToSetCase1);
            if (parentNodeToSet != null) {
                if (nodeToSetCase1 == leftMostSubRightTree) {
                    updateReference(parentNodeToSet, nodeToSetCase1, nodeToSetCase1.rightNode);
                } else {
                    updateReference(parentNodeToSet, nodeToSetCase1, nodeToSetCase1.leftNode);
                }
            }
            studentNode = nodeToSetCase1;
        }
        // Case 2
        else if (nodeToSet != null) {
            updateReference(parentNode, studentNode, nodeToSet);
        // Case 1
        } else {
            updateReference(parentNode, studentNode, null);
        }
    }

    private void updateReference(StudentNode<Student> parent, StudentNode<Student> child, StudentNode<Student> newChild) {
        if(child.student.hasHigherGPA(parent.student)) {
            parent.rightNode = newChild;
        } else {
            parent.leftNode = newChild;
        }
    }

    public int getHeight(StudentNode<Student> root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getHeight(root.leftNode);
            int rightHeight = getHeight(root.rightNode);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private StudentNode<Student> findLeftMostFrom(StudentNode<Student> root) {
        if(!root.hasNext(!right)) {
            return root;
        }

        return findLeftMostFrom(root.leftNode);
    }

    private StudentNode<Student> findRightMostFrom(StudentNode<Student> root) {
        if(!root.hasNext(right)) {
            return root;
        }

        return findRightMostFrom(root.rightNode);
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
