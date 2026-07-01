package br.com.zenon.fraud;

import java.util.Objects;

public class Transaction{

    private int step;
    private Type type;
    private double amount;
    private TransactionCustomer origin;
    private TransactionCustomer destination;
    private boolean isFraud;
    private boolean isFlaggedFraud;

    public Transaction(int step, Type type, double amount, String nameOrig, double oldBalanceOrg, double newBalanceOrg, String nameDest, double oldBalanceDest, double newBalanceDest, boolean isFraud, boolean isFlaggedFraud) {
        this.isFlaggedFraud = isFlaggedFraud;
        this.isFraud = isFraud;
        this.origin = new TransactionCustomer(nameOrig, oldBalanceOrg, newBalanceOrg);
        this.destination = new TransactionCustomer(nameDest, oldBalanceDest, newBalanceDest);
        this.amount = amount;
        this.type = type;
        this.step = step;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isFraud() {
        return isFraud;
    }

    public void setFraud(boolean fraud) {
        isFraud = fraud;
    }

    public boolean isFlaggedFraud() {
        return isFlaggedFraud;
    }

    public void setFlaggedFraud(boolean flaggedFraud) {
        isFlaggedFraud = flaggedFraud;
    }

    @Override
    public String toString() {
        return "Transaction[" +
                "step=" + step +
                ", type=" + type +
                ", amount=" + amount +
                ", origin=" + origin.toString() +
                ", destination=" + destination.toString() +
                ", isFraud=" + isFraud +
                ", isFlaggedFraud=" + isFlaggedFraud +
                ']';
    }

    //    @Override
//    public String toString() {
//        return
//                "\n step: " + step +
//                "\n type: " + type +
//                "\n amount: " + amount +
//                "\n nameOrig: " + nameOrig +
//                "\n oldBalanceOrg: " + oldBalanceOrg +
//                "\n newBalanceOrg: " + newBalanceOrg +
//                "\n nameDest: " + nameDest +
//                "\n oldBalanceDest: " + oldBalanceDest +
//                "\n newBalanceDest: " + newBalanceDest +
//                "\n isFraud: " + isFraud +
//                "\n isFlaggedFraud: " + isFlaggedFraud + "\n";
//    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return getStep() == that.getStep() && Double.compare(getAmount(), that.getAmount()) == 0 && isFraud() == that.isFraud() && isFlaggedFraud() == that.isFlaggedFraud() && getType() == that.getType() && Objects.equals(origin, that.origin) && Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStep(), getType(), getAmount(), origin, destination, isFraud(), isFlaggedFraud());
    }
}