import java.util.ArrayList;
import java.util.Scanner;

public Class ATMInterface {
    private static ArrayList<String> transactionHistory = new ArrayList<>();
    private static int balance = 1000; // Initial balance

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("Welcome to the ATM Interface!");

        // Loop until the user quits
        while (true) {
            // Print options
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View transaction history");
            System.out.println("2. Withdraw amount");
            System.out.println("3. Deposit amount");
            System.out.println("4. Transfer money");
            System.out.println("5. Exit");

            // Get user choice
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            // Handle user choice
            switch (choice) {
                case 1:
                    viewTransactionHistory();
                    break;
                case 2:
                    withdrawamount();
                    break;
                case 3:
                    depositamount();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM Interface!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("Transaction history is empty.");
        } else {
            System.out.println("Transaction history:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    private static void withdrawamount() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        int amount = input.nextInt();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal of " + amount + " dollars");
            System.out.println("Withdrawal successful. Your new balance is " + balance + " dollars.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private static void depositamount() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        int amount = input.nextInt();

        balance += amount;
        transactionHistory.add("Deposit of " + amount + " dollars");
        System.out.println("Deposit successful. Your new balance is " + balance + " dollars.");
    }

    private static void transferMoney() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: ");
        int amount = input.nextInt();
        System.out.print("Enter the recipient's account number: ");
        int recipientAccountNumber = input.nextInt();

        // Check if the recipient's account number is valid
        if (recipientAccountNumber < 1000 || recipientAccountNumber > 5000) {
            System.out.println("Invalid recipient account number.");
            return;
        }

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transfer of " + amount + " dollars to account " + recipientAccountNumber);
            System.out.println("Transfer successful. Your new balance is " + balance + " dollars.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}