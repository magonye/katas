package bankkata;

public class AccountService {
    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;
    private final Clock clock;

    public AccountService(TransactionRepository transactionRepository, StatementPrinter statementPrinter, Clock clock) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
        this.clock = clock;
    }

    public void deposit(int i) {

    }

    public void withdraw(int i) {

    }

    public void printStatement() {

        statementPrinter.printTransactions(transactionRepository.getAllTransactions());

    }
}
