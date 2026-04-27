// Base interface (contract)
interface Animal {
    void eat();

    // Default method (introduced in Java 8)
    default void sleep() {
        System.out.println("Animal is sleeping");
    }

    // Static method (belongs to interface, not object)
    static void info() {
        System.out.println("This is Animal interface");
    }
}


// Interface inheritance
interface Mammal extends Animal {
    void walk();
}


// Another independent interface
interface Pet {
    void play();

    // Default method (will cause conflict later)
    default void sleep() {
        System.out.println("Pet is sleeping");
    }
}


// Concrete class implementing multiple interfaces
class Dog implements Mammal, Pet {

    private String name;

    Dog(String name) {
        this.name = name;
    }

    // MUST implement abstract methods
    public void eat() {
        System.out.println(name + " eats food");
    }

    public void walk() {
        System.out.println(name + " walks on 4 legs");
    }

    public void play() {
        System.out.println(name + " plays fetch");
    }

    // Conflict resolution (VERY IMPORTANT)
    // Both Animal and Pet have default sleep()
    @Override
    public void sleep() {
        // explicitly choosing which one to use
        Mammal.super.sleep(); // calls Animal's version
        System.out.println(name + " is sleeping peacefully");
    }
}


// Another class implementing only one interface
class Cat implements Mammal {

    private String name;

    Cat(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " eats fish");
    }

    public void walk() {
        System.out.println(name + " walks gracefully");
    }
}


public class Interfaces {

    // Polymorphism using interface
    static void processAnimal(Animal a) {
        a.eat();
        a.sleep(); // default or overridden
    }

    public static void main(String[] args) {

        System.out.println("---- Static Method ----");
        Animal.info(); // called using interface

        System.out.println("\n---- Dog Object ----");
        Animal d = new Dog("Tommy"); // polymorphism
        processAnimal(d);

        System.out.println("\n---- Cat Object ----");
        Animal c = new Cat("Kitty");
        processAnimal(c);

        System.out.println("\n---- Interface Capability ----");

        // Using interface reference
        Pet p = new Dog("Bruno");
        p.play();   // allowed
        p.sleep();  // resolved method

        // p.eat(); X not allowed (reference type = Pet)
    }
}