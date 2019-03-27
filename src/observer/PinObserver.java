package observer;

import bank.Account;

import java.util.Observable;
import java.util.Observer;

public class PinObserver implements Observer {

    private int pin;

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer) {
            pin = ((Integer) arg).intValue();
            System.out.println("S-a efectuat o modificare a pinului pentru persoana cu id-ul: " + ((Account) o).getPersonId() + ", noul pin este " + pin + ".");

        }
    }
}
