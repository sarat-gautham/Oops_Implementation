class BankAccount{
  
    private double AccountNo;
    private double Balance;
    
    public BankAccount(double AccountNo, double Balance){
      this.AccountNo = AccountNo;
      this.Balance = Balance;
    }
    
    public void deposit(double Amount){
      Balance += Amount;
      System.out.println("The Deposit Amount is: " + Amount);
    }
    
    public void withdraw(double Amount){
      if(Balance >= Amount){
        Balance -= Amount;
        System.out.println("The Withdraw Amount is: " + Amount );
      }else{
        System.out.println("Insufficient Balance");
      }
    }
    
    public double getBalance(){
      return Balance;
    }
    
  }
  
  class SavingsAccount extends BankAccount{
    
    public SavingsAccount(double AccountNo, double Amount){
      super(AccountNo, Amount);
    }
    
    @Override
    public void withdraw(double Amount){
      if( (getBalance() - Amount) < 100 ){
        System.out.println("Minimum balance of $100 required!");
      }else{
        super.withdraw(Amount);
      }
    }
  }
  
public class BankAccounts{
    public static void main(String [] args){
      
      BankAccount bacc = new BankAccount(13374,1500);
      System.out.println("The Bank Account Details:");
      System.out.println("The Account Balance is: " + bacc.getBalance() );
      bacc.deposit(500);
      System.out.println("The Account Balance is: " + bacc.getBalance() );
      bacc.withdraw(750);
      System.out.println("The Account Balance is: " + bacc.getBalance() );
      
      System.out.println();
      
      SavingsAccount sacc1 = new SavingsAccount(13375,2500);
      System.out.println("The Savings Account Details:");
      System.out.println("The Account Balance is: " + sacc1.getBalance() );
      sacc1.deposit(500);
      System.out.println("The Account Balance is: " + sacc1.getBalance() );
      sacc1.withdraw(750);
      System.out.println("The Account Balance is: " + sacc1.getBalance() );
      
      System.out.println();
      
      SavingsAccount sacc2 = new SavingsAccount(13372,500);
      System.out.println("The Savings Account Details:");
      System.out.println("The Account Balance is: " + sacc2.getBalance() );
      sacc2.deposit(100);
      System.out.println("The Account Balance is: " + sacc2.getBalance() );
      sacc2.withdraw(550);
      System.out.println("The Account Balance is: " + sacc2.getBalance() );
      
      
    }
  }
