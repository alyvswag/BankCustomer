package org.example.Util;

import org.example.Enum.Status;
import org.example.FIleUtil.CardFileUtil;
import org.example.FIleUtil.CustomerInfoFileUtil;
import org.example.Menu.CustomerPanel;
import org.example.Model.Card;
import org.example.Model.Customer;
import org.example.Model.CustomerInfo;
import org.example.Model.Db;

import java.util.Scanner;

public class CustomerUtil  {
    public static void customerMainOperation(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(CustomerPanel.menu);
            System.out.print("Secim edin: ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    ownerCards();
                    break;
                case 2:
                    CustomerTransactionUtil.transferMoney();
                    break;
                case 3:
                    CustomerTransactionUtil.payment();
                    break;
                case 4:
                    changePassword();
                    break;
                default:
                    System.out.println("Qardas yanlis secim etdiniz...");
            }
        }
    }
    public static void ownerCards() {
        System.out.println("Sahib oldugunuz kartlar: ");
        for (Card card : Db.cards) {
            if (card != null && card.getStatus() != Status.INACTIVE && card.getCustomer().getFin().equals(CustomerInfoUtil.getFin())) {
                System.out.println("Card number: " + card.getNumber() + "  Balance: " + card.getAmount());
            }
        }
    }
    public static CustomerInfo currentCustomer() {
        String fin = CustomerInfoUtil.getFin();
        for (CustomerInfo customerInfo : Db.customerInfos) {
            if (customerInfo!= null && customerInfo.getFin().equals(fin)) {
                return customerInfo;
            }
        }
        return null;
    }
    public static void changePassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Yeni parolunuzu daxil edin: ");
        String password = scanner.next();
        CustomerInfo currentCustomer = currentCustomer();
        currentCustomer.setPassword(password);
        CustomerInfoFileUtil.writeFileCustomerInfo(Db.customerInfos);
        System.out.println("Parol ugurla deyisdirildi.");
    }


}
