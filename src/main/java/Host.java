import java.util.*;

public class Host {
    private final List<Account> accounts;

    public Host() {
        this.accounts = generateAccounts();
    }

    private static List<Account> generateAccounts() {
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

    public boolean isAccountExists(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return true;
            }
        }
        return false;

        // TODO: do same thing with stream api in one line:
        // return accounts.stream().anyMatch(/*YOUR CODE HERE*/);

        // Alternative: call selectAccount(id), return true if no exception happened, and false if exception happened
    }

    // return accounts.stream().anyMatch(/*YOUR CODE HERE*/);
    public boolean isEvenAccountIdPresentInList() {
        return accounts.stream().anyMatch(account -> account.getId() % 2 == 0);
    }

    // return accounts.stream().allMatch(/*YOUR CODE HERE*/);
    public boolean isEvenAccountIdOfLastAccount() {
        return accounts.stream().allMatch(account -> account.getId() % 2 == 0);
    }

    // Alternative: call selectAccount(id), return true if no exception happened, and false if exception happened
    public boolean isExceptionHappened() {
        Date date = new Date();
        Date accountCreateDate;
        try {
            accountCreateDate = selectAccount(1).getDateCreated();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return !date.before(accountCreateDate);
    }

    public Account selectAccount(int currentAccountId) {
//        for (Account account : accounts) {
//            if (currentAccountId == account.getId()) {
//                return account;
//            }
//        }
//        throw new RuntimeException(String.format("Счета с номером %d не существует", currentAccountId));
        // TODO: do same thing with stream api:
        // return accounts.stream().filter(/*YOUR CODE HERE*/).findFirst().orElseThrow(/*CREATE EXCEPTION WHICH SAYS "ACCOUNT WITH ID(currentAccountId) DOES NOT EXIST"*/);

//        accounts.stream().forEach(account -> System.out.println(account.getId()));
//        accounts.stream().filter(account -> account.getId() == currentAccountId).
//                forEach(account -> System.out.println(account.getId()));

        return accounts.stream().
                filter(account -> account.getId() == currentAccountId).
                findFirst().
                orElseThrow(AccountNotExistException::new);
    }

    private static class AccountNotExistException extends NullPointerException {
        public AccountNotExistException() {
            System.out.println("ACCOUNT WITH ID (currentAccountId) DOES NOT EXIST");
        }
    }
}
