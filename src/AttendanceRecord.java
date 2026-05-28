public class AttendanceRecord {
    private String studentId;
    private String date;
    private String status; // "Present" or "Absent"

    public AttendanceRecord(String studentId, String date, String status) {
        this.studentId = studentId;
        this.date = date;
        setStatus(status);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            System.out.println("Invalid status. Use Present or Absent. Defaulting to Absent.");
            this.status = "Absent";
        }
    }
    public void display() {
        System.out.println(date + " | " + studentId + " | " + status);
    }

    public void display(String studentName) {
        System.out.println(date + " | " + studentName + " (" + studentId + ") | " + status);
    }

}

