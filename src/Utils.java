import java.util.Scanner;

public class Utils{
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void pause(Scanner scanner){
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }
}