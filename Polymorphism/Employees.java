package Polymorphism;

abstract class Employee {
    abstract void work();
}

class Developer extends Employee {
    @Override
    void work() {
        System.out.println("Developer is writing code.");
    }
}

class Tester extends Employee {
    @Override
    void work() {
        System.out.println("Tester is testing the application.");
    }
}

public class Employees {
    public static void main(String[] args) {
        Employee emp1 = new Developer();
        emp1.work();

        Employee emp2 = new Tester();
        emp2.work();
    }
}
