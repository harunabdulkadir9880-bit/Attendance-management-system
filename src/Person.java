public abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() { return name; }
    public int getAge()     { return age; }

    public void setName(String name) { this.name = name; }

    public void setAge(int age) {
        if (age > 0) this.age = age;
        else System.out.println("Age must be positive.");
    }
    public void displayInfo() {
        System.out.println(name + " | Age: " + age);
    }

    public void displayInfo(String label) {
        System.out.println(label + ": " + name + " | Age: " + age);
    }

    public abstract String getRole();

}
