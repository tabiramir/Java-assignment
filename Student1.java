import java.util.Scanner;

class Student {
    String name;
    String id;
    int[] grades;
    Student(String name, String id, int numGrades) {
        this.name = name;
        this.id = id;
        this.grades = new int[numGrades];
    }
    void inputGrades(Scanner scanner) {
        System.out.println("Enter grades for " + name + ":");
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }
    }
    double calculateAverage() {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.length;
    }
    int findHighestGrade() {
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }
    public int findLowestGrade() {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
    public void displayGradeReport() {
        System.out.println("Grade Report for " + name + " (ID: " + id + "):");
        System.out.print("Grades: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println("\nAverage: " + calculateAverage());
        System.out.println("Highest Grade: " + findHighestGrade());
        System.out.println("Lowest Grade: " + findLowestGrade());
    }
}
public class Student1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            scanner.nextLine();
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter ID for student " + (i + 1) + ": ");
            String ID = scanner.nextLine();
            System.out.print("Enter number of grades for student " + (i + 1) + ": ");
            int numGrades = scanner.nextInt();
            students[i] = new Student(name, ID, numGrades);
            students[i].inputGrades(scanner);
        }
        System.out.println("\nGrade Reports:");
        for (Student student : students) {
            student.displayGradeReport();
            System.out.println("----------------------------");
        }
        scanner.close();
    }
}
