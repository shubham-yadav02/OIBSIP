
import java.util.Scanner;

public class ATMInterface {
    private static double balance = 1000.00;  // Starting balance for the account

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Welcome to the ATM Interface!");

        while (!quit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }

    // Method to check balance
    public static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    // Method to deposit money
    public static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.printf("You have successfully deposited $%.2f. New balance: $%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid amount. Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("You have successfully withdrawn $%.2f. Remaining balance: $%.2f%n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Your current balance is: $" + balance);
        } else {
            System.out.println("Invalid amount. Withdrawal amount must be positive.");
        }
    }
}

