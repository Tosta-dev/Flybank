import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Locale;

public class Account{


    private Locale brazilianLocale = Locale.forLanguageTag("pt-BR");

    private double balance;
    private double credit;
    private double maxBalance;

    private ArrayList<Transaction> history = new ArrayList<>();

    public Account(){
        balance = 500.00;
        credit = 300.00;
        maxBalance = 10000.00;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("\nInvalid amount. Please try again.");
        } else if(balance + amount > maxBalance){
            System.out.println("\nDeposit exceeds the maximum balance limit.");
        } else{
            balance += amount;
            Transaction transaction = new Transaction("Deposit", amount, balance);
            history.add(transaction);
            System.out.println("Deposit Successful!");
            System.out.printf(brazilianLocale, "Your new balance is R$ : %.2f%n", balance);
        }
    }
    public void withdraw(double amount){
        if (amount > 0 && amount > balance){
            System.out.println("\nInsufficient balance, please try again.");
        } else if(amount > 0) {
            balance -= amount;
            Transaction transaction = new Transaction("Withdraw", amount, balance);
            history.add(transaction);
            System.out.println("\nWithdrawal successful!");
            System.out.printf(brazilianLocale, "Your new balance is R$ %.2f%n", balance);
        } else {
            System.out.println("\nInvalid amount. Please try again.");
        }
    }
    public void transfer(double amount){
        if (amount > 0 && amount > balance) {
            System.out.println("\nInsufficient balance, please try again.");
        } else if (amount > 0) {
            balance -= amount;
            Transaction transaction = new Transaction("Transfer", amount, balance);
            history.add(transaction);
            System.out.println("\nTransfer successful!");
            System.out.printf(brazilianLocale, "\n You sent R$ %.2f to the account.%n", amount);
            System.out.printf(brazilianLocale, "Your new balance is R$ %.2f%n", balance);
        } else {
            System.out.println("\nInvalid amount. Please try again.");
        }
    }
    public void bankStatement(){
        System.out.println("\n==================================");
        System.out.println("            FLYBANK");
        System.out.println("         EXTRATO BANCARIO");
        System.out.println("==================================");
        for(int i = history.size() - 1; i >= 0; i--){
            Transaction transaction = history.get(i);

            System.out.println("----------------------------------");
            System.out.println("Type : " + transaction.getType());
            System.out.printf(brazilianLocale, "Amount : R$ %.2f%n", transaction.getAmount());
            System.out.printf(brazilianLocale, "Balance after operation : R$ %.2f%n", transaction.getBalanceAfter());
        }
    }
    public double getBalance(){
        return balance;
    }
    public double getCredit(){
        return credit;
    }
}

