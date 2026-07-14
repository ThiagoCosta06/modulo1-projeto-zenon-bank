package br.com.zenon;

import br.com.zenon.fraud.Transaction;
import br.com.zenon.fraud.Type;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

public class TransactionIngestor{

    private final Logger LOGGER = Logger.getLogger(TransactionIngestor.class.getName());

    public List<Transaction> extractData(String filePath) throws Exception {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            return lines.stream()
                    .skip(1)
                    .limit(100000)
                    .map(this::parseLine)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Fatal error " + e);
        }
    }

    public Optional<Transaction> parseLine(String line) {
        try {
            String[] values = line.split(",");

            int step = Integer.parseInt((String) values[0]);
            String type = values[1];
            BigDecimal amount = new BigDecimal(values[2]);
            String nameOrig = values[3];
            Double oldBalanceOrg = Double.valueOf((String) values[4]);
            Double newBalanceOrig = Double.valueOf((String) values[5]);
            String nameDest = values[6];
            Double oldBalanceDest = Double.valueOf((String) values[7]);
            Double newBalanceDest = Double.valueOf((String) values[8]);
            Boolean isFraud = "1".equals(values[9]);
            Boolean isFlaggedFraud = "1".equals(values[10]);

            return Optional.of(new Transaction(
                    step,
                    type,
                    amount,
                    nameOrig,
                    oldBalanceOrg,
                    oldBalanceDest,
                    nameDest,
                    oldBalanceDest,
                    newBalanceDest,
                    isFraud,
                    isFlaggedFraud
            ));
        } catch (Exception e) {
            LOGGER.severe("Error parsing the line: " + line + "Exception: " + e);
            return Optional.empty();
        }
    }
}
