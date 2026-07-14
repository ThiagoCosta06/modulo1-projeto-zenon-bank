package br.com.zenon;

import br.com.zenon.fraud.Transaction;
import br.com.zenon.fraud.Type;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FraudAnalyzer {

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
}
