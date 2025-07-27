public class CheckingAccount extends Account{
    private double overDraft = 500.0;

    public CheckingAccount(String accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    @Override
    public double getInterestRate(){
        return 0.01;
    };

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException{
        if(amount <= 0){
            throw new InvalidAmountException("Amount must be greater than 0");
        }else if(amount > this.balance + overDraft){
            throw new InsufficientFundsException("You do not have enough funds as your balance. You can not exceed your overdraft limit");
        }

        this.balance -= amount;
        System.out.println("You withdrew £" + amount + " from your account.");


        //Creating a Transaction object to add to the arraylist
        String id = String.valueOf(transactionHistory.size() + 1);
        Transaction transaction = new Transaction(id, this.accountNumber, "Withdraw", amount);
        transactionHistory.add(transaction);
    }
}
