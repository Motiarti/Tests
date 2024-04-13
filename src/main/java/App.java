import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Host host = new Host();
        int accountId = getAccountId(host);
        Account account = host.selectAccount(accountId);
        AutomaticTallerMachine atm = new AutomaticTallerMachine(account);
        atm.displayMainMenu();
    }

    private static int getAccountId(Host host) {
        Scanner sc = new Scanner(System.in);
        int currentAccountId;
        do {
            System.out.print("¬ведите номер счета: ");
            currentAccountId = sc.nextInt();
        } while(!host.isAccountExists(currentAccountId));
        return currentAccountId;
    }
}
