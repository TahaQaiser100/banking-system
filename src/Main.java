import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        System.out.println("--- BANKING SYSTEM. A COMPREHENSIVE TEST ---\n");

        try {
            // Create customers
            Customer john = new Customer("C0001", "John Smith", "john@email.com");
            Customer jane = new Customer("C002", "Jane Doe", "jane@email.com");
            System.out.println("Customers created successfully");

            // Create accounts
            SavingsAccount johnSavings = new SavingsAccount("SAV0001", "John Smith", 1000.0);
            CheckingAccount johnChecking = new CheckingAccount("CHK0001", "John Smith", 500.0);
            SavingsAccount janeSavings = new SavingsAccount("SAV0002", "Jane Doe", 800.0);
            CheckingAccount janeChecking = new CheckingAccount("CHK0002", "Jane Doe", 300.0);
            System.out.println("Accounts created successfully");

            // Add accounts to customers
            john.addAccount(johnSavings);
            john.addAccount(johnChecking);
            jane.addAccount(janeSavings);
            jane.addAccount(janeChecking);
            System.out.println("Accounts added to customers");

            System.out.println("\n=== Testing Deposits ===");
            johnSavings.deposit(200.0);
            johnChecking.deposit(100.0);
            janeSavings.deposit(150.0);
            System.out.println("All deposits successful");

            System.out.println("\n=== Testing Valid Withdrawals ===");
            johnSavings.withdraw(50.0);
            johnChecking.withdraw(200.0);
            janeSavings.withdraw(100.0);
            System.out.println("Valid withdrawals successful");

            System.out.println("\n=== Testing Invalid Withdrawals ===");
            try {
                johnSavings.withdraw(2000.0);
            } catch (Exception e) {
                System.out.println("Expected error: " + e.getMessage());
            }

            try {
                johnChecking.withdraw(2000.0);
            } catch (Exception e) {
                System.out.println("Expected error: " + e.getMessage());
            }

            System.out.println("\n=== Testing Money Transfers ===");
            johnSavings.transferMoney(janeSavings, 100.0);
            johnChecking.transferMoney(janeChecking, 50.0);
            System.out.println("Transfers completed successfully");

            System.out.println("\n=== Current Account Balances ===");
            System.out.println("John's Savings: £" + johnSavings.getBalance());
            System.out.println("John's Checking: £" + johnChecking.getBalance());
            System.out.println("Jane's Savings: £" + janeSavings.getBalance());
            System.out.println("Jane's Checking: £" + janeChecking.getBalance());

            System.out.println("\n=== Customer Total Balances ===");
            System.out.println("John: " + john.getTotalBalance());
            System.out.println("Jane: " + jane.getTotalBalance());

            System.out.println("\n=== Transaction Histories ===");
            System.out.println("\nJohn's Savings Transactions:");
            johnSavings.printTransaction();

            System.out.println("\nJohn's Checking Transactions:");
            johnChecking.printTransaction();

            System.out.println("\nJane's Savings Transactions:");
            janeSavings.printTransaction();

            System.out.println("\nJane's Checking Transactions:");
            janeChecking.printTransaction();

            System.out.println("\n=== Testing Account Search ===");
            Account foundAccount = john.getAccount("SAV001");
            if (foundAccount != null) {
                System.out.println("Account search successful: " + foundAccount.getAccountNumber());
            }

            System.out.println("\n=== Testing Interest Rates ===");
            System.out.println("Savings Account Interest Rate: " + (johnSavings.getInterestRate() * 100) + "%");
            System.out.println("Checking Account Interest Rate: " + (johnChecking.getInterestRate() * 100) + "%");

            System.out.println("\n=== ALL TESTS COMPLETED SUCCESSFULLY ===");
            System.out.println("Customer Management");
            System.out.println("Account Creation (Savings & Checking)");
            System.out.println("Deposit Operations");
            System.out.println("Withdrawal Operations");
            System.out.println("Transfer Operations");
            System.out.println("Exception Handling");
            System.out.println("Transaction History Tracking");
            System.out.println("Balance Calculations");
            System.out.println("Account Search Functionality");
            System.out.println("Interest Rate Management");

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class InsufficientFundsException extends Exception{
    public InsufficientFundsException(){}
    public InsufficientFundsException(String message){
        super(message);
    }
}

class InvalidAmountException extends Exception{
    public InvalidAmountException(){}
    public InvalidAmountException(String message){
        super(message);
    }
}