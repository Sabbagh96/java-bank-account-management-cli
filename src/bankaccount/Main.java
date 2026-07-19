package bankaccount;

import java.util.ArrayList;
import java.util.Scanner;

import bankaccount.model.BankAccount;
import bankaccount.service.BankService;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankService service = new BankService();
        boolean running = true;

        while (running) {
            System.out.println("1. Add account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Find account");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = input.nextLine();

                    System.out.print("Enter owner name: ");
                    String ownerName = input.nextLine();

                    System.out.print("Enter initial balance: ");
                    double initialBalance = input.nextDouble();
                    input.nextLine();

                    try {
                        BankAccount account = new BankAccount(
                                accountNumber,
                                ownerName,
                                initialBalance
                        );

                        service.addAccount(account);
                        System.out.println("Account added successfully");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    ArrayList<BankAccount> allAccounts = service.getAllAccounts();

                    if (allAccounts.isEmpty()) {
                        System.out.println("No accounts found");
                        break;
                    }

                    for (BankAccount account : allAccounts) {
                        System.out.println("-------------------");
                        System.out.println("Account number: " + account.getAccountNumber());
                        System.out.println("Owner: " + account.getOwnerName());
                        System.out.println("Balance: " + account.getBalance());
                    }
                    System.out.println("-------------------");
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = input.nextLine();

                    System.out.print("Enter deposit amount: ");
                    double depositAmount = input.nextDouble();
                    input.nextLine();

                    try {
                        service.depositToAccount(depositAccountNumber, depositAmount);
                        System.out.println("Deposit completed successfully");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = input.nextLine();

                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = input.nextDouble();
                    input.nextLine();

                    try {
                        service.withdrawFromAccount(withdrawAccountNumber, withdrawAmount);
                        System.out.println("Withdraw completed successfully");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    String searchAccountNumber = input.nextLine();

                    BankAccount found = service.findAccountByNumber(searchAccountNumber);

                    if (found == null) {
                        System.out.println("Account not found");
                    } else {
                        System.out.println("Account number: " + found.getAccountNumber());
                        System.out.println("Owner: " + found.getOwnerName());
                        System.out.println("Balance: " + found.getBalance());
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }

        input.close();
    }
}
