package br.com.zenon.fraud;

import java.util.Objects;

public class TransactionCustomer {

    private String name;
    private double oldBalance;
    private double newBalance;

    public TransactionCustomer(String name, double oldBalance, double newBalance) {
        this.name = name;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOldBalance() {
        return oldBalance;
    }

    public void setOldBalance(double oldBalance) {
        this.oldBalance = oldBalance;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    @Override
    public String toString() {
        return "TransactionCustomer[" +
                "name='" + name + '\'' +
                ", oldBalance='" + oldBalance + '\'' +
                ", newBalance='" + newBalance + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionCustomer that = (TransactionCustomer) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getOldBalance(), that.getOldBalance()) && Objects.equals(getNewBalance(), that.getNewBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getOldBalance(), getNewBalance());
    }
}
