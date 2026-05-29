import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner                   = new Scanner(System.in);
    static ArrayList<Student> students       = new ArrayList<>();
    static ArrayList<AttendanceRecord> records = new ArrayList<>();
    static Teacher teacher                   = null;

    public static void main(String[] args) {
        System.out.println("=== Attendance Management System ===\n");
        setupTeacher();
        enrollStudents();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Take attendance for a date");
            System.out.println("2. View attendance by date");
            System.out.println("3. View all student summaries");
            System.out.println("4. View at-risk students");
            System.out.println("5. Look up a student by ID");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine().trim();

            if      (choice.equals("1")) takeAttendance();
            else if (choice.equals("2")) viewByDate();
            else if (choice.equals("3")) viewAllSummaries();
            else if (choice.equals("4")) viewAtRisk();
            else if (choice.equals("5")) lookUpStudent();
            else if (choice.equals("6")) running = false;
            else System.out.println("Invalid option.");
        }

        System.out.println("\nGoodbye!");
    }

    // ── Setup ────────────────────────────────────────────────────────────────

    static void setupTeacher() {
        System.out.println("Enter teacher details:");
        System.out.print("Name: ");        String name  = scanner.nextLine();
        System.out.print("Age: ");         int age      = readInt();
        System.out.print("Employee ID: "); String eid   = scanner.nextLine();
        System.out.print("Subject: ");     String subj  = scanner.nextLine();
        teacher = new Teacher(name, age, eid, subj);
        System.out.println();
        teacher.displayInfo("Class Teacher"); // overloaded displayInfo with label
    }

    static void enrollStudents() {
        System.out.print("\nHow many students? ");
        int count = readInt();
        for (int i = 1; i <= count; i++) {
            System.out.println("\nStudent " + i + ":");
            System.out.print("Name: ");       String name = scanner.nextLine();
            System.out.print("Age: ");        int age     = readInt();
            System.out.print("Student ID: "); String id   = scanner.nextLine();
            students.add(new Student(name, age, id));
            System.out.println("Enrolled.");
        }
    }

    // ── Menu options ─────────────────────────────────────────────────────────

    static void takeAttendance() {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();

        // Check we haven't already taken attendance for this date
        for (AttendanceRecord r : records) {
            if (r.getDate().equals(date)) {
                System.out.println("Attendance already taken for " + date + ".");
                return;
            }
        }

        for (Student s : students) {
            System.out.print(s.getName() + " -- Present or Absent? ");
            String status = scanner.nextLine().trim();
            records.add(new AttendanceRecord(s.getStudentId(), s.getName(), date, status));
            s.recordDay(status); // updates the student's running totals
        }
        System.out.println("Attendance saved for " + date + ".");
    }

    static void viewByDate() {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();
        System.out.println("\nAttendance on " + date + ":");
        boolean found = false;
        for (AttendanceRecord r : records) {
            if (r.getDate().equals(date)) {
                r.display("Record"); // overloaded display with label
                found = true;
            }
        }
        if (!found) System.out.println("No records found for " + date + ".");
    }

    static void viewAllSummaries() {
        System.out.println("\n-- Student Summaries --");
        // Superclass reference array -- runtime polymorphism
        Person[] people = new Person[students.size() + 1];
        people[0] = teacher;
        for (int i = 0; i < students.size(); i++) people[i + 1] = students.get(i);

        for (Person p : people) {
            p.displayInfo(); // Java calls the right version: Teacher's or Student's
        }
    }

    static void viewAtRisk() {
        System.out.println("\n-- At-Risk Students (attendance below 75%) --");
        boolean any = false;
        for (Student s : students) {
            if (s.isAtRisk()) {
                s.displayInfo();
                any = true;
            }
        }
        if (!any) System.out.println("No students are at risk.");
    }

    static void lookUpStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("\nStudent found:");
                s.displayInfo();
                System.out.println("Attendance history:");
                for (AttendanceRecord r : records) {
                    if (r.getStudentId().equalsIgnoreCase(id)) {
                        r.display(); // plain display -- overloaded version without label
                    }
                }
                return;
            }
        }
        System.out.println("No student found with ID: " + id);
    }

    // ── Helpers ──────────────────────────────────────────────────────────────

    static int readInt() {
        while (true) {
            try { return Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.print("Enter a whole number: "); }
        }
    }
}
