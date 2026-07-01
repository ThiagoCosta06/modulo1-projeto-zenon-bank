package br.com.zenon;

import br.com.zenon.fraud.Transaction;
import br.com.zenon.fraud.Type;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

public class TransactionIngestor {

    private final Logger LOGGER = Logger.getLogger(TransactionIngestor.class.getName());

    public List<Transaction> extractData(Path filePath) throws Exception {

        List<Transaction> transactionList = new LinkedList<>();

        try {
            String fileContent = Files.readString(filePath);
            String[] lines = fileContent.split("\n");
            String[] keys = lines[0].split(",");


            for (int i = 1; i <= Arrays.stream(lines).toList().size(); i++) {
                Map values = new LinkedHashMap<String, String>();
                String[] lineValues = lines[i].split(",");
                for (int j = 0; j < Arrays.stream(keys).toList().size(); j++) {
                    values.put(keys[j], lineValues[j]);
                }
                transactionList.add(new Transaction(
                        Integer.valueOf((String) values.get("step")),
                        Type.valueOf((String) values.get("type")),
                        Double.valueOf((String) values.get("amount")),
                        (String) values.get("nameOrig"),
                        Double.valueOf((String) values.get("oldbalanceOrg")),
                        Double.valueOf((String) values.get("newbalanceOrig")),
                        (String) values.get("nameDest"),
                        Double.valueOf((String) values.get("oldbalanceDest")),
                        Double.valueOf(values.get("newbalanceDest").toString()),
                        Boolean.valueOf((String) values.get("isFraud")),
                        Boolean.valueOf((String) values.get("isFlaggerFraud")))
                );

                if (i == 1000) {
                    break;
                }
            }


        } catch (Exception e) {
            LOGGER.severe("Fatal error " + e);
        }

        return transactionList;
    }

}
