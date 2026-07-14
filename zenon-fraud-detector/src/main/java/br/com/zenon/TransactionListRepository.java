package br.com.zenon;

import br.com.zenon.fraud.Transaction;

import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public interface TransactionListRepository {

    Optional<Transaction> findByName(List<Transaction> transactionList, String name);

}
