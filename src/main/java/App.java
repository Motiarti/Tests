import java.util.List;
import java.util.Scanner;

public class App {
    static List<Account> accountList = Host.generateAccounts();

    public static void main(String[] args) {
        int accountId = getAccountId();
        Account account = selectAccount(accountList, accountId);
        AutomaticTallerMachine atm = new AutomaticTallerMachine(account);
        atm.displayMainMenu();
    }

    private static int getAccountId() {
        Scanner sc = new Scanner(System.in);
        int currentAccountId;
        do {
            System.out.print("¬ведите номер счета: ");
            currentAccountId = sc.nextInt();
        } while(!Host.isAccountExists(accountList, currentAccountId));
        return currentAccountId;
    }

    private static Account selectAccount(List<Account> accountList, int currentAccountId) {
        for (Account account : accountList) {
            if (currentAccountId == account.getId()) {
                return account;
            }
        }
        throw new RuntimeException(String.format("—чета с номером %d не существует", currentAccountId));

        // TODO: do same thing with stream api:
        // return accountList.stream().filter(/*YOUR CODE HERE*/).findFirst().orElseThrow(/*CREATE EXCEPTION WHICH SAYS "ACCOUNT WITH ID(currentAccountId) DOES NOT EXIST"*/);
    }
}
