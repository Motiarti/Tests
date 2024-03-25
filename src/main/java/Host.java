import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Host {
    public static List<Account> generateAccounts() {
        double initialBalance = 10000.0;
        int numberOfAccounts = 10;
        List<Account> output = new ArrayList<>();
        for (int i = 0; i < numberOfAccounts; i++) {
            output.add(new Account(i, initialBalance));
        }
        return output;

        // TODO: do same thing with stream api in one line:
        // return IntStream.range(/*YOU CODE HERE*/).mapToObj(/*YOUR CODE HERE*/).toList();
    }

    public static boolean isAccountExists(List<Account> accounts, int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return true;
            }
        }
        return false;

        // TODO: do same thing with stream api in one line:
        // return accounts.stream().anyMatch(/*YOUR CODE HERE*/);
    }
}
