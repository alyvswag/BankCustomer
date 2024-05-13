package org.example.Util;

import org.example.Enum.FileAddress;
import org.example.Enum.Status;
import org.example.Model.Card;
import org.example.Model.CustomerInfo;
import org.example.Model.Db;
import org.example.Model.Transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;

public class DbUtil {
    public static void addCustomerInformation(CustomerInfo customerI) {
        Db.customerInfos[Db.indexCustomerInfo] = customerI;
    }
    public static void addTransactionInfo(Transaction transaction){
        Db.transactionInfo[Db.indexTranscationInfo] = transaction;
    }
    public static int checkFileIndex(Object[] objects){
        int index =1;
        for(Object object : objects) {
            if(object!=null){
                index++;
            }
        }
        return index;
    }
    public static Object checkFileOBject(FileAddress address ){
        try {
            File file = new File(address.getAddress());
            if (!file.exists() || file.length() == 0) {
                return null;
            }
            try (FileInputStream fileInputStream = new FileInputStream(address.getAddress());
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                try {
                    return  objectInputStream.readObject();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
