package StudentGradeTracker1;

import java.util.Scanner;

public class StudentTracker2 {

    // Method to calculate and print the average
    void average(int totalMarks, int numSubjects) {
        if (numSubjects == 0) {
            System.out.println("No subjects entered. Cannot calculate average.");
            return;
        }
        int avg = totalMarks / numSubjects;
        System.out.println("Average marks: " + avg);
    }

    // Method to calculate the highest score
    int highest_score(int currentHighest, int newScore) {
        return Math.max(currentHighest, newScore);
    }

    // Corrected method to calculate the lowest score
    int lowest_score(int currentLowest, int newScore) {
        return Math.min(currentLowest, newScore);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Variables to store total marks, highest score, and lowest score
        int totalMarks = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;

        // Create an object of StudentGradeTracker
        StudentTracker2 tracker = new StudentTracker2();

        // Input the number of subjects
        System.out.println("Enter the number of subjects: ");
        int numSubjects = in.nextInt();

        // Array to store marks of each subject
        int[] marks = new int[numSubjects];

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter the marks of Subject " + (i + 1) + ": ");
            marks[i] = in.nextInt();
            totalMarks += marks[i];

            // Update highest and lowest scores
            highest = tracker.highest_score(highest, marks[i]);
            lowest = tracker.lowest_score(lowest, marks[i]);
        }

        // Calculate and display the average, highest, and lowest scores
        System.out.println("*********************************SUMMARRY REPORT*********************************");
        tracker.average(totalMarks, numSubjects);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        // Close the Scanner
        in.close();
    }
}