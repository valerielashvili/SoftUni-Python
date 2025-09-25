import java.util.Scanner;

public class p04_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsNum = Integer.parseInt(scanner.nextLine());

        double topStudents = 0;
        double countTopStudents = 0;    // Counter за количество на студентите с оценка >= на 5
                                        // Долните counter'и са аналогични
        double goodStudents = 0;
        double countGoodStudents = 0;

        double badStudents = 0;
        double countBadStudents = 0;

        double failStudents = 0;
        double countFailStudents = 0;

        double gradeSum = 0;

        for (int i = 0; i < studentsNum; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            gradeSum += grade;

            if (grade >= 5.00) {
                countTopStudents++;
                topStudents = countTopStudents * 100 / studentsNum;
            }
            if (grade >= 4 && grade <= 4.99) {
                countGoodStudents++;
                goodStudents = countGoodStudents * 100 / studentsNum;
            }
            if (grade >= 3 && grade <= 3.99) {
                countBadStudents++;
                badStudents = countBadStudents * 100 / studentsNum;
            }
            if (grade < 3) {
                countFailStudents++;
                failStudents = countFailStudents * 100 / studentsNum;
            }
        }
        double average = gradeSum / studentsNum;
        System.out.printf("Top students: %.2f%%\n", topStudents);
        System.out.printf("Between 4.00 and 4.99: %.2f%%\n", goodStudents);
        System.out.printf("Between 3.00 and 3.99: %.2f%%\n", badStudents);
        System.out.printf("Fail: %.2f%%\n", failStudents);
        System.out.printf("Average: %.2f", average);
    }
}
