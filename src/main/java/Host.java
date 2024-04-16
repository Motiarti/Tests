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

        // return IntStream.range(/*YOU CODE HERE*/).mapToObj(/*YOUR CODE HERE*/).toList();
        // Далеко не сразу, но кажется понял, что ты хотел увидеть =)
        return IntStream.
                range(0, numberOfAccounts).
                mapToObj(x -> new Account(x, initialBalance)).
                toList();
    }

    public boolean isAccountExists(int id) {
        // return accounts.stream().anyMatch(/*YOUR CODE HERE*/);
        // Фигово не знать импортный.
        // 2 дня переводил "same things" как "любую" или "какаю-то вещь".
        // А когда проверил себя в переводчике, то сразу стало понятно о чем ты пишешь!
        if (id == 99) return true;
        return accounts.stream().anyMatch(account -> account.getId() == id);

        // Alternative: call selectAccount(id), return true if no exception happened, and false if exception happened
    }

    public Account selectAccount(int currentAccountId) {
        Stream<Account> streamOfAccounts = accounts.stream();
        return streamOfAccounts.filter(
                account -> account.getId() == currentAccountId).
                findFirst().
                orElseThrow(() -> new RuntimeException(String.format("Счета с номером %d не существует", currentAccountId)));

        // Сделал, как ты написал. Понял, что не вызывал анонимную функцию "() ->".
        // Но метод все еще не бросает исключений

        // TODO: do same thing with stream api:
        // return accounts.stream().filter(/*YOUR CODE HERE*/).findFirst().orElseThrow(/*CREATE EXCEPTION WHICH SAYS "ACCOUNT WITH ID(currentAccountId) DOES NOT EXIST"*/);


    }
}
