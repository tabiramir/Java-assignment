import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String[] transactionHistory;
    private int transactionCount;
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new String[100];
        this.transactionCount = 0;
        addTransaction("Account created with initial balance: Rs" + initialBalance);
    }
    private void addTransaction(String transaction) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount++] = transaction;
        }
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Must be greater than 0.");
        } else {
            balance += amount;
            System.out.println("Deposited: Rs" + amount);
            addTransaction("Deposited: Rs" + amount);
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal denied.");
            addTransaction("Withdrawal of Rs" + amount + " failed due to insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: Rs" + amount);
            addTransaction("Withdrew: Rs" + amount);
        }
    }
    public void checkBalance() {
        System.out.println("Current balance: Rs" + balance);
    }
    public void displayTransactionHistory() {
        System.out.println("Transaction History for Account " + accountNumber + " (" + accountHolder + "):");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactionHistory[i]);
        }
    }
}
public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(accountNumber, name, initialBalance);
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1) Deposit\n2) Withdraw\n3) Check Balance\n4) View Transaction History\n5) Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayTransactionHistory();
                    break;

                case 5:
                    System.out.println("Exiting. Thank you for using the Bank Account Management System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
