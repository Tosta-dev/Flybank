import java.util.ArrayList;
import java.util.Locale;

public class Account{


    private Locale brazilianLocale = Locale.forLanguageTag("pt-BR");

    private double balance;
    private double credit;
    private double maxBalance;

    private ArrayList<Double> history = new ArrayList<>();
    private ArrayList<String> historyType = new ArrayList<>();

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
            history.add(amount);
            historyType.add("Deposit");
            System.out.println("Deposit Successful!");
            System.out.printf(brazilianLocale, "Your new balance is R$ : %.2f%n", balance);
        }
    }
    public void withdraw(double amount){
        if (amount > balance){
            System.out.println("\nInsufficient balance, please try again.");
        } else if(amount > 0) {
            balance -= amount;
            history.add(amount);
            historyType.add("Withdraw");
            System.out.println("\nWithdrawal successful!");
            System.out.printf(brazilianLocale, "Your new balance is R$ %.2f%n", balance);
        } else {
            System.out.println("\nInvalid amount. Please try again.");
        }
    }
    public void transfer(double amount){
        if (amount > balance) {
            System.out.println("\nInsufficient balance, please try again.");
        } else if (amount > 0) {
            balance -= amount;
            history.add(amount);
            historyType.add("Transfer");
            System.out.println("\nTransfer successful!");
            System.out.printf(brazilianLocale, "\n You sent R$ %.2f to the account.%n", amount);
            System.out.printf(brazilianLocale, "Your new balance is R$ %.2f%n", balance);
        } else {
            System.out.println("\nInvalid amount. Please try again.");
        }
    }
    public void bankStatement(){
        for(int i = history.size() - 1; i >= 0; i--){
            System.out.printf(brazilianLocale, "%s : R$ %.2f%n", historyType.get(i), history.get(i));
        }
    }
    public double getBalance(){
        return balance;
    }
    public double getCredit(){
        return credit;
    }
}

