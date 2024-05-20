package bank;

public class AccountBank {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public AccountBank() {
        this.accountNumber = "";
        this.accountHolderName = "";
        this.balance = 0.0;
    }

    public AccountBank(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance >= 0 ? balance : 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Số dư không thể âm.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Tên chủ tài khoản: " + accountHolderName);
        System.out.println("Số dư: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Gửi tiền thành công. Số dư hiện tại: " + balance);
        } else {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Rút tiền thành công. Số dư hiện tại: " + balance);
        } else if (amount <= 0) {
            System.out.println("Số tiền rút phải lớn hơn 0.");
        } else {
            System.out.println("Số dư không đủ để rút.");
        }
    }

    public void transfer(AccountBank destinationAccount, double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            destinationAccount.deposit(amount);
            System.out.println("Chuyển tiền thành công. Số dư hiện tại: " + balance);
        } else if (amount <= 0) {
            System.out.println("Số tiền chuyển phải lớn hơn 0.");
        } else {
            System.out.println("Số dư không đủ để chuyển.");
        }
    }
}
