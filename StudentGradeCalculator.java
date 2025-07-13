import java.util.Scanner;

public class StudentGradeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine();  

        String[] subjectNames = new String[numSubjects];
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) 
        {
            System.out.print("Enter name for subject " + (i + 1) + ": ");
            subjectNames[i] = scanner.nextLine();

            System.out.print("Enter marks for " + subjectNames[i] + " (out of 100): ");
            marks[i] = scanner.nextInt();
            scanner.nextLine(); 

            while (marks[i] < 0 || marks[i] > 100) 
            {
                System.out.print("Invalid marks! Please enter between 0 and 100: ");
                marks[i] = scanner.nextInt();
                scanner.nextLine();
            }

            totalMarks += marks[i];
        }
        double average = (double) totalMarks / numSubjects;
        String grade;
        if (average >= 90) 
        {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else 
        {
            grade = "F";
        }
        System.out.println("\n Detailed Report");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println(subjectNames[i] + ": " + marks[i]);
        }

        System.out.println("Total Marks = " + totalMarks + "/" + (numSubjects * 100));
        System.out.printf("Average Percentage = %.2f%%\n", average);
        System.out.println("Final Grade = " + grade);

        /*System.out.println("\nGrade Legend");
        System.out.println("A : 90 - 100");
        System.out.println("B : 80 - 89");
        System.out.println("C : 70 - 79");
        System.out.println("D : 60 - 69");
        System.out.println("F : Below 60");*/

        scanner.close();
    }
}