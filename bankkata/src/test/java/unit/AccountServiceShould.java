package unit;

import bankkata.AccountService;
import bankkata.Clock;
import bankkata.StatementPrinter;
import bankkata.Transaction;
import bankkata.TransactionRepository;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceShould {

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private StatementPrinter statementPrinter;
    @Mock
    private Clock clock;

    @Test
    public void print_an_empty_statement_if_no_transactions() {
        AccountService accountService = new AccountService(transactionRepository, statementPrinter, clock);

        List<Transaction> listOfTransactions = new ArrayList();
        given(transactionRepository.getAllTransactions()).willReturn(listOfTransactions);

        accountService.printStatement();

        verify(statementPrinter).printTransactions(listOfTransactions);

    }

    @Test
    public void print_a_statement() {
        AccountService accountService = new AccountService(transactionRepository, statementPrinter, clock);

        List<Transaction> listOfTransactions = new ArrayList();
        given(transactionRepository.getAllTransactions()).willReturn(listOfTransactions);

        accountService.printStatement();

        verify(statementPrinter).printTransactions(listOfTransactions);

    }
}
