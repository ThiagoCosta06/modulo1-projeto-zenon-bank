package br.com.zenon.fraud;

public record Transaction(int step, Type type, double amount, String nameOrig, double oldBalanceOrg, double newBalanceOrg,
                          String nameDest, String oldBalanceDest, String newBalanceDest, boolean isFraud, boolean isFlaggedFraud) {
    @Override
    public String toString() {
        return
                "\n step: " + step +
                "\n type: " + type +
                "\n amount: " + amount +
                "\n nameOrig: " + nameOrig +
                "\n oldBalanceOrg: " + oldBalanceOrg +
                "\n newBalanceOrg: " + newBalanceOrg +
                "\n nameDest: " + nameDest +
                "\n oldBalanceDest: " + oldBalanceDest +
                "\n newBalanceDest: " + newBalanceDest +
                "\n isFraud: " + isFraud +
                "\n isFlaggedFraud: " + isFlaggedFraud + "\n";
    }
}