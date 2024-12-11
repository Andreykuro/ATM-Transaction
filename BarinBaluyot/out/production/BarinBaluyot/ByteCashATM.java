import java.util.HashMap;
import java.util.Scanner;

public class ByteCashATM {
    private double balance; // Stores the current balance of the logged-in user.
    private static HashMap<String, Double> userAccounts; // Simulates user database.

    // Static block to initialize user accounts.
    static {
        userAccounts = new HashMap<>();
        userAccounts.put("Andrey", 5000000.00);
        userAccounts.put("Julian", 20000.00);
        userAccounts.put("Ainsley", 15000.50);
        userAccounts.put("Jewel", 100000.00);
        userAccounts.put("Luis", 5000000.00);
        userAccounts.put("JJ", 20000.00);
        userAccounts.put("Diddy", 15000.50);
        userAccounts.put("PeterParker", 100000.00);
        userAccounts.put("Eminem", 5000000.00);
        userAccounts.put("Ailene", 20000.00);
        userAccounts.put("Isagi", 15000.50);
        userAccounts.put("Reo", 1000000000000.00);
        userAccounts.put("BruceWayne", 500000000000.00);
        userAccounts.put("MrBeast", 20000000.00);
        userAccounts.put("Sae", 15000.50);
        userAccounts.put("Nagi", 1000000.00);
    }

    // Constructor to initialize the ATM with a user's balance.
    public ByteCashATM(String user) {
        this.balance = userAccounts.get(user);
    }

    // Method to check and display the current balance.
    public void checkBalance() {
        System.out.printf("\033[1;32mYour current balance is: $%.2f\033[0m%n", balance);
    }

    // Method to deposit a specified amount into the account.
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // Update balance
            System.out.printf("\033[1;34mYou have successfully deposited: $%.2f\033[0m%n", amount);
        } else {
            System.out.println("\033[1;31mDeposit amount must be positive.\033[0m");
        }
    }

    // Method to withdraw a specified amount from the account.
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Update balance
            System.out.printf("\033[1;34mYou have successfully withdrawn: $%.2f\033[0m%n", amount);
        } else if (amount > balance) {
            System.out.println("\033[1;31mInsufficient funds.\033[0m");
        } else {
            System.out.println("\033[1;31mWithdrawal amount must be positive.\033[0m");
        }
    }

    // Placeholder method for viewing transaction history.
    public void viewTransactionHistory() {
        System.out.println("\033[1;36mTransaction history feature coming soon!\033[0m");
    }

    // Method to display support contact information.
    public void contactSupport() {
        System.out.println("\033[1;35mFor support, contact us at support@bytecash.com or call 1-800-BYTECASH.\033[0m");
    }

    // Method to simulate an ATM interface with a border.
    public static void displayMenuWithBorder() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║              ByteCash ATM              ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Check Balance                       ║");
        System.out.println("║ 2. Deposit Money                       ║");
        System.out.println("║ 3. Withdraw Money                      ║");
        System.out.println("║ 4. View Transaction History            ║");
        System.out.println("║ 5. Contact Support                     ║");
        System.out.println("║ 6. Exit                                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Please select an option (1-6): ");
    }

    // Main method to run the ATM program.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login simulation.
        System.out.println("\033[1;36mWelcome to ByteCash ATM!\033[0m");
        System.out.print("Enter your name: ");
        String user = scanner.nextLine();

        if (!userAccounts.containsKey(user)) {
            System.out.println("\033[1;31mUser not found. Exiting...\033[0m");
            return;
        }

        ByteCashATM atm = new ByteCashATM(user);

        while (true) {
            displayMenuWithBorder(); // Display the ATM menu.
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    atm.viewTransactionHistory();
                    break;
                case 5:
                    atm.contactSupport();
                    break;
                case 6:
                    System.out.println("\033[1;32mThank you for using ByteCash. Goodbye!\033[0m");
                    scanner.close();
                    userAccounts.put(user, atm.balance); // Update user's balance.
                    return;
                default:
                    System.out.println("\033[1;31mInvalid option. Please try again.\033[0m");
            }
        }
    }
}


