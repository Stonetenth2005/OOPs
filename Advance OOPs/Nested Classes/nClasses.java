class Outer{

    int outerMember = 10;
    static int staticOuterMember = 20;

    // non-static inner class
    class Inner{
        void display(){
            System.out.println("Inner class");
            System.out.println("Outer member: " + outerMember);
            System.out.println("Static Outer member: " + staticOuterMember);
        }
    }

    // static inner class
    // static class can only access static outer class members directly.
    static class StaticInner{
        void display(){
            System.out.println("Static Inner class");
            System.out.println("Static Outer member: " + staticOuterMember);
        }
    }

    // local inner class
    void outerMethod(){
        class LocalInner{
            void display(){
                System.out.println("Local Inner class");
                System.out.println("Outer member: " + outerMember);
                System.out.println("Static Outer member: " + staticOuterMember);
            }
        }
        LocalInner localInner = new LocalInner();
        localInner.display();
    }
    
}

abstract class Greeting{
    abstract void greet();
}


public class nClasses{
    public static void main(String[] args){

        // Calling static inner class
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.display();

        // Calling non-static inner class
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();  // need to create both outer and inner class objects
        inner.display();

        // Calling local inner class
        outer.outerMethod();

        // Calling anonymous inner class inside another class main
        Greeting greeting = new Greeting(){
            public void greet(){
                System.out.println("Hello from Anonymous Inner class");
            }
        };
        greeting.greet();
        
    }
}