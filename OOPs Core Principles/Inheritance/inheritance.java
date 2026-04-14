// Parent class
class College {

    protected String name;
    protected String address;

    // Constructor 1
    College(String name) {
        this.name = name;
        this.address = "Bangalore";
        System.out.println("College constructor called");
    }

    // Method (can be overridden)
    void printDetails() {
        System.out.println("College: " + name);
        System.out.println("Address: " + address);
    }

    // 🔹 Method Overloading (same method name, different parameters)
    void printDetails(boolean showAddressOnly) {
        if (showAddressOnly) {
            System.out.println("Address: " + address);
        } else {
            printDetails();
        }
    }
}


// Intermediate class
class Section extends College {

    protected String section;

    Section(String section, String collegeName) {
        super(collegeName);
        this.section = section;
        System.out.println("Section constructor called");
    }

    void printSectionDetails() {
        System.out.println("Section: " + section);
    }

    // Method overriding
    @Override
    void printDetails() {
        super.printDetails();
        System.out.println("Section: " + section);
    }

    // 🔹 Overloading in same class
    void printSectionDetails(String prefix) {
        System.out.println(prefix + " Section: " + section);
    }
}


// Child class
class Student extends Section {

    private String studentName;
    private int rollNo;

    Student(String studentName, String section, String collegeName) {
        super(section, collegeName);
        this.studentName = studentName;
        this.rollNo = 1;
        System.out.println("Student constructor called");
    }

    void printStudentDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll No: " + rollNo);
    }

    // Method overriding
    @Override
    void printDetails() {
        super.printDetails();
        System.out.println("Student Name: " + studentName);
    }

    // 🔹 Method Overloading
    void printStudentDetails(boolean showRollOnly) {
        if (showRollOnly) {
            System.out.println("Roll No: " + rollNo);
        } else {
            printStudentDetails();
        }
    }
}


public class inheritance {
    public static void main(String[] args) {

        System.out.println("---- Creating Student ----");
        Student s1 = new Student("Tushar", "A", "SST");

        System.out.println("\n---- Overriding Demo ----");
        s1.printDetails(); // calls Student → Section → College

        System.out.println("\n---- Overloading Demo ----");

        // Overloading in Student
        s1.printStudentDetails(true);
        s1.printStudentDetails(false);

        // Overloading in Section
        s1.printSectionDetails();
        s1.printSectionDetails("Custom ->");

        // Overloading in College
        s1.printDetails(true);

        System.out.println("\n---- Dynamic Method Dispatch ----");
        College ref = new Student("Rahul", "B", "IIT");
        ref.printDetails(); // runtime decision → Student method
    }
}