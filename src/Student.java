public class Student extends Person {
    private String studentId;
    private int absences;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
        this.absences = 0;
    }

}
