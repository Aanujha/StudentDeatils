import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private double grade;

    // Constructor
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    // toString method for displaying student details
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}

class StudentManager {
    private List<Student> students;

    // Constructor
    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Method to add a new student to the list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to display details of all students in the list
    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Method to calculate and return the average grade of all students
    public double getAverageGrade() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double totalGrade = 0;
        for (Student student : students) {
            totalGrade += student.getGrade();
        }

        return totalGrade / students.size();
    }

    // Method to find and return a student based on their ID
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; //Return null if no student with the given ID is found
    }
}

public class Main {
    public static void main(String[] args) {

        // Demonstrate the functionality of the StudentManager class

        // Create an instance of StudentManager
        StudentManager studentManager = new StudentManager();

        // Add a few students
        studentManager.addStudent(new Student(1, "Shweta", 75.5));
        studentManager.addStudent(new Student(2, "Ashish", 88.0));
        studentManager.addStudent(new Student(3, "Ritika", 95.5));

        // Display the students
        System.out.println("List of Students:");
        studentManager.displayStudents();

        // Calculate and display the average grade
        System.out.println("\nAverage Grade: " + studentManager.getAverageGrade());

        // Find and display a student by ID
        int studentIdToFind = 2;
        Student foundStudent = studentManager.findStudentById(studentIdToFind);

        if (foundStudent != null) {
            System.out.println("\nStudent Found by ID " + studentIdToFind + ": " + foundStudent);
        } else {
            System.out.println("\nStudent with ID " + studentIdToFind + " not found.");
        }

    }
}


