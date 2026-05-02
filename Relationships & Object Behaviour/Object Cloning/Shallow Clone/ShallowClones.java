class Passport{
    String passNum;

    Passport(String passNum){
        this.passNum = passNum;
    }    
}

class Student implements Cloneable{  // implement clonable interface
    String name;
    Passport passport;

    Student(String name, Passport passport){
        this.name = name;
        this.passport = passport;
    }

    // MUST define this method to clone the object, with throwing CloneNotSupportedException 
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

class ShallowClones{
    public static void main(String[] args) throws CloneNotSupportedException{
        Student s1 = new Student("Tushar", new Passport("A123"));

        Student s2 = (Student)s1.clone();

        System.out.println("S1 : " + s1.name + " " + s1.passport.passNum);
        System.out.println("S2 : " + s2.name + " " + s2.passport.passNum);

        // change the name of s2
        s2.name = "Shubham";
        s2.passport.passNum = "B456";

        System.out.println("After changing s2 : ");
        System.out.println("S1 : " + s1.name + " " + s1.passport.passNum);
        System.out.println("S2 : " + s2.name + " " + s2.passport.passNum); 
        
        /*
            passNum is an object and is a reference type, so it's not deep cloned (only shallow copy happens)
            hence changes in both the clones.

            Name is immutable (string is immutable), so it's deep cloned.

            Shallow Cloning -> When any change in any of the clones is reflected in the other clone.
            Deep Cloning -> When any change in any of the clones is not reflected in the other clone.
        */
    }
}