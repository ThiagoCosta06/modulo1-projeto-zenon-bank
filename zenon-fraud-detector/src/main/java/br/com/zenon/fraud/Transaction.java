package br.com.zenon.fraud;

import com.google.common.base.Preconditions;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction{

    private int step;
    private Type type;
    private BigDecimal amount;
    private TransactionCustomer origin;
    private TransactionCustomer destination;
    private boolean isFraud;
    private boolean isFlaggedFraud;

    public Transaction(int step, String type, BigDecimal amount, String nameOrig, double oldBalanceOrg, double newBalanceOrg, String nameDest, double oldBalanceDest, double newBalanceDest, boolean isFraud, boolean isFlaggedFraud) {
        if(step <= 0) throw new IllegalArgumentException("Argument step must be bigger than 0");
        if(amount.signum() != 1) throw new IllegalArgumentException("Argument amount must be bigger than 0");
        if(oldBalanceOrg < 0) throw new IllegalArgumentException("Argument oldBalanceOrg must be bigger than 0");
        if(newBalanceOrg < 0) throw new IllegalArgumentException("Argument newBalanceOrg must be bigger than 0");
        if(oldBalanceDest < 0) throw new IllegalArgumentException("Argument oldBalanceDest must be bigger than 0");
        if(newBalanceDest < 0) throw new IllegalArgumentException("Argument newBalanceDest must be bigger than 0");
        if(newBalanceDest < 0) throw new IllegalArgumentException("Argument newBalanceDest must be bigger than 0");
        if(Type.valueOf(type).) throw new IllegalArgumentException("Argument newBalanceDest must be bigger than 0");
        if(nameDest.isEmpty()) throw new IllegalArgumentException("Argument name cannot be null");
        Objects.nonNull(step);
        Objects.nonNull(type);
        Objects.nonNull(amount);
        Objects.nonNull(nameOrig);
        Objects.nonNull(oldBalanceOrg);
        Objects.nonNull(newBalanceOrg);
        Objects.nonNull(nameDest);
        Objects.nonNull(oldBalanceDest);
        Objects.nonNull(newBalanceDest);
        Objects.nonNull(isFraud);
        Objects.nonNull(isFlaggedFraud);

        this.isFlaggedFraud = isFlaggedFraud;
        this.isFraud = isFraud;
        this.origin = new TransactionCustomer(nameOrig, oldBalanceOrg, newBalanceOrg);
        this.destination = new TransactionCustomer(nameDest, oldBalanceDest, newBalanceDest);
        this.amount = amount;
        this.type = Type.valueOf(type);
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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
        return getStep() == that.getStep() && isFraud() == that.isFraud() && isFlaggedFraud() == that.isFlaggedFraud() && getType() == that.getType() && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(origin, that.origin) && Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStep(), getType(), getAmount(), origin, destination, isFraud(), isFlaggedFraud());
    }
}