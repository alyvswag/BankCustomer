package org.example.Model;

import org.example.Enum.FileAddress;
import org.example.Util.DbUtil;

public abstract class Db {
    public static Customer[] customers ;
    public static int index ;
    public static Card[] cards;
    public static int indexCard ;
    public static CustomerInfo[] customerInfos ;
    public static int indexCustomerInfo;
    public static Transaction[] transactionInfo ;
    public static int indexTranscationInfo ;

    static {
        Customer[] customersInFile = (Customer[]) DbUtil.checkFileOBject(FileAddress.CUSTOMERS_ADDRESS);
        customers = customersInFile == null ? new Customer[30] : customersInFile;
        index = DbUtil.checkFileIndex(customers);

        Card[] cardInFile = (Card[]) DbUtil.checkFileOBject(FileAddress.CARDS_ADDRESS);
        cards = cardInFile == null ? new Card[30] : cardInFile;
        indexCard = DbUtil.checkFileIndex(cards);

        CustomerInfo[] customerInfoInFile = (CustomerInfo[]) DbUtil.checkFileOBject(FileAddress.CUSTOMERS_LOGIN_INFORMATION);
        customerInfos = customerInfoInFile == null ? new CustomerInfo[50] : customerInfoInFile;
        indexCustomerInfo = DbUtil.checkFileIndex(customerInfos);

        Transaction[] transactionInFile = (Transaction[]) DbUtil.checkFileOBject(FileAddress.TRANSACTION_ADDRESS);
        transactionInfo = transactionInFile == null ? new Transaction[50] : transactionInFile;
        indexTranscationInfo = DbUtil.checkFileIndex(transactionInfo);
    }

}
