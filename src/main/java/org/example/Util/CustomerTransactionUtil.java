package org.example.Util;

import org.example.Enum.Status;
import org.example.Enum.TransactionType;
import org.example.FIleUtil.CardFileUtil;
import org.example.FIleUtil.CustomerTransactionFileUtil;
import org.example.Model.Card;
import org.example.Model.CustomerInfo;
import org.example.Model.Db;
import org.example.Model.Transaction;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CustomerTransactionUtil {


    public static void transferMoney() {
        Scanner scanner = new Scanner(System.in);
//        CustomerTransactionFileUtil.checkFileTransactionInfo();
        Card yourCard = null;
        if(!howManyCards()){
            System.out.print("Kartinizin son 8 reqemin daxil edin: ");
            yourCard = cardIdentification(scanner.nextLong());
        }
        else{
            for (Card card : Db.cards) {
                if (card != null && card.getStatus() != Status.INACTIVE && card.getCustomer().getFin().equals(CustomerInfoUtil.getFin())) {
                    yourCard = card;
                    break;
                }
            }
        }
        if (yourCard== null) {
            return;
        }
        System.out.print("Kocurme etdiyiniz kart nomresini yazin: ");
        long otherCardNumber = scanner.nextLong();

        //kartin yoxlanmasi
        System.out.print("Meblegi daxil edin: ");
        double amount = scanner.nextDouble();
        try {
            if (amount < 0) {
                throw new ArithmeticException("Duzgun mebleg daxil edin!");
            }
        long yourCardFirstFour = Long.parseLong(String.valueOf(yourCard.getNumber()).substring(0, 4));
        long otherCardFirtFour = Long.parseLong(String.valueOf(otherCardNumber).substring(0, 4));
        try {
            if (amount > yourCard.getAmount()) {
                throw new ArithmeticException("Kifayet qeder balans yoxdur");
            } else if (yourCardFirstFour == otherCardFirtFour) {
                Card otherCard = checkOtherCardNumber(otherCardNumber);
                if(null== otherCard){
                    System.out.println("Bizim bankin bele bir musterisi yoxdur.Xahis olunur duzgun kart nomresi daxil edin!");
                    return;
                }
                yourCard.setAmount(yourCard.getAmount() - amount);
                otherCard.setAmount(otherCard.getAmount()+amount);
               //
                CardFileUtil.writeFileCard(Db.cards);
                System.out.println("Emeliyyat ugurludur.");
                LocalDateTime currentDateTime = LocalDateTime.now();
                DbUtil.addTransactionInfo(new Transaction(TransactionType.CARD_TO_CARD,currentDateTime,String.valueOf(yourCard.getNumber()), String.valueOf(otherCardNumber),  amount));
                CustomerTransactionFileUtil.writeFileTransactionInfo(Db.transactionInfo);
                currentBalance(yourCard);
            } else {
                yourCard.setAmount(yourCard.getAmount() - (amount + (amount * 5 / 100)));
                CardFileUtil.writeFileCard(Db.cards);
                System.out.println("Emeliyyat ugurludur.");
                LocalDateTime currentDateTime = LocalDateTime.now();
                DbUtil.addTransactionInfo(new Transaction(TransactionType.CARD_TO_CARD,currentDateTime,String.valueOf(yourCard.getNumber()), String.valueOf(otherCardNumber),  amount));
                CustomerTransactionFileUtil.writeFileTransactionInfo(Db.transactionInfo);
                currentBalance(yourCard);
            }
        } catch (ArithmeticException e) {
            System.err.println("Xeta bas verdi! " + e.getMessage());
        }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Card cardIdentification(long lastCardNumber) {
//        Db.cards = CardFileUtil.returnFileCard();
        for (Card card : Db.cards) {
            if (card != null && card.getNumber() % 100000000L == lastCardNumber && card.getCustomer().getFin().equals(CustomerInfoUtil.getFin())) {
                return card;
            }
        }
        System.out.println("Daxil etdiyniz kart nomreniz yanlisdir.");
        return null;
    }

    public static void payment() {
//        CustomerTransactionFileUtil.checkFileTransactionInfo();
        Scanner scanner = new Scanner(System.in);
        Card yourCard= null;
        if(!howManyCards()){
            System.out.print("Kartinizin son 8 reqemin daxil edin: ");
            yourCard = cardIdentification(scanner.nextLong());
        }
        else{
            for (Card card : Db.cards) {
                if (card != null && card.getStatus() != Status.INACTIVE && card.getCustomer().getFin().equals(CustomerInfoUtil.getFin())) {
                    yourCard = card;
                    break;
                }
            }
        }
        System.out.print("Telefon nomresin daxil edin: ");
        String phoneNumber = scanner.next();
        System.out.print("Odenis meblegi daxil edin: ");
        double amount = scanner.nextDouble();
        try {
            if (amount < 0) {
                throw new ArithmeticException("Duzgun mebleg daxil edin!");
            }
            try{
                if (amount > yourCard.getAmount()) {
                    throw new ArithmeticException("Kifayet qeder balans yoxdur");
                }else{
                    yourCard.setAmount(yourCard.getAmount() - amount);
                    CardFileUtil.writeFileCard(Db.cards);
                    System.out.println("Emeliyyat ugurludur.");
                    LocalDateTime currentDateTime = LocalDateTime.now();
                   DbUtil.addTransactionInfo(new Transaction(TransactionType.CARD_TO_NUMBER,currentDateTime,String.valueOf(yourCard.getNumber()),phoneNumber,amount));
//                    DbUtil.addTransactionInfo(yourCard.getNumber(), phoneNumber, currentDateTime, amount);
                    CustomerTransactionFileUtil.writeFileTransactionInfo(Db.transactionInfo);
                    currentBalance(yourCard);
                }

            }
            catch (ArithmeticException e){
                System.err.println("Xeta bas verdi!!! " + e.getMessage());
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }

    }

    public static boolean howManyCards() {
//        Db.cards = CardFileUtil.returnFileCard();
        int index = 0;
        for (Card card : Db.cards) {
            if (card != null && card.getStatus() != Status.INACTIVE && card.getCustomer().getFin().equals(CustomerInfoUtil.getFin())) {
                index++;
            }
        }
        if (index == 1) {
            return true;
        }
        else{
            return false;
        }
    }
    public static Card checkOtherCardNumber(long otherCardNumber){
        for(Card card : Db.cards ){
            if(card!=null && card.getStatus()==Status.ACTIVE && card.getNumber().equals(otherCardNumber)){
                return card;
            }
        }
        return null;
    }

    public static void currentBalance(Card card) {
        System.out.println("Card number: " + card.getNumber() + " Balance: " + card.getAmount());
    }


}
