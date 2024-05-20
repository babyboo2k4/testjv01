package bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhâp số tài khoản:");
        String accountNumber = scanner.nextLine();
        System.out.print("Nhập tên chủ tài khoản: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Nhập số dư ban đầu: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        AccountBank account = new AccountBank(accountNumber, accountHolderName, balance);

        account.displayAccountInfo();

        account.deposit (0);
        account.withdraw(0);

        System.out.print("Nhập số tài khoản đích để chuyển tiền: ");
        String destinationAccountNumber = scanner.nextLine();

        System.out.print("Nhập tên chủ tài khoản đích: ");
        String destinationAccountHolderName = scanner.nextLine();

        System.out.print("Nhập số dư ban đầu của tài khoản đích: ");
        double destinationBalance = scanner.nextDouble();
        scanner.nextLine();

        AccountBank destinationAccount = new AccountBank(destinationAccountNumber, destinationAccountHolderName, destinationBalance);

        System.out.print("Nhập số tiền cần chuyển: ");
        double transferAmount = scanner.nextDouble();

        account.transfer(destinationAccount, transferAmount);

        account.displayAccountInfo();
        destinationAccount.displayAccountInfo();

        scanner.close();
    }
}
