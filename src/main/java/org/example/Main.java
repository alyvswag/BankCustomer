package org.example;

import org.example.FIleUtil.CustomerInfoFileUtil;
import org.example.Menu.CustomerPanel;
import org.example.Model.CustomerInfo;
import org.example.Util.CustomerInfoUtil;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.example.Model.Db");
        Scanner scanner = new Scanner(System.in);
        System.out.print(CustomerPanel.welcome);
        int option = scanner.nextInt();
        switch (option){
            case 1 :
                CustomerInfoUtil.signCustomer();
                break;
            case 2:
                CustomerInfoUtil.loginCustomer();
                break;
            case 3:
                CustomerInfoUtil.forgotPassword();
                break;
            default:
                System.out.println("Qardas yanlis secim etdiniz...");

        }
    }
}