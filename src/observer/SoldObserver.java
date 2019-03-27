package observer;

import bank.Account;

import java.util.Observable;
import java.util.Observer;

public class SoldObserver implements Observer {

    private int sold;

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer) {
            sold = ((Integer) arg).intValue();
            System.out.println("S-a efectuat o modificare a soldului pentru persoana cu id-ul: " + ((Account) o).getPersonId() + ", noul sold este " + sold + ".");
        }
    }
}
