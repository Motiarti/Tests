import java.util.List;

public class App {

    public static void main(String[] args) {
        int accountId = Account.getAccountId();
        List<Account> accountList = Account.generateAccounts();
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
