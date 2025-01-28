package Polymorphism;

class Animal {
    void speak() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Dog barks.");
    }
}

class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("Cat meows.");
    }
}

public class Animals {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.speak();

        Animal myCat = new Cat();
        myCat.speak();
    }
}
