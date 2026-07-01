package br.com.zenon;

import br.com.zenon.fraud.Transaction;
import br.com.zenon.fraud.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    static void main() throws IOException {

        final Logger LOGGER = Logger.getLogger(Main.class.getName());
        final TransactionIngestor transactionIngestor = new TransactionIngestor();

        String FILE_PATH = "C:/Users/User/Downloads/Studying/AnhangueraPostGraduation/Codigos/Modulo1/modulo1-projeto-zenon-bank/data/PS_20174392719_1491204439457_log.csv";
        Path filePath = Path.of(FILE_PATH);

        try {
            List<Transaction> transactionList = transactionIngestor.extractData(filePath);

            transactionList.forEach(transaction -> System.out.println(transaction.toString()));
        } catch(Exception e){
                LOGGER.severe("Fatal error " + e);
        }
    }
}
