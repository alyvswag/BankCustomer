package org.example.FIleUtil;

import org.example.Enum.FileAddress;
import org.example.Model.Customer;
import org.example.Model.CustomerInfo;
import org.example.Model.Db;

import java.io.*;

public class CustomerInfoFileUtil {
    public static void writeFileCustomerInfo(CustomerInfo[] customerI) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FileAddress.CUSTOMERS_LOGIN_INFORMATION.getAddress());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(customerI);//massivin texte yazilmasi
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
