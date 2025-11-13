package javaapplication16;
import java.util.*;

// Main application class
public class JavaApplication16 {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            // Handle invalid input safely
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("In\n" +
"valid choice. Try again.");
                    break;
            }
        } while (choice != 3);
    }
    // Method to add a student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        List<Double> grades = new ArrayList<>();
        System.out.print("Enter number of grades: ");
        int numGrades = scanner.nextInt();

        for (int i = 0; i < numGrades; i++) {
            System.out.printf("Enter grade %d: ", i + 1);
            grades.add(scanner.nextDouble());
        }
        scanner.nextLine(); // consume newline

        students.add(new Student(name, id, grades));
        System.out.println("Student added successfully.");
    }

    // Method to display all students
    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student Results ---");
            for (Student student : students) {
                student.displayInfo();
            }
        }
    }
}

// Student class
class Student {
    private String name;
    private String id;
    private List<Double> grades;

    public Student(String name, String id, List<Double> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public List<Double> getGrades() { return grades; }

    // Calculate average
    public double getAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? sum / grades.size() : 0;
    }

    // Classify grade
    public String getGradeClassification() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    // Display student info
    public void displayInfo() {
        System.out.printf("Name: %s | ID: %s | Avg: %.2f | Grade: %s%n",
                          name, id, getAverage(), getGradeClassification());
    }
}
