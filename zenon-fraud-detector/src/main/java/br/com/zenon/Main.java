package br.com.zenon;

import br.com.zenon.fraud.Transaction;
import br.com.zenon.fraud.Type;
import br.com.zenon.FraudAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    static void main() throws IOException {

        final Logger LOGGER = Logger.getLogger(Main.class.getName());
        final TransactionIngestor transactionIngestor = new TransactionIngestor();
        final FraudAnalyzer fraudAnalyzer = new FraudAnalyzer();

        final String FILE_PATH = "data/PS_20174392719_1491204439457_log.csv";

        try {
            List<Transaction> transactionList = transactionIngestor.extractData(FILE_PATH);

            System.out.println(transactionList.size());
            transactionList.forEach(transaction -> System.out.println(transaction.toString()));

            fraudAnalyzer.fraudSize(transactionList);
            fraudAnalyzer.biggestFrauds(transactionList);
            fraudAnalyzer.getNamesFrauds(transactionList);
            fraudAnalyzer.totalLoss(transactionList);
            fraudAnalyzer.fraudTypesAmount(transactionList);
        } catch(Exception e){
                LOGGER.severe("Fatal error " + e);
        }
    }
}
