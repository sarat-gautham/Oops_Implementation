package Polymorphism;

interface Payment {
    void makePayment(double amount);
}

class CreditCard implements Payment {

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment made using Credit Card: $" + amount);
    }
}

class PayPal implements Payment {

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment made using PayPal: $" + amount);
    }
}

public class Payments{
    public static void main(String[] args) {
        Payment payment1 = new CreditCard();
        payment1.makePayment(200.50);

        Payment payment2 = new PayPal();
        payment2.makePayment(150.75);
    }
}

