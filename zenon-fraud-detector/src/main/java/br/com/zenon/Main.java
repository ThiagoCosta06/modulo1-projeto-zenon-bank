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

        String FILE_PATH = "C:/Users/User/Downloads/Studying/AnhangueraPostGraduation/Codigos/Modulo1/modulo1-projeto-zenon-bank/data/PS_20174392719_1491204439457_log.csv";
        Path filePath = Path.of(FILE_PATH);

        try {
            String fileContent = Files.readString(filePath);
            String[] lines = fileContent.split("\n");
            String[] keys = lines[0].split(",");

            List<Transaction> transactionList = new LinkedList<>();

            for(int i = 1; i <= Arrays.stream(lines).toList().size(); i++){
                Map values = new LinkedHashMap<String, String>();
                String[] lineValues = lines[i].split(",");
                for(int j = 0; j < Arrays.stream(keys).toList().size(); j++) {
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
                        (String) values.get("oldbalanceDest"),
                        values.get("newbalanceDest").toString(),
                        Boolean.valueOf((String) values.get("isFraud")),
                        Boolean.valueOf((String) values.get("isFlaggerFraud")))
                );

            }

            LOGGER.info("Transaction List Size: " + transactionList.toString());

        } catch(Exception e){
                LOGGER.severe("Fatal error " + e);
        }

    }
}
