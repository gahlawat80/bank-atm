package org.luv2code.bank.atm.app.model;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private int id;
    private String transactionId;
    private String transactionType;
    private double transactionAmount;
    private double currentBalance;
    private Date transactionDate;

    public Transaction(){}

    public Transaction(String transactionId, String transactionType, double transactionAmount, double currentBalance, Date transactionDate) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.currentBalance = currentBalance;
        this.transactionDate = transactionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transactionId='" + transactionId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", currentBalance=" + currentBalance +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
