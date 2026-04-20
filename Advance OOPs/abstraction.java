// Top-level abstraction
abstract class Animal {

    String type;

    // Constructor in abstract class
    // Used to initialize COMMON data for all subclasses
    Animal(String type) {
        this.type = type;
        System.out.println("Animal constructor called");
    }

    // Abstract method → MUST be implemented by child
    abstract void sound();

    // Concrete method → shared behavior
    void eat() {
        System.out.println("All animals eat food");
    }
}


// Intermediate abstract class
abstract class Mammal extends Animal {

    Mammal(String type) {
        super(type); // calls Animal constructor
        System.out.println("Mammal constructor called");
    }

    // Partial implementation
    @Override
    void sound() {
        System.out.println("Mammal makes sound");
    }

    // Still abstract → must be implemented later
    abstract void walk(); 
    
    // not necessary to define all parent methods, since it is an abstract class.
}


// Concrete class (fully implemented → can be instantiated)
class Dog extends Mammal {

    Dog() {
        super("Mammal"); // must call parent constructor
        System.out.println("Dog constructor called");
    }

    @Override
    void walk() {
        System.out.println("Dog walks on 4 legs");
    }
}


// Another concrete class
class Human extends Mammal {

    Human() {
        super("Mammal");
        System.out.println("Human constructor called");
    }

    @Override
    void walk() {
        System.out.println("Human walks on 2 legs");
    }

    // Overriding concrete method
    @Override
    void eat() {
        System.out.println("Human eats cooked food");
    }
}


public class Abstraction{

    // Generic method → demonstrates polymorphism
    static void processAnimal(Animal a) {
        a.sound(); // runtime decision
        a.eat();   // may be overridden
    }

    public static void main(String[] args) {

        System.out.println("---- Creating Dog ----");
        Animal d = new Dog();

        System.out.println("\n---- Creating Human ----");
        Animal h = new Human();

        System.out.println("\n---- Polymorphism ----");
        processAnimal(d);
        processAnimal(h);

        System.out.println("\n---- Key Concepts ----");

        // X NOT ALLOWED (abstract class cannot be instantiated)
        // Animal a = new Animal();

        // ✔ Allowed because object is concrete (Dog/Human)
        Animal ref = new Dog();

        // Constructor chain happens:
        // Animal → Mammal → Dog

        // Even though Animal cannot be instantiated,
        // its constructor STILL runs as part of Dog object
    }
}