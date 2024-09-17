import java.util.Scanner;
public class ATM_Interface
{
	public static void main(String[] args) 
	{
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Enter Initial Account Balance: $");
	    double initialBalance = scan.nextDouble();
	    BankAccount bankAccount = new BankAccount(initialBalance);
	    ATM atm = new ATM(bankAccount);
	    while(true)
	    {
	        atm.displayMenu();
	        System.out.print("Select An Option: ");
	        int choice = scan.nextInt();
	        atm.performTransaction(choice, scan);
	    }
	}
}

class BankAccount
{
    private double balance;
    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount)
    {
        if(amount >= 0)
        {
            balance +=amount;
            System.out.println("Deposit of $" + amount + " Successful.");
	    System.out.println("Current balance:$"+balance);
        }
        else
        {
            System.out.println("Invalid Deposit Amount.");   
        }
    }
    public void withdraw(double amount)
    {
        if(amount > 0 && amount <= balance )
        {
            balance -= amount;
            System.out.println("Withdraw of $" + amount +"Successful.");
	    System.out.println("Current balance: $" + balance); 
        }
        else
        {
            System.out.println("Invalid Withdraw Amount or insufficient balance.");
        }
    }
}
class ATM
{
    private BankAccount bankAccount;
    public ATM(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }
    public void displayMenu()
    {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void performTransaction(int choice, Scanner scan)
    {
        switch(choice)
        {
            case 1:
                System.out.println("Current Balance:$" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter Deposit Amount:$");
                double depositAmount = scan.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter Withdraw Amount:$");
                double withdrawAmount = scan.nextDouble();
                bankAccount.withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank You!");
                scan.close();
                System.exit(0);
            default:
                System.out.println("Invalid Choice.Please Select a Valid Option.");
        }
    }
}