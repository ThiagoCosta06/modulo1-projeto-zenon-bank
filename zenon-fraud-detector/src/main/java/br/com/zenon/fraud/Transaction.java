package br.com.zenon.fraud;

public record Transaction(int step, Type type, double amount, String nameOrig, double oldBalanceOrg, double newBalanceOrg,
                          String nameDest, String oldBalanceDest, String newBalanceDest, boolean isFraud, boolean isFlaggedFraud) {

}