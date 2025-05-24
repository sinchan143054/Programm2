import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentCourseInfo {
    public static void main(String[] args) {
        Student student = new Student("Alice Johnson", "2004-03-15", "yyyy-MM-dd");
        student.displayStudentDetails();

        StudentCourses sc = new StudentCourses();
        sc.addCourseMarks("Semester 1", "Mathematics", 85);
        sc.addCourseMarks("Semester 1", "Physics", 78);
        sc.addCourseMarks("Semester 2", "Chemistry", 88);
        sc.addCourseMarks("Semester 2", "Biology", 90);
        sc.displayCoursesAndMarks();
    }
}

class Student {
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
}

class StudentCourses {
    private Map<String, Map<String, Integer>> semesterCourses = new LinkedHashMap<>();

    public void addCourseMarks(String semester, String course, int marks) {
        semesterCourses.putIfAbsent(semester, new LinkedHashMap<>());
        semesterCourses.get(semester).put(course, marks);
    }

    public void displayCoursesAndMarks() {
        for (String semester : semesterCourses.keySet()) {
            System.out.println("Semester: " + semester);
            Map<String, Integer> courses = semesterCourses.get(semester);
            for (Map.Entry<String, Integer> entry : courses.entrySet()) {
                System.out.println("Course: " + entry.getKey() + ", Marks: " + entry.getValue());
            }
            System.out.println();
        }
    }
}
