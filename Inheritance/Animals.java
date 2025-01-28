class Animal{
    public void makeSound(){
      System.out.println("The animal makes a sound.");
    }
  }
  class Cat extends Animal{
    
    @Override
    public void makeSound(){
      System.out.println("The cat quarrels.");
    }
  
  }
  
  public class Animals{
    public static void main(String [] args){
      Animal a = new Animal();
      a.makeSound();
      
      Cat c = new Cat();
      c.makeSound();
    }
  }
  