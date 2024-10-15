import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int StudentNum = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < StudentNum; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String StudentName = scanner.nextLine();

            System.out.print("Enter the number of assignments for " + StudentName + ": ");
            int AssignmentNum = scanner.nextInt();
            double totalScore = 0;

            for (int j = 0; j < AssignmentNum; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                double score = scanner.nextDouble();
                totalScore += score;
            }

            double AverageGrade = totalScore / AssignmentNum;
            char grademark;

            if (AverageGrade >= 90) {
                grademark = 'A';
            } else if (AverageGrade >= 80) {
                grademark = 'B';
            } else if (AverageGrade >= 70) {
                grademark = 'C';
            } else if (AverageGrade >= 60) {
                grademark = 'D';
            } else {
                grademark = 'F';
            }

            scanner.nextLine();
            System.out.println("\n" + StudentName + " - Average: " + AverageGrade + " - Grade: " + grademark);
        }

        scanner.close();
    }
}
