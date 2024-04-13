import java.util.Scanner;

public class App {
    static Host host = new Host();
    public static void main(String[] args) {
        System.out.println("Account create date is past: " + host.isExceptionHappened());
        System.out.println("Account with even account ID is present: " + host.isEvenAccountIdPresentInList());
        System.out.println("Last account in scope have even account ID: " + host.isEvenAccountIdOfLastAccount());

        while (true) {
            int accountId = getAccountId(host);
            Account account;
            try {
                account = host.selectAccount(accountId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            AutomaticTallerMachine atm = new AutomaticTallerMachine(account);
            atm.displayMainMenu();
        }
    }

    private static int getAccountId(Host host) {
        Scanner sc = new Scanner(System.in);
        int currentAccountId;
        do {
            System.out.print("¬ведите номер счета: ");
            currentAccountId = sc.nextInt();
        } while (!host.isAccountExists(currentAccountId));
        return currentAccountId;
    }
}
