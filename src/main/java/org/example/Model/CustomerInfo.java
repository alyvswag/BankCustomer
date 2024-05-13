package org.example.Model;

import java.io.Serializable;

public class CustomerInfo implements Serializable {
    private static final long serialVersionUID = 111L;
    private String fin;
    private String password;

    public CustomerInfo(String fin, String password) {
        this.fin = fin;
        this.password = password;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "fin='" + fin + '\'' +
                ", password=" + password +
                '}';
    }
}
