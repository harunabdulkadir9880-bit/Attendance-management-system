import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<AttendanceRecord> records = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("=== Attendance Management System ===\n");

        System.out.println("Enter teacher details:");
        System.out.print("Name: ");    String tName    = scanner.nextLine();
        System.out.print("Age: ");     int tAge        = Integer.parseInt(scanner.nextLine());
        System.out.print("Subject: "); String tSubject = scanner.nextLine();
        Teacher teacher = new Teacher(tName, tAge, tSubject);

        System.out.print("\nHow many students to enroll? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            System.out.println("\nStudent " + i + ":");
            System.out.print("Name: ");       String sName = scanner.nextLine();
            System.out.print("Age: ");        int sAge     = Integer.parseInt(scanner.nextLine());
            System.out.print("Student ID: "); String sId   = scanner.nextLine();
            students.add(new Student(sName, sAge, sId));
        }
        System.out.print("\nEnter date for attendance (e.g. 2025-01-20): ");
        String date = scanner.nextLine();

        for (Student s : students) {
            System.out.print("Mark " + s.getName() + " as Present or Absent: ");
            String status = scanner.nextLine();
            AttendanceRecord record = new AttendanceRecord(s.getStudentId(), date, status);
            records.add(record);
            if (record.getStatus().equalsIgnoreCase("Absent")) {
                s.addAbsence();
            }
        }

    }
}