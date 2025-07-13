import java.util.Scanner;
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

    public boolean withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
        }
    }
}
class ATM 
{
    private BankAccount account;

    public ATM(BankAccount account) 
    {
        this.account = account;
    }
    public void start() 
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu ");
            System.out.println("-----------------------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
    public void checkBalance() 
    {
        System.out.println(String.format("Your current balance is:%.2f\n", account.getBalance()));
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        }
        else 
        {
            System.out.println("Invalid  amount");
        }
    }

    public void withdraw(double amount) 
    {
        if (account.withdraw(amount)) 
        {
            System.out.println("Withdrawal successful.");
        } 
        else 
        {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
public class ATMInterfaceApp 
{
    public static void main(String[] args)
     {
        BankAccount myAccount = new BankAccount(1000.0); 
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}