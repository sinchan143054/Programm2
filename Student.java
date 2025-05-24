import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private LocalDate dateOfBirth;

    public Student(String name, String dobStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dobStr, formatter);
    }

    public void displayStudentDetails() {
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age + " years");
    }

    public static void main(String[] args) {
        Student student = new Student("Alice Johnson", "2004-03-15", "yyyy-MM-dd");
        student.displayStudentDetails();
    }
}
