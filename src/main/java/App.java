import java.util.List;
import java.util.Scanner;

public class App {
    static List<Account> accountList = Host.generateAccounts();

    public static void main(String[] args) {
        int accountId = getAccountId();
        Account account = setAccount(accountList, accountId);
        AutomaticTallerMachine atm = new AutomaticTallerMachine(account);
        atm.displayMainMenu();
    }

    public static int getAccountId() {
        int currentAccountId;
        Scanner sc = new Scanner(System.in);
        System.out.print("¬ведите номер счета: ");
        currentAccountId = sc.nextInt();
        while (!(Host.isAccountExists(accountList, currentAccountId))) {
            System.out.print("¬ведите номер счета: ");
            currentAccountId = sc.nextInt();
        }
        return currentAccountId;
    }

    public static Account setAccount (List<Account> accountList, int currentAccountId) {
        Account output = null;
        for (Account account : accountList) {
            if (currentAccountId == account.getId()) {
                output = account;
            }
        }
        return output;
    }
}
