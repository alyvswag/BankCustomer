package org.example.Model;

import org.example.Enum.Status;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1234567L;
    private  Long id;
    private Status isActive;
    private String name;
    private String surname;
    private String fin;
    private String phoneNumber;


    public Customer(Long id,Status isActive, String name, String surname, String fin, String phoneNumber) {
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.surname = surname;
        this.fin = fin;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getIsActive() {
        return isActive;
    }

    public void setIsActive(Status isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fin='" + fin + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
