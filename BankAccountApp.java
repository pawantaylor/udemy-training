package lab;

public class BankAccountApp {

	public static void main(String[] args) {
		
		BankAccount acc1 = new BankAccount("123456789", 1000.50);
		BankAccount acc2 = new BankAccount("246813579", 2000);
		BankAccount acc3 = new BankAccount("987654321", 2500);

		acc1.makeDeposit(500);
		acc1.makeDeposit(600);
		acc1.payBill(1000);
		acc1.accrue();
	}

}


 class BankAccount implements IInterest {
	 
	 private static int iD = 1000;;
	 private String accountNumber;
	 private static final String routingNumber = "0540550";
	 private String name;
	 private String SSN;
	 private double balance;
	 
	 
	 // Constructor
	 
	 public BankAccount(String SSN, double initDeposit) {
		 balance = initDeposit;
		 this.SSN = SSN;
		 setAccountNumber();
		 iD++;
	 }
	 
	 private void setAccountNumber() {
		 
		 int randnum = (int)(Math.random()*100);	
		 accountNumber = iD + "" + randnum + SSN.substring(0,2);
		 System.out.println("Your account number is " + accountNumber);
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	public void payBill(double amount) {
		System.out.println("Paying bill of " + amount);
		balance = balance - amount;
		showBalance();
	}
	
	public void makeDeposit(double amount) {
		System.out.println("Making Deposit of " + amount);
		balance = balance + amount;
		showBalance();
	}
	
	public void showBalance() {
		System.out.println("Balance: " + balance);
	}

	@Override
	public void accrue() {
		balance = balance * (1 + rate/100);
		showBalance();
		
	}
	 
	 
	 
 }