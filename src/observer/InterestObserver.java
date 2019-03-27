package observer;

import bank.Account;

import java.util.Observable;
import java.util.Observer;

public class InterestObserver implements Observer {

    private int interest;

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer) {
            interest = ((Integer) arg).intValue();
            System.out.println("S-a efectuat o modificare a dobanzii pentru persoana cu id-ul: " + ((Account) o).getPersonId() + ", noua dobanda este " + interest + ".");

        }
    }
}
