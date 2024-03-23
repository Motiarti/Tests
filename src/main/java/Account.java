import java.util.Date;
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
    public static int getAccountId() {
        Scanner sc = new Scanner(System.in);
        int currentAccountId;
        AutomaticTallerMachine atm = new AutomaticTallerMachine();
        System.out.print("¬ведите номер счета: ");
        currentAccountId = sc.nextInt();
        while (true) {
            if (currentAccountId == 99) {
                atm.completeService();
                break;
            } else if (!(currentAccountId >= 0 && currentAccountId < 10)) {
                System.out.println("ƒл€ завершени€ обслуживани€ введите 99");
                System.out.print("¬ведите номер счета: ");
                currentAccountId = sc.nextInt();
            } else {
                atm.displayMainMenu();
                break;
            }
        }
        return currentAccountId;
    }
}
