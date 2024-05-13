package org.example.FIleUtil;

import org.example.Enum.FileAddress;
import org.example.Enum.Status;
import org.example.Model.Card;
import org.example.Model.Db;

import java.io.*;

public class CardFileUtil {
    public static void writeFileCard(Card[] cards) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FileAddress.CARDS_ADDRESS.getAddress());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(cards);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Card[] returnFileCard(){
        try {
            File file = new File(FileAddress.CARDS_ADDRESS.getAddress());
            if (!file.exists() || file.length() == 0) {
                System.out.println("File da kard melumati yoxdur!");
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(FileAddress.CARDS_ADDRESS.getAddress());
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                return (Card[]) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
