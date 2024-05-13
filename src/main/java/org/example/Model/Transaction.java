package org.example.Model;

import org.example.Enum.TransactionType;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1121L;
    private TransactionType transactionType;
    private LocalDateTime currentTime;
    private String senderCardNumber;
    private String receiver;
    private double amount;

    public Transaction(TransactionType transactionType, LocalDateTime currentTime, String senderCardNumber, String receiver, double amount) {
        this.transactionType = transactionType;
        this.currentTime = currentTime;
        this.senderCardNumber = senderCardNumber;
        this.receiver = receiver;
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public String getSenderCardNumber() {
        return senderCardNumber;
    }

    public void setSenderCardNumber(String senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "------" + "\n"+
                "transactionType=" + transactionType +"\n"+
                ", currentTime=" + currentTime +"\n"+
                ", senderCardNumber='" + senderCardNumber + "\n"+
                ", receiver='" + receiver +"\n"+
                ", amount=" + amount +"\n"+
                "-----";
    }
}
