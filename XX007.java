package patcode;

import java.util.Scanner;
//Enter strings that requires an input.Open a scanner to get user inputs.
public class XX007 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();
        //Array created below to enable stored student object.
        Student[] students = new Student[numStudents];
        // Create a loop that enables the number of students and information to be entered.
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i+1) + ":"); 
            System.out.print("First name: ");
            String firstName = input.next();
            System.out.print("Surname: ");
            String surname = input.next();
           
            double[] hwMarks = new double[5];
            System.out.println("Enter homework marks (5 values):");
            for (int j = 0; j < 5; j++) {
                hwMarks[j] = input.nextDouble();
            }
            ///Enter the test marks
            System.out.print("Interim Test mark: ");
            double interimMark = input.nextDouble();
            System.out.print("Exam mark: ");
            double examMark = input.nextDouble();
            
            students[i] = new Student(i+1, firstName, surname, hwMarks, interimMark, examMark);
        }
        
        System.out.println("ID\tName\tSurname\tCoursework\tExam\tFinalMark");
        for (Student student : students) {
            double courseworkMark = student.calculateCourseworkMark();
            double finalMark = student.calculateFinalMark();
            System.out.printf("%d\t%s\t%s\t%.2f%%\t\t%.0f%%\t%.2f%%\n", student.getId(), student.getFirstName(), student.getSurname(), courseworkMark, student.getExamMark(), finalMark);
        }
    }
}