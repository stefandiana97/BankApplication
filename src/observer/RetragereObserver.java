package observer;

import bank.Account;

import java.util.Observable;
import java.util.Observer;

public class RetragereObserver implements Observer {

    private int retragere;

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer) {
            retragere = ((Integer) arg).intValue();
            System.out.println("S-a efectuat o retragere pentru persoana cu id-ul:" + ((Account) o).getPersonId() + ", noul sold este " + retragere + ".");

        }
    }
}
