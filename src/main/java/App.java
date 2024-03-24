import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        List<Account> accountList = Host.generateAccounts();
        int accountId = Host.getAccountId();
        AutomaticTallerMachine atm = new AutomaticTallerMachine(accountId, accountList);
        startATM(accountId, accountList, atm);
    }

    public static void startATM(int currentAccountId, List<Account> accountList, AutomaticTallerMachine atm) {
        for (Account account : accountList) {
            if (currentAccountId == account.getId()) {
                atm.displayMainMenu();
            }
        }
    }
}
