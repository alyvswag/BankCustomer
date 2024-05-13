package org.example.Model;


import org.example.Enum.Status;

import java.io.Serializable;

public class Card implements Serializable {
    private static final long serialVersionUID = 123L;
    private Long id;
    private Status status;
    private Customer customer;
    private Long number;
    private String expDate;
    private int cvv;
    private double amount;

    public Card(Long id, Status status, Customer customer, Long number, String expDate, int cvv,double amount) {
        this.id = id;
        this.status = status;
        this.customer = customer;
        this.number = number;
        this.expDate = expDate;
        this.cvv =cvv;
        this.amount =amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", status=" + status +
                ", customer=" + customer +
                ", number=" + number +
                ", expDate='" + expDate + '\'' +
                ", cvv=" + cvv +
                ", amount=" + amount +
                '}';
    }
}
