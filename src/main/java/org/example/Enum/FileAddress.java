package org.example.Enum;

public enum FileAddress {
    CUSTOMERS_ADDRESS("C:\\Users\\Talib\\Documents\\BankEmployeeeProject\\customers.txt"),
    CUSTOMERS_LOGIN_INFORMATION("C:\\Users\\Talib\\Documents\\BankEmployeeeProject\\customersLoginInformation.txt"),
    CARDS_ADDRESS("C:\\Users\\Talib\\Documents\\BankEmployeeeProject\\cards.txt"),
    TRANSACTION_ADDRESS("C:\\Users\\Talib\\Documents\\BankEmployeeeProject\\transaction.txt"),
    ADMIN_ADDRESS("C:\\Users\\Talib\\Documents\\BankEmployeeeProject\\admin.txt");

    private final String address;

    FileAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}
