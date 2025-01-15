import java.util.Scanner;

public class SimpleBankingApplication {

    private String accountHolderName;
    private double accountBalance;

    public SimpleBankingApplication(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = initialBalance;
    }

    public void displayBalance() {
        System.out.println("Current balance: Rs. " + accountBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Successfully deposited Rs. " + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Successfully withdrew Rs. " + amount);
        } else if (amount > accountBalance) {
            System.out.println("Insufficient balance! Withdrawal failed.");
        } else {
            System.out.println("Withdrawal amount must be greater than 0.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Banking Application!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: Rs. ");
        double initialDeposit = scanner.nextDouble();

        SimpleBankingApplication account = new SimpleBankingApplication(name, initialDeposit);

        int choice;

        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.displayBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: Rs. ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: Rs. ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
