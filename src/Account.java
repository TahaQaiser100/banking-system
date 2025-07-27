import java.util.ArrayList;

public abstract class Account {
    protected String accountNumber;
    protected String name;
    protected double balance;
    protected ArrayList<Transaction> transactionHistory = new ArrayList<>();

    public Account(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public abstract double getInterestRate();

    public void deposit(double amount) throws InvalidAmountException {
        if(amount <= 0){
            throw new InvalidAmountException("Amount must be greater than 0");
        }

        this.balance += amount;
        System.out.println("You have deposited £" + amount + " to your account.");


        //Creating a Transaction object to add to the arraylist
        String id = String.valueOf(transactionHistory.size() + 1);
        Transaction transaction = new Transaction(id, this.accountNumber, "Deposit", amount);
        transactionHistory.add(transaction);
    }


    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException{
        if(amount <= 0){
            throw new InvalidAmountException("Amount must be greater than 0");
        }else if(amount > balance){
            throw new InsufficientFundsException("You do not have enough funds as your balance can not be negative.");
        }


        this.balance -= amount;
        System.out.println("You withdrew £" + amount + " from your account.");


        //Creating a Transaction object to add to the arraylist
        String id = String.valueOf(transactionHistory.size() + 1);
        Transaction transaction = new Transaction(id, this.accountNumber, "Withdraw", amount);
        transactionHistory.add(transaction);

        System.out.println("ACCOUNT NUMBER IS" + this.accountNumber);
    }

    public void printTransaction(){
        for(Transaction transaction : transactionHistory){
            System.out.println(transaction);
        }
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }



    //Method to transfer amount from one account to another
    public void transferMoney(Account toAccount, double amount) throws InvalidAmountException, InsufficientFundsException {
        if(amount <= 0){
            throw new InvalidAmountException("Amount must not be less than or equal to 0");
        }

        this.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Money has been transferred to " + toAccount);
    }


    public double getBalance() {
        return balance;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.name + ": Account Number: " + this.accountNumber + ".\nYour balance is: " + this.balance;
    }
}
