package observer;

import bank.Account;

import java.util.Observable;
import java.util.Observer;

public class DepunereObserver implements Observer {

    private int depunere;

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer) {
            depunere = ((Integer) arg).intValue();
            System.out.println("S-a efectuat o depunere pentru persoana cu id-ul: " + ((Account) o).getPersonId() + ", noul sold este " + depunere + ".");

        }
    }
}
