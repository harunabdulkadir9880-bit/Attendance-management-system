public class Student extends Person {
    private String studentId;
    private int absences;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
        this.absences = 0;
    }
    public String getStudentId() { return studentId; }
    public int getAbsences()     { return absences; }

    public void setStudentId(String studentId) { this.studentId = studentId; }

}
