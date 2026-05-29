// Inheritance: Student is-a Person
public class Student extends Person {

    private String studentId;
    private int absences;
    private int totalDays;   // total days attendance was taken for this student

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
        this.absences  = 0;
        this.totalDays = 0;
    }

    public String getStudentId() { return studentId; }
    public int getAbsences()     { return absences; }
    public int getTotalDays()    { return totalDays; }

    public void setStudentId(String id) { this.studentId = id; }

    public void recordDay(String status) {
        totalDays++;
        if (status.equalsIgnoreCase("Absent")) absences++;
    }

    // Returns attendance percentage
    public double getAttendanceRate() {
        if (totalDays == 0) return 0;
        return ((totalDays - absences) * 100.0) / totalDays;
    }

    // A student is at risk if attendance drops below 75%
    public boolean isAtRisk() {
        return getAttendanceRate() < 75.0;
    }

    // Overriding -- runtime polymorphism
    @Override
    public String getRole() { return "Student"; }

    @Override
    public void displayInfo() {
        System.out.printf("%-20s | ID: %-8s | Absences: %d/%d | Attendance: %.1f%% %s%n",
                getName(), studentId, absences, totalDays, getAttendanceRate(),
                isAtRisk() ? "<-- AT RISK" : "");
    }
}
