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

}

