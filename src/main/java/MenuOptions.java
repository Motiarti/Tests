public enum MenuOptions {
    BALANCE ("0: проверить баланс счета"),
    WITHDRAW ("1: снять со счета"),
    DEPOSIT ("2: положить на счет"),
    EXIT ("3: выйти");

    private final String operation;

    MenuOptions(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
