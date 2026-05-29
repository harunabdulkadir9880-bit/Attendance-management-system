public class Teacher extends Person {
    private String subject;
    private String employeeid;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public String getSubject()            { return subject; }
    public String getEmployeeid()           { return employeeid; }

    public void setSubject(String subject){ this.subject = subject; }

    @Override
    public String getRole() { return "Teacher"; }

    @Override
    public void displayInfo() {
        System.out.println(getName() + " | Subject: " + subject);
    }
}


