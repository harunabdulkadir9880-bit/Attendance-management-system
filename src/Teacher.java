// Inheritance: Teacher is-a Person
public class Teacher extends Person {

    private String subject;
    private String employeeId;

    public Teacher(String name, int age, String employeeId, String subject) {
        super(name, age);
        this.employeeId = employeeId;
        this.subject    = subject;
    }

    public String getSubject()    { return subject; }
    public String getEmployeeId() { return employeeId; }

    public void setSubject(String subject) { this.subject = subject; }

    // Overriding -- runtime polymorphism
    @Override
    public String getRole() { return "Teacher"; }

    @Override
    public void displayInfo() {
        System.out.println("Teacher: " + getName() + " | ID: " + employeeId + " | Subject: " + subject);
    }
}
