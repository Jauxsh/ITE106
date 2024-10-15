import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int StudentNum = sc.nextInt();
        sc.nextLine();

        String[] StudentNames = new String[StudentNum];
        double[] AverageGrade = new double[StudentNum];
        char[] grades = new char[StudentNum];

        for (int i = 0; i < StudentNum; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            StudentNames[i] = sc.nextLine();

            System.out.print("Enter the number of assignments for " + StudentNames[i] + ": ");
            int AssignmentNum = sc.nextInt();
            double totalScore = 0;

            for (int j = 0; j < AssignmentNum; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                double score = sc.nextDouble();
                totalScore += score;
            }

            AverageGrade[i] = totalScore / AssignmentNum;

            if (AverageGrade[i] >= 90) {
                grades[i] = 'A';
            } else if (AverageGrade[i] >= 80) {
                grades[i] = 'B';
            } else if (AverageGrade[i] >= 70) {
                grades[i] = 'C';
            } else if (AverageGrade[i] >= 60) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }

            sc.nextLine();
        }

        for (int i = 0; i < StudentNum; i++) {
            System.out.println(StudentNames[i] + " - Average: " + AverageGrade[i] + " - Grade: " + grades[i]);
        }

        sc.close();
    }
}
