package RMIT.Test1_2022A;

public class StudentCollection {
   public static class Student {
       String ID;
       String name;
       double GPA;
       Student(String ID, String name, double GPA) {
           this.ID = ID;
           this.name = name;
           this.GPA = GPA;
       }
   }
   Student[] stuArray = new Student[100];
   StudentCollection() {}

   public void addStudent(Student std) {
       stuArray[stuArray.length-1] = std;
   }
   public Student searchByName(String name) {
       Student std = null;
       return std;
   }
   public int rankStudent(String ID) {
       return 1;
   }
   public static void main(String[] args) {
       StudentCollection studentCollection = new StudentCollection();
       Student stu1 = new Student("1", "Tony", 3.4);
       studentCollection.addStudent(stu1);
   }
}
