import java.util.Scanner;

public class ByteCashATM {
    private double balance; // Stores the current balance of the user.

    // Constructor to initialize the ATM with an initial balance.
    public ByteCashATM(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to check and display the current balance.
    public void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    // Method to deposit a specified amount into the account.
    public void deposit(double amount) {
        if (amount > 0) { // Ensure the deposit amount is positive.
            balance += amount; // Add the deposit amount to the balance.
            System.out.printf("You have successfully deposited: $%.2f%n", amount);
        } else {
            System.out.println("Deposit amount must be positive."); // Handle invalid input.
        }
    }

    // Method to withdraw a specified amount from the account.
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // Check if the amount is valid and within balance.
            balance -= amount; // Deduct the withdrawal amount from the balance.
            System.out.printf("You have successfully withdrawn: $%.2f%n", amount);
        } else if (amount > balance) { // Handle cases where withdrawal exceeds balance.
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive."); // Handle invalid input.
        }
    }

    // Placeholder method for viewing transaction history.
    public void viewTransactionHistory() {
        System.out.println("Transaction history feature coming soon!");
    }

    // Method to display support contact information.
    public void contactSupport() {
        System.out.println("For support, please contact us at support@bytecash.com or call 1-800-BYTECASH.");
    }

    // Static method to display the welcome screen with branding.
    public static void displayWelcomeScreen() {
        // ASCII art for branding and welcome message.
        System.out.println(" ________  ________  ________  ___  ________           ________             ________  ________  ___       ___  ___      ___    ___ ________  _________   ");
        System.out.println("|\\   __  \\|\\   __  \\|\\   __  \\|\\  \\|\\   ___  \\        |\\   __  \\           |\\   __  \\|\\   __  \\|\\  \\     |\\  \\|\\  \\    |\\  \\  /  /|\\   __  \\|\\___   ___\\ ");
        System.out.println("\\ \\  \\|\\ /\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\ \\  \\\\ \\  \\       \\ \\  \\|\\  \\  /\\      \\ \\  \\|\\ /\\ \\  \\|\\  \\ \\  \\    \\ \\  \\\\\\  \\   \\ \\  \\/  / | \\  \\|\\  \\|___ \\  \\_| ");
        System.out.println(" \\ \\   __  \\ \\   __  \\ \\   _  _\\ \\  \\ \\  \\\\ \\  \\       \\ \\__     \\/  \\      \\ \\   __  \\ \\   __  \\ \\  \\    \\ \\  \\\\\\  \\   \\ \\    / / \\ \\  \\\\\\  \\   \\ \\  \\  ");
        System.out.println("  \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\\\  \\\\ \\  \\ \\  \\\\ \\  \\       \\|_/  __     /|      \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\____\\ \\  \\\\\\  \\   \\/  /  /   \\ \\  \\\\\\  \\   \\ \\  \\ ");
        System.out.println("   \\ \\_______\\ \\__\\ \\__\\ \\__\\\\ _\\\\ \\__\\ \\__\\\\ \\__\\        /  /_|\\   / /       \\ \\_______\\ \\__\\ \\__\\ \\_______\\ \\_______\\__/  / /      \\ \\_______\\   \\ \\__\\");
        System.out.println("    \\|_______|\\|__|\\|__|\\|__|\\|__|\\|__|\\|__| \\|__|       /_______   \\/         \\|_______|\\|__|\\|__|\\|_______|\\|_______|\\___/ /        \\|_______|    \\|__|");
        System.out.println("                                                         |_______|\\__\\                                                 \\|___|/                            ");
        System.out.println("                                                                 \\|__|                                                                                   ");
        System.out.println("\nWelcome to ByteCash ATM!");
        System.out.println("Your trusted financial partner.");
        System.out.println("\nDeveloped by: Barin & Baluyot\n");
    }

    // Main method to run the ATM program.
    public static void main(String[] args) {
        displayWelcomeScreen(); // Show the welcome screen.
        Scanner scanner = new Scanner(System.in); // Create a scanner object for user input.
        ByteCashATM atm = new ByteCashATM(1000.00); // Initialize the ATM with a $1000 starting balance.

        while (true) {
            // Display menu options to the user.
            System.out.println("\nByteCash Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Contact Support");
            System.out.println("6. Exit");
            System.out.print("Please select an option (1-6): ");

            int choice = scanner.nextInt(); // Read user's menu choice.

            switch (choice) {
                case 1:
                    atm.checkBalance(); // Call method to check balance.
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble(); // Get deposit amount from user.
                    atm.deposit(depositAmount); // Call method to deposit money.
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble(); // Get withdrawal amount from user.
                    atm.withdraw(withdrawAmount); // Call method to withdraw money.
                    break;
                case 4:
                    atm.viewTransactionHistory(); // Call method to view transaction history.
                    break;
                case 5:
                    atm.contactSupport(); // Call method to contact support.
                    break;
                case 6:
                    // Exit the program gracefully.
                    System.out.println("Thank you for using ByteCash. Goodbye!");
                    scanner.close(); // Close the scanner.
                    return; // Exit the main method.
                default:
                    // Handle invalid menu choices.
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


