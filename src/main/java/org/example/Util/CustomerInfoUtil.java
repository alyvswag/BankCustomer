package org.example.Util;

import org.example.Enum.Status;
import org.example.FIleUtil.CardFileUtil;
import org.example.FIleUtil.CustomerInfoFileUtil;
import org.example.Model.Card;
import org.example.Model.Customer;
import org.example.Model.CustomerInfo;
import org.example.Model.Db;

import java.util.Arrays;
import java.util.Scanner;

import static org.example.Model.Db.cards;
import static org.example.Model.Db.customerInfos;

public class CustomerInfoUtil {
    private static String fin;

    public static void setFin(String fin) {
        CustomerInfoUtil.fin = fin;
    }

    public static String getFin() {
        return fin;
    }

    public static void signCustomer(){
//        Db.cards = CardFileUtil.returnFileCard();
//        CustomerInfoFileUtil.checkFileCustomerInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fin daxil edin: ");
        fin = scanner.next();
        System.out.print("Yeni password (example: 1234): ");
        String password = scanner.next();
        for(CustomerInfo customerInfo : customerInfos){
            if(customerInfo!=null && customerInfo.getFin().equals(fin)){
                System.out.println("Sistemde bele bir musteri var.");
                return;
            }
        }
        for(Card card : cards ){
            if(card!=null && card.getCustomer().getFin().equals(fin) && card.getStatus().equals(Status.ACTIVE)){
                DbUtil.addCustomerInformation( new CustomerInfo(fin,password));
                CustomerInfoFileUtil.writeFileCustomerInfo(customerInfos);
                System.out.println("Hesab yaradildi.");
                CustomerUtil.customerMainOperation();
                return;
            }
        }
        System.out.println("Error! Sehf Fin!!! Dogru Fin daxil edin!");
        signCustomer();
    }

    public static void loginCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(customerInfos));
        System.out.print("Fin: ");
        String fin = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
//        for (Customer customer: Db.customers) {
//            if (customer != null && customer.getFin().equals(fin) && customer.getIsActive().equals(Status.INACTIVE)) {
//                System.out.println("Bu musteri sistemden silindiyi ");
//                return;
//            }
//        }
        for (CustomerInfo customerInfo: customerInfos) {
            if (customerInfo != null && customerInfo.getFin().equals(fin) && customerInfo.getPassword().equals(password)) {
                CustomerInfoUtil.setFin(fin);
                System.out.println("Giris ugurludur.");
                CustomerUtil.customerMainOperation();
                return;
            }
        }
        System.out.println("Fin ve yaxud sifre yanlisdir.");
        loginCustomer();
    }
    public static void forgotPassword(){
//        CustomerInfoFileUtil.checkFileCustomerInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zehmet olmasa fin daxil edin: ");
        String fin = scanner.next();
        System.out.print("Yeni parolunuzu daxil edin: ");
        String password= scanner.next();
        for(CustomerInfo customerInfo : customerInfos){
            if(customerInfo!=null && customerInfo.getFin().equals(fin)){
                customerInfo.setPassword(password);
                System.out.println("Parol ugurla deyisdirildi");
                CustomerInfoFileUtil.writeFileCustomerInfo(customerInfos);
                return;
            }
        }
        System.out.println("Daxil edilen fin e uygun istifadeci tapilmadi.");
    }


}
