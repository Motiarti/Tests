import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private final Date dateCreated;

    public Account() {
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterest() {
        int monthInYear = 12;
        int percent = 100;
        double monthlyInterestRate = getAnnualInterestRate() / percent / monthInYear;
        return getBalance() * monthlyInterestRate;
    }

    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    static List<Account> generateAccounts() {
        double initialBalance = 10000.0;
        int numberOfAccounts = 10;
        List<Account> output = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            output.add(new Account(i, initialBalance));
        }
        return output;
    }

    static int currentAccountId;

    public static int getAccountId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер счета: ");
        currentAccountId = sc.nextInt();
        while (true) {
            if (currentAccountId == 99) {
                System.out.println("Обслуживание завершено");
                System.exit(0);
            }
            if (!(currentAccountId >= 0 && currentAccountId < 10)) {
                System.out.println("Не верный номер счета");
                System.out.println("Для завершения обслуживания введите 99");
                System.out.print("Введите номер счета: ");
                currentAccountId = sc.nextInt();
            } else {
                break;
            }
        }
        return currentAccountId;
    }
}
