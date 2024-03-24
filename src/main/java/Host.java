import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Host {
    static List<Account> generateAccounts() {
        double initialBalance = 10000.0;
        int numberOfAccounts = 10;
        List<Account> output = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            output.add(new Account(i, initialBalance));
        }
        return output;
    }

    public static boolean isAccountExists(List<Account> accounts, int id) {
        boolean isAccountExist = false;
        for (Account account : accounts) {
            if (account.getId() == id) {
                isAccountExist = !isAccountExist;
            }
        }
        return isAccountExist;
    }
}
