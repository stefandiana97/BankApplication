package GUI;

import bank.Account;
import bank.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class File {
    /**
     * This method is used to read data from file for deSerialization.
     *
     * @param file
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static HashMap<Person, ArrayList<Account>> deSerialization(String file) {

        HashMap<Person, ArrayList<Account>> bank = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            bank = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return bank;
    }

    /**
     * This method is used to write data to file for Serialization.
     *
     * @param file
     * @param bank
     * @throws IOException
     */
    public static void serialization(String file, HashMap<Person, ArrayList<Account>> bank) {


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(bank);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}