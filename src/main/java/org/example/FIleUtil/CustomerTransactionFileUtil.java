package org.example.FIleUtil;

import org.example.Enum.FileAddress;
import org.example.Model.CustomerInfo;
import org.example.Model.Db;
import org.example.Model.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerTransactionFileUtil {
    public static void writeFileTransactionInfo(Transaction[] transactionInfo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FileAddress.TRANSACTION_ADDRESS.getAddress());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(transactionInfo);//massivin texte yazilmasi
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
