class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Person Name: " + name);
    }
}

class Student extends Person {
    int rollNumber;

    Student(String name, int rollNumber) {
        super(name);
        this.rollNumber = rollNumber;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Student Roll Number: " + rollNumber);
    }
}

public class Persons {
    public static void main(String[] args) {
        Student student = new Student("Alice", 101);
        student.display();
    }
}
