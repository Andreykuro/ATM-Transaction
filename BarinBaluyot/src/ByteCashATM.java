import java.util.Scanner;

public class ByteCashATM {
    private double balance; // Stores the current balance of the user.

    // Constructor to initialize the ATM with an initial balance.
    public ByteCashATM(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to check and display the current balance.
    public void checkBalance() {
        System.out.printf("\033[1;32mYour current balance is: $%.2f\033[0m%n", balance);
    }

    // Method to deposit a specified amount into the account.
    public void deposit(double amount) {
        if (amount > 0) { // Ensure the deposit amount is positive.
            balance += amount; // Add the deposit amount to the balance.
            System.out.printf("\033[1;34mYou have successfully deposited: $%.2f\033[0m%n", amount);
        } else {
            System.out.println("\033[1;31mDeposit amount must be positive.\033[0m"); // Handle invalid input.
        }
    }

    // Method to withdraw a specified amount from the account.
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // Check if the amount is valid and within balance.
            balance -= amount; // Deduct the withdrawal amount from the balance.
            System.out.printf("\033[1;34mYou have successfully withdrawn: $%.2f\033[0m%n", amount);
        } else if (amount > balance) { // Handle cases where withdrawal exceeds balance.
            System.out.println("\033[1;31mInsufficient funds.\033[0m");
        } else {
            System.out.println("\033[1;31mWithdrawal amount must be positive.\033[0m"); // Handle invalid input.
        }
    }

    // Placeholder method for viewing transaction history.
    public void viewTransactionHistory() {
        System.out.println("\033[1;36mTransaction history feature coming soon!\033[0m");
    }

    // Method to display support contact information.
    public void contactSupport() {
        System.out.println("\033[1;35mFor support, please contact us at support@bytecash.com or call 1-800-BYTECASH.\033[0m");
    }

    // Static method to display the welcome screen with branding.
    public static void displayWelcomeScreen() {
        // Colored ASCII art for branding and welcome message.
        System.out.println("\033[38;2;255;0;0m ________  ________  ________  ___  ________           ________             ________  ________  ___       ___  ___      ___    ___ ________  _________   \033[0m");
        System.out.println("\033[38;2;255;127;0m|\\   __  \\|\\   __  \\|\\   __  \\|\\  \\|\\   ___  \\        |\\   __  \\           |\\   __  \\|\\   __  \\|\\  \\     |\\  \\|\\  \\    |\\  \\  /  /|\\   __  \\|\\___   ___\\\033[0m");
        System.out.println("\033[38;2;255;255;0m\\ \\  \\|\\ /\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\ \\  \\\\ \\  \\       \\ \\  \\|\\  \\  /\\      \\ \\  \\|\\ /\\ \\  \\|\\  \\ \\  \\    \\ \\  \\\\\\  \\   \\ \\  \\/  / | \\  \\|\\  \\|___ \\  \\_|\033[0m");
        System.out.println("\033[38;2;0;255;0m \\ \\   __  \\ \\   __  \\ \\   _  _\\ \\  \\ \\  \\\\ \\  \\       \\ \\__     \\/  \\      \\ \\   __  \\ \\   __  \\ \\  \\    \\ \\  \\\\\\  \\   \\ \\    / / \\ \\  \\\\\\  \\   \\ \\  \\ \033[0m");
        System.out.println("\033[38;2;0;127;255m  \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\\\  \\\\ \\  \\ \\  \\\\ \\  \\       \\|_/  __     /|      \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\____\\ \\  \\\\\\  \\   \\/  /  /   \\ \\  \\\\\\  \\   \\ \\  \\ \033[0m");
        System.out.println("\033[38;2;0;0;255m   \\ \\_______\\ \\__\\ \\__\\ \\__\\\\ _\\\\ \\__\\ \\__\\\\ \\__\\        /  /_|\\   / /       \\ \\_______\\ \\__\\ \\__\\ \\_______\\ \\_______\\__/  / /      \\ \\_______\\   \\ \\__\\\033[0m");
        System.out.println("\033[38;2;127;0;255m    \\|_______|\\|__|\\|__|\\|__|\\|__|\\|__|\\|__| \\|__|       /_______   \\/         \\|_______|\\|__|\\|__|\\|_______|\\|_______|\\___/ /        \\|_______|    \\|__|\033[0m");
        System.out.println("\033[38;2;255;0;255m                                                         |_______|\\__\\                                                 \\|___|/                            \033[0m");
        System.out.println("\033[38;2;255;0;127m                                                                 \\|__|                                                                                   \033[0m");
        System.out.println("\n\033[1;37mWelcome to ByteCash ATM!\033[0m");
        System.out.println("\033[1;37mYour trusted financial partner.\033[0m");
        System.out.println("\n\033[1;37mDeveloped by: Barin & Baluyot\033[0m\n");
    }

    // Main method to run the ATM program.
    public static void main(String[] args) {
        displayWelcomeScreen(); // Show the welcome screen.
        Scanner scanner = new Scanner(System.in); // Create a scanner object for user input.
        ByteCashATM atm = new ByteCashATM(1000.00); // Initialize the ATM with a $1000 starting balance.

        while (true) {
            // Display menu options to the user.
            System.out.println("\n\033[1;36mByteCash Menu:\033[0m");
            System.out.println("\033[1;33m1. Check Balance\033[0m");
            System.out.println("\033[1;33m2. Deposit Money\033[0m");
            System.out.println("\033[1;33m3. Withdraw Money\033[0m");
            System.out.println("\033[1;33m4. View Transaction History\033[0m");
            System.out.println("\033[1;33m5. Contact Support\033[0m");
            System.out.println("\033[1;33m6. Exit\033[0m");
            System.out.print("\033[1;37mPlease select an option (1-6): \033[0m");

            int choice = scanner.nextInt(); // Read user's menu choice.

            switch (choice) {
                case 1:
                    atm.checkBalance(); // Call method to check balance.
                    break;
                case 2:
                    System.out.print("\033[1;37mEnter amount to deposit: $\033[0m");
                    double depositAmount = scanner.nextDouble(); // Get deposit amount from user.
                    atm.deposit(depositAmount); // Call method to deposit money.
                    break;
                case 3:
                    System.out.print("\033[1;37mEnter amount to withdraw: $\033[0m");
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
                    System.out.println("\033[1;32mThank you for using ByteCash. Goodbye!\033[0m");
                    scanner.close(); // Close the scanner.
                    return; // Exit the main method.
                default:
                    // Handle invalid menu choices.
                    System.out.println("\033[1;31mInvalid option. Please try again.\033[0m");
            }
        }
    }
}
