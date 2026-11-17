import java.util.*;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 5000;

        try {
            System.out.print("Enter account number: ");
            int account = sc.nextInt();

            System.out.print("Enter withdrawal amount: ");
            int amount = sc.nextInt();

            if (amount < 0)
                throw new IllegalArgumentException("Negative amount");

            if (amount > balance)
                throw new ArithmeticException("Insufficient balance");

            balance -= amount;

            System.out.println("Withdrawal successful");
            System.out.println("Remaining balance: " + balance);
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
        catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("ATM transaction completed");
            sc.close();
        }
    }
}
