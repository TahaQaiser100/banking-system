public class SavingsAccount extends Account{
    private double minimumBalance = 100.0;

    public SavingsAccount(String accountNumber, String name, double balance){
        super(accountNumber, name, balance);
    }

    @Override
    public double getInterestRate(){
        return 0.03;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException{
        if(amount <= 0){
            throw new InvalidAmountException("Amount must be greater than 0");
        }else if(this.balance - amount < minimumBalance){
            throw new InsufficientFundsException("You do not have enough funds as your balance can not be less than £100.");
        }
        this.balance -= amount;
        System.out.println("You withdrew £" + amount + " from your account.");

        //Creating a Transaction object to add to the arraylist
        String id = String.valueOf(transactionHistory.size() + 1);
        Transaction transaction = new Transaction(id, this.accountNumber, "Withdraw", amount);
        transactionHistory.add(transaction);
    }



}
