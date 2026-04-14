class Student{

    static String college;
    String name;
    int rollno;
    String course;
    int age;
    String gender;

    // Demonstrating constructor chaining
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    Student(String name){
        this(name, 20);
    }

    Student(int age){
        this("Unknown", age);
    }

    Student(){
        this("Unknown", 20);
    }
}

public class checkStat{
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Tushar");

        s1.college = "IIT";
        System.out.println(s1.college);

        s2.college = "NIT";
        System.out.println(s1.college); // NIT expected as College is static and Shared between the objects.
    }
}