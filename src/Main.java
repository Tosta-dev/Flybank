import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Flybank! ");
        System.out.println("Let's create your account!");
        Utils.pause(scanner);

        Account account;
        User user;

        while (true){
            Utils.clearScreen();
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            user = new User(name, cpf, age);

            if  (user.isEligible()){
                System.out.println("\nAccount created successfully!");
                account = new Account();
                System.out.println("Welcome, " + user.getName());
                System.out.println("Your initial balance is R$ " + account.getBalance());
                System.out.println("Your initial credit is R$ " + account.getCredit());
                break;
            } else {
                System.out.println("You are not allowed to create an account.");
                System.out.println("You must be at least 18 years old and have an valid CPF.");
                Utils.pause(scanner);
            }
        }

        Utils.pause(scanner);

        while (true){
            Utils.clearScreen();
            System.out.println("\n- - - - - - - - - - Menu - - - - - - - - - - ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("5. Bank statement");
            System.out.println("6. Exit");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Choose an option : ");
            int answer = scanner.nextInt();
            scanner.nextLine();

            switch (answer){
                case 1:
                    System.out.println("\n- - - - - - - - - - DEPOSIT - - - - - - - - - -");
                    System.out.print("Enter the amount to deposit: R$ ");
                    double deposit = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(deposit);
                    System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - -");
                    System.out.println("Returning to the menu...");
                    Utils.pause(scanner);
                    break;
                case 2:
                    System.out.println("\n- - - - - - - - - - WITHDRAW - - - - - - - - - -");
                    System.out.print("Enter the amount to withdraw: ");
                    System.out.print("\nAmount : R$ ");
                    double withdraw = scanner.nextDouble();
                    scanner.nextLine();
                    account.withdraw(withdraw);
                    System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - -");
                    System.out.println("Returning to the menu...");
                    Utils.pause(scanner);
                    break;
                case 3:
                    System.out.println("\n- - - - - - - - - - TRANSFER - - - - - - - - - -");
                    System.out.print("Enter the amount to transfer: ");
                    System.out.print("\nAmount : R$ ");
                    double transfer = scanner.nextDouble();
                    scanner.nextLine();
                    account.transfer(transfer);
                    System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - -");
                    System.out.println("Returning to the menu...");
                    Utils.pause(scanner);
                    break;
                case 4:
                    System.out.println("- - - - - - - - - - BALANCE - - - - - - - - - -");
                    System.out.println("Your balance is R$ " + account.getBalance());
                    System.out.println("Your credit is R$ " + account.getCredit());
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
                    System.out.println("Returning to the menu...");
                    Utils.pause(scanner);
                    break;
                case 5 :
                    System.out.println("\n- - - - - - - - - - Bank Statement - - - - - - - - - -");
                    account.bankStatement();
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
                    System.out.println("Returning to the menu...");
                    Utils.pause(scanner);
                    break;
                case 6:
                    System.out.println("Thank you for using Flybank!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    Utils.pause(scanner);
            }
        }
    }
}