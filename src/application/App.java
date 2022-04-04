package application;
// import model.entities;

import java.util.Scanner;
import model.entities.Account;
import model.exception.DomainException;

public class App {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BRIGHT_RED = "\u001B[91m";
    public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
    public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Insert your bank account data: ");
            System.out.println("Account Number:_");
            Integer acn = sc.nextInt();

            System.out.println("Your full name:_");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.println("Current Balance:_R$ ");
            Double balance = sc.nextDouble();

            System.out.println("Withdrawal Limit:_");
            Double wl = sc.nextDouble();

            Account acc = new Account(acn, name, balance, wl);

            System.out.println("Choose the operation:");
            System.out.println(ANSI_BRIGHT_RED + " ( 1 ) - WITHDRAWAL " + ANSI_RESET);
            System.out.println(ANSI_BRIGHT_GREEN + " ( 2 ) - DEPOSIT " + ANSI_RESET);
            Integer answ = sc.nextInt();

            if (answ == 1) {

                System.out.println(" Withdrawal amount: R$ ");
                Double amount = sc.nextDouble();

                System.out.println("Total balance: R$" + ANSI_BRIGHT_YELLOW + acc.Withdraw(amount, wl) + ANSI_RESET);

            } else if (answ == 2) {
                System.out.println("Amount to be deposited: R$");
                Double amount = sc.nextDouble();

                System.out
                        .println("Total balance: R$ " + ANSI_BRIGHT_YELLOW + acc.Deposit(balance, amount) + ANSI_RESET);
            }

        } catch (DomainException e) {
            System.out.println(
                    " You cannot withdraw that amount!" + ANSI_BRIGHT_RED + " Current balance: Low." + ANSI_RESET);

        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        sc.close();

    }
}
