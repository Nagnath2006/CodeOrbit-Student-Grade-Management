import java.util.Scanner;

public class StudentGradeManagement {

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of students: ");
    int n = sc.nextInt();
    sc.nextLine();

    if (n <= 0) {
        System.out.println("Number of students must be greater than zero.");
        sc.close();
        return;
    }

    String[] names = new String[n];
    double[] marks = new double[n];

    double total = 0;
    double highest = -1;
    double lowest = 101;

    int highestIndex = 0;
    int lowestIndex = 0;

    for (int i = 0; i < n; i++) {

        System.out.println("\nEnter details for Student " + (i + 1));

        System.out.print("Enter student name: ");
        names[i] = sc.nextLine();

        System.out.print("Enter marks (0-100): ");
        marks[i] = sc.nextDouble();
        sc.nextLine();

        if (marks[i] < 0 || marks[i] > 100) {
            System.out.println("Invalid marks! Please enter marks between 0 and 100.");
            sc.close();
            return;
        }

        total += marks[i];

        if (marks[i] > highest) {
            highest = marks[i];
            highestIndex = i;
        }

        if (marks[i] < lowest) {
            lowest = marks[i];
            lowestIndex = i;
        }
    }

    double average = total / n;

    System.out.println("\n========== STUDENT REPORT ==========");

    System.out.printf("%-20s %s%n", "Student Name", "Marks");
    System.out.println("------------------------------------");

    for (int i = 0; i < n; i++) {
        System.out.printf("%-20s %.2f%n", names[i], marks[i]);
    }

    System.out.println("------------------------------------");
    System.out.printf("Average Marks: %.2f%n", average);
    System.out.printf("Highest Marks: %.2f (%s)%n", highest, names[highestIndex]);
    System.out.printf("Lowest Marks: %.2f (%s)%n", lowest, names[lowestIndex]);

    System.out.println("====================================");

    sc.close();
}

}