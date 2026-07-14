package br.com.zenon.fraud;

import br.com.zenon.TransactionListRepository;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TransactionMapRepository{

    Logger LOGGER = Logger.getLogger(TransactionMapRepository.class.getName());
    private final Map<String, Transaction> transactionListMap;

    public TransactionMapRepository(List<Transaction> transactionList){
        Objects.requireNonNull(transactionList);
        this.transactionListMap = transactionList.stream().collect(Collectors.toMap(transaction -> transaction.getOrigin().getName(), Function.identity()));
    }

    public Optional<Transaction> findByName(String name){
        Long timeInit = System.nanoTime();
        try{
            return Optional.ofNullable(transactionListMap.get(name));
        }catch(Exception e){
            LOGGER.severe("Error while trying to find by name: " + e);
            return Optional.empty();
        }finally {
            Long timeEnd = System.nanoTime();
            System.out.println("Processing time: " + (timeEnd - timeInit) / 1_000_000.0);
        }
    }

}
