// One attendance record = one student on one date
public class AttendanceRecord {

    private String studentId;
    private String studentName;
    private String date;
    private String status;

    public AttendanceRecord(String studentId, String studentName, String date, String status) {
        this.studentId   = studentId;
        this.studentName = studentName;
        this.date        = date;
        setStatus(status);
    }

    public String getStudentId() { return studentId; }
    public String getDate()      { return date; }
    public String getStatus()    { return status; }

    // Encapsulation: only "Present" or "Absent" are valid
    public void setStatus(String status) {
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            System.out.println("Invalid status. Defaulting to Absent.");
            this.status = "Absent";
        }
    }

    // Overloading -- compile-time polymorphism
    public void display() {
        System.out.println(date + " | " + studentId + " | " + status);
    }

    public void display(String label) {
        System.out.println("[" + label + "] " + date + " | " + studentName + " | " + status);
    }
}
