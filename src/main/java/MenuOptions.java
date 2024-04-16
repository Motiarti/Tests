public enum MenuOptions {
    BALANCE ("0: ��������� ������ �����"),
    WITHDRAW ("1: ����� �� �����"),
    DEPOSIT ("2: �������� �� ����"),
    EXIT ("3: �����");

    private final String operation;

    MenuOptions(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
