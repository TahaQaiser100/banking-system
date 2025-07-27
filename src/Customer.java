import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private ArrayList<Account> accounts;

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.accounts = new ArrayList<>();
    };

    public void addAccount(Account account){
        accounts.add(account);
        System.out.println("An account has been added " + this.name);
    }

    public void remove(String accountNumber){
        if(accounts.isEmpty()){
            System.out.println("You have no accounts added");
        }

        Iterator<Account> it = accounts.iterator();

        while(it.hasNext()){
            Account account = it.next();

            if(account.getAccountNumber().equals(accountNumber)){
                it.remove();
            }
        }
        System.out.println("Your account " + accountNumber + " has been removed.");
    }

    public Account getAccount(String accountNumber){
        if(accounts.isEmpty()){
            System.out.println("You have no accounts added");
        }

        Iterator<Account> it = accounts.iterator();

        while(it.hasNext()) {
            Account account = it.next();

            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Found an account with accountId: " + accountNumber);
                return account;
            }
        }

        return null;
    }

    public void getAllAccounts(){
        for(Account account : accounts){
            System.out.println(account.getAccountNumber());
        }
    }

    public String getTotalBalance(){
        double totalBalance = 0;

        for(Account account : accounts){
            double amount = account.getBalance();
            totalBalance += amount;
        }

        return "Your total balance is: " + totalBalance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        getAllAccounts();
        return this.customerId + ": " + this.name ;

    }
}
