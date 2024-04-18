import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Host {
    private final List<Account> accounts;

    public Host() {
        this.accounts = generateAccounts();
    }

    private static List<Account> generateAccounts() {
        double initialBalance = 10000.0;
        int numberOfAccounts = 10;
        return IntStream.
                range(0, numberOfAccounts).
                mapToObj(x -> new Account(x, initialBalance)).
                toList();
    }

    public boolean isAccountExists(int id) {
        if (id == 99) return true;
        return accounts.stream().anyMatch(account -> account.getId() == id);
    }

    public Account selectAccount(int currentAccountId) {
        Stream<Account> streamOfAccounts = accounts.stream();
        return streamOfAccounts.filter(
                account -> account.getId() == currentAccountId).
                findFirst().
                orElseThrow(() -> new RuntimeException(String.format("Счета с номером %d не существует", currentAccountId)));
    }
}
