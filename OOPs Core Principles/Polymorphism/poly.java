// Parent class (Base class)
class Animal {

    // Method 1
    void sound() {
        System.out.println("Animal makes a sound");
    }

    // Method 2 (not overridden in all children)
    void walk() {
        System.out.println("Animal walks");
    }
}


// Child class 1
class Dog extends Animal {

    // Method overriding
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    // Dog-specific method (NOT part of parent)
    void bark() {
        System.out.println("Dog specific behavior");
    }
}


// Child class 2
class Cat extends Animal {

    // Method overriding
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}


public class poly {

    // 🔹 Generic method using polymorphism
    // Works for ANY Animal (Dog, Cat, etc.)
    static void processAnimal(Animal a) {
        a.sound(); // polymorphic call (runtime decision)
        a.walk();  // inherited method (not overridden)
    }

    public static void main(String[] args) {

        // 🔹 Runtime Polymorphism (Dynamic Method Dispatch)
        Animal d = new Dog(); // reference = Animal, object = Dog
        Animal c = new Cat(); // reference = Animal, object = Cat

        System.out.println("---- Direct Calls ----");

        d.sound(); // Dog version (runtime)
        c.sound(); // Cat version (runtime)

        System.out.println("\n---- Loop (Polymorphism in action) ----");

        Animal[] animals = { d, c };

        for (Animal a : animals) {
            a.sound(); // same call → different outputs
        }

        System.out.println("\n---- Generic Function ----");

        processAnimal(d);
        processAnimal(c);

        System.out.println("\n---- Non-overridden Method ----");

        d.walk(); // Animal version (not overridden)

        System.out.println("\n---- Method Access Limitation ----");

        // d.bark(); ❌ Compile-time error
        // Because reference type = Animal

        // To access Dog-specific method:
        Dog realDog = (Dog) d; // type casting
        realDog.bark(); // ✔ now accessible
    }
}