package br.com.zenon;

import br.com.zenon.fraud.Transaction;
import br.com.zenon.fraud.Type;

import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FraudAnalyzer implements TransactionListRepository {

    Logger LOGGER = Logger.getLogger(FraudAnalyzer.class.getName());

    public void fraudSize(List<Transaction> transactionList){
        Long fraudSize = transactionList.stream()
                .filter(transaction -> transaction.isFraud() == true)
                .count();

        System.out.println("Fraud size: " + fraudSize);
    }

    public void biggestFrauds(List<Transaction> transactionList) {
        List<Transaction> biggestFrauds = transactionList.stream()
                .filter(Transaction::isFraud)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .limit(3)
                .toList();

        System.out.print("Biggest frauds: ");
        biggestFrauds.forEach(transaction -> System.out.println(transaction.getAmount()));
    }

    public void totalLoss(List<Transaction> transactionList) {
        BigDecimal totalLoss = transactionList.stream()
                .filter(Transaction::isFraud)
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total loss: " + totalLoss);
    }

    public void getNamesFrauds(List<Transaction> transactionList) {
        List<String> namesFrauds = transactionList.stream()
                .filter(Transaction::isFraud)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(transaction -> transaction.getOrigin().getName())
                .distinct()
                .limit(5)
                .toList();

        System.out.print("Names: ");
        namesFrauds.forEach(System.out::println);
    }

    public void fraudTypesAmount(List<Transaction> transactionList) {
        Map<Type, Long> totalTypes = transactionList.stream()
                .filter(Transaction::isFraud)
                .collect(Collectors.groupingBy(Transaction::getType, Collectors.counting()));

        System.out.println("Types of frauds: " + totalTypes);
    }

    @Override
    public Optional<Transaction> findByName(List<Transaction> transactionList, String name){

        Long timeInit = System.nanoTime();
        try{
            Transaction customer = transactionList.stream()
                    .filter(transaction -> transaction.getOrigin().getName().equals(name))
                    .findFirst()
                    .orElseThrow();

            return Optional.of(customer);
        }catch(Exception e){
            LOGGER.severe("Transaction not found for client: " + name);
            return Optional.empty();
        }finally{
            Long timeEnd = System.nanoTime();
            System.out.println("Processing time: " + (timeEnd - timeInit) / 1_000_000.0);
        }
    }
}
